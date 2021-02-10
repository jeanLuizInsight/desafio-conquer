package com.zanatta.desafioconquer.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zanatta.desafioconquer.dto.MunicipioDTO;
import com.zanatta.desafioconquer.dto.TransacaoDTO;
import com.zanatta.desafioconquer.model.GastoPorMunicipio;
import com.zanatta.desafioconquer.model.GastosPagamentoCartaoParam;
import com.zanatta.desafioconquer.repository.GastoPorMunicipioRepository;
import com.zanatta.desafioconquer.repository.GastosPagamentoCartaoParamRepository;

/**
 * Manager com as regras para dados da entidade GastoPorMunicipio
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 09/02/2021
 */
@Service
public class GastoPorMunicipioService {

	@Autowired private GastoPorMunicipioRepository gastoPorMunicipioRepository;
	@Autowired private GastosPagamentoCartaoParamRepository gastosPagamentoCartaoParamRepository;

	@Transactional
	public List<GastoPorMunicipio> saveGastoPorMunicipio(final List<TransacaoDTO> dadosApi, final GastosPagamentoCartaoParam param) {
		final Map<MunicipioDTO, List<TransacaoDTO>> map = this.agruparDadosApiPorMunicipio(dadosApi);
		final List<GastoPorMunicipio> dadosPersistencia = this.getGastoPorMunicipio(map, param);
		this.gastosPagamentoCartaoParamRepository.save(param);
		this.gastoPorMunicipioRepository.saveAll(dadosPersistencia);
		return dadosPersistencia;
	}

	/**
	 * Realiza o agrupamento dos registros retornados pela API por municipio.
	 * @param dadosApi
	 * @return
	 */
	private Map<MunicipioDTO, List<TransacaoDTO>> agruparDadosApiPorMunicipio(final List<TransacaoDTO> dadosApi) {
		return dadosApi.stream().collect(Collectors.groupingBy(dto -> dto.getEstabelecimento().getMunicipio()));
	}

	/**
	 * Realiza a instancia da lista de gasto por municipio a ser persistida.
	 * @param map
	 * @param param
	 * @return
	 */
	private List<GastoPorMunicipio> getGastoPorMunicipio(final Map<MunicipioDTO, List<TransacaoDTO>> map, final GastosPagamentoCartaoParam param) {
		final List<GastoPorMunicipio> dadosPersistencia = new ArrayList<>();
		map.forEach((k, v) -> {
			final GastoPorMunicipio gpm = new GastoPorMunicipio();
			gpm.setGastosPagamentoCartaoParam(param);
			gpm.setCodigoIBGE(k.getCodigoIBGE());
			gpm.setNomeIBGE(k.getNomeIBGE());
			gpm.setPais(k.getPais());
			gpm.setUfNome(k.getUf().getNome());
			gpm.setUfSigla(k.getUf().getSigla());
			gpm.setValorTotal(this.calcularValorTotalDasTransacoesPorMunicipio(v));
			dadosPersistencia.add(gpm);
		});
		return dadosPersistencia;
	}

	/**
	 * Realiza a soma do valor de todas as transacoes para um municipio.
	 * @param transacoesPorMunicipio
	 * @return
	 */
	private BigDecimal calcularValorTotalDasTransacoesPorMunicipio(final List<TransacaoDTO> transacoesPorMunicipio) {
		return transacoesPorMunicipio.stream()
				.map(TransacaoDTO::getValorTransacaoNumber)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}
}
