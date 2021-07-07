package com.zanatta.desafioconquer.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import com.zanatta.desafioconquer.dto.EstabelecimentoDTO;
import com.zanatta.desafioconquer.dto.TransacaoDTO;
import com.zanatta.desafioconquer.exception.portalTransparencia.ApiDadosCartoesException;
import com.zanatta.desafioconquer.io.rest.integracao.portalTransparencia.PortalTransparenciaGovRest;
import com.zanatta.desafioconquer.model.GastoPorEstabelecimento;
import com.zanatta.desafioconquer.model.GastosPagamentoCartaoParam;
import com.zanatta.desafioconquer.repository.GastoPorEstabelecimentoRepository;
import com.zanatta.desafioconquer.repository.GastosPagamentoCartaoParamRepository;
import com.zanatta.desafioconquer.util.MessageUtil;
import com.zanatta.desafioconquer.vo.GastosPagamentoCartaoParamVO;

/**
 * Manager com as regras para dados da entidade GastoPorMunicipio
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 09/02/2021
 */
@Service
public class GastoPorMunicipioService {

	@Autowired private GastoPorEstabelecimentoRepository gastoPorEstabelecimentoRepository;
	@Autowired private GastosPagamentoCartaoParamRepository gastosPagamentoCartaoParamRepository;
	@Autowired private PortalTransparenciaGovRest apiRest;
	@Autowired private MessageUtil messageUtil;

	@Transactional
	public List<GastoPorEstabelecimento> saveGastoPorMunicipio(final GastosPagamentoCartaoParamVO paramVO) throws ApiDadosCartoesException {
		final List<TransacaoDTO> dadosApi = this.apiRest.getGastosPorMeioDeCartaoDePagamento(paramVO);
		if (CollectionUtils.isEmpty(dadosApi)) {
			throw new ApiDadosCartoesException(this.messageUtil.getText("msg.api.dados.empty"));
		}
		final Map<EstabelecimentoDTO, List<TransacaoDTO>> map = this.agruparDadosApiPorEstabelecimento(dadosApi);
		final GastosPagamentoCartaoParam param = GastosPagamentoCartaoParamVO.buildGastosPagamentoCartaoParam(paramVO);
		final List<GastoPorEstabelecimento> dadosPersistencia = this.getGastoPorEstabelecimento(map, param);
		this.saveGastoPorEstabelecimento(param, dadosPersistencia);
		return dadosPersistencia;
	}

	private void saveGastoPorEstabelecimento(final GastosPagamentoCartaoParam param, final List<GastoPorEstabelecimento> dadosPersistencia) {
		this.gastosPagamentoCartaoParamRepository.save(param);
		this.gastoPorEstabelecimentoRepository.saveAll(dadosPersistencia);
	}

	/**
	 * Realiza o agrupamento dos registros retornados pela API por ESTABELECIMENTO.
	 * @param dadosApi
	 * @return
	 */
	private Map<EstabelecimentoDTO, List<TransacaoDTO>> agruparDadosApiPorEstabelecimento(final List<TransacaoDTO> dadosApi) {
		return dadosApi.stream().collect(Collectors.groupingBy(dto -> dto.getEstabelecimento()));
	}

	/**
	 * Realiza a instancia da lista de gasto por municipio a ser persistida.
	 * @param map
	 * @param param
	 * @return
	 */
	private List<GastoPorEstabelecimento> getGastoPorEstabelecimento(final Map<EstabelecimentoDTO, List<TransacaoDTO>> map,
			final GastosPagamentoCartaoParam param) {
		final List<GastoPorEstabelecimento> dadosPersistencia = new ArrayList<>();
		map.forEach((k, v) -> {
			final GastoPorEstabelecimento gpm = new GastoPorEstabelecimento();
			gpm.setCnpjFormatado(k.getCnpjFormatado());
			gpm.setCpfFormatado(k.getCpfFormatado());
			gpm.setId(k.getId());
			gpm.setNome(k.getNome());
			gpm.setNomeFantasiaReceita(k.getNomeFantasiaReceita());
			gpm.setNumeroInscricaoSocial(k.getNumeroInscricaoSocial());
			gpm.setRazaoSocialReceita(k.getRazaoSocialReceita());
			gpm.setTipo(k.getTipo());
			gpm.setGastosPagamentoCartaoParam(param);
			gpm.setValorTotal(this.calcularValorTotalDasTransacoesAgrupadas(v));
			dadosPersistencia.add(gpm);
		});
		return dadosPersistencia;
	}

	/**
	 * Realiza a soma do valor de todas as transacoes para um municipio.
	 * @param transacoesPorMunicipio
	 * @return
	 */
	private BigDecimal calcularValorTotalDasTransacoesAgrupadas(final List<TransacaoDTO> transacoesPorMunicipio) {
		return transacoesPorMunicipio.stream()
				.map(TransacaoDTO::getValorTransacaoNumber)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}
}
