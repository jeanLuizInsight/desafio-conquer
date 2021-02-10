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
	public List<GastoPorMunicipio> saveGastoPorMunicipio(final List<TransacaoDTO> dadosApi, GastosPagamentoCartaoParam param) {
		final List<GastoPorMunicipio> dadosPersistencia = new ArrayList<>();

		// mapeando as transacoes por municipio
		final Map<MunicipioDTO, List<TransacaoDTO>> map = dadosApi.stream()
				.collect(Collectors.groupingBy(dto -> dto.getEstabelecimento().getMunicipio()));
		BigDecimal valorPorMunicipio = BigDecimal.ZERO;
		map.forEach((k, v) -> {
			v.forEach(dto -> {
				valorPorMunicipio.add(dto.getValorTransacaoNumber());
			});
			GastoPorMunicipio gpm = new GastoPorMunicipio();
			gpm.setGastosPagamentoCartaoParam(param);
			gpm.setCodigoIBGE(k.getCodigoIBGE());
			gpm.setNomeIBGE(k.getNomeIBGE());
			gpm.setPais(k.getPais());
			gpm.setUfNome(k.getUf().getNome());
			gpm.setUfSigla(k.getUf().getSigla());
			gpm.setValorTotal(valorPorMunicipio);
			dadosPersistencia.add(gpm);
		});
		gastosPagamentoCartaoParamRepository.save(param);
		gastoPorMunicipioRepository.saveAll(dadosPersistencia);
		return dadosPersistencia;
	}
}
