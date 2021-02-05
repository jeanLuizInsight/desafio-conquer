package com.zanatta.desafioconquer.io.rest.integracao.portalTransparencia;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.zanatta.desafioconquer.dto.TransacaoDTO;
import com.zanatta.desafioconquer.vo.GastosPagamentoCartaoParamVO;

/**
 * Classe de representação consumer API Porta Transparência GOV Federal
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 05/02/2021
 */
@Component
public class PortalTransparenciaGovRest {

	@Value("${integracao.portal-transparencia.chave-acesso}") private String chaveDeAcesso;
	@Value("${integracao.portal-transparencia.endpoint-pagamentos-cartoes}") private String endPoint;
	@Autowired private RestTemplate restTemplate;

	public List<TransacaoDTO> getGastosPorMeioDeCartaoDePagamento(final GastosPagamentoCartaoParamVO vo) {
		List<TransacaoDTO> retorno = null;

		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("chave-api-dados", this.chaveDeAcesso);
		final HttpEntity<?> entity = new HttpEntity<>(headers);

		final UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(this.endPoint)
				.queryParam("mesExtratoInicio", vo.getMesExtratoInicio())
				.queryParam("mesExtratoFim", vo.getMesExtratoFim())
				.queryParam("dataTransacaoInicio", vo.getDataTransacaoInicio())
				.queryParam("dataTransacaoFim", vo.getDataTransacaoFim())
				.queryParam("tipoCartao", vo.getTipoCartao())
				.queryParam("codigoOrgao", vo.getCodigoOrgao())
				.queryParam("cpfPortador", vo.getCpfPortador())
				.queryParam("cpfCnpjFavorecido", vo.getCpfCnpjFavorecido())
				.queryParam("valorDe", vo.getValorDe())
				.queryParam("valorAte", vo.getValorAte())
				.queryParam("pagina", vo.getPagina());

		try {
			final ResponseEntity<String> getForEntity = this.restTemplate.exchange(builder.toUriString(),
					HttpMethod.GET,
					entity,
					String.class);

			if (getForEntity.getStatusCode().equals(HttpStatus.OK)) {
				final ObjectMapper mapper = new ObjectMapper();
				final ObjectReader reader = mapper.reader().forType(new TypeReference<List<TransacaoDTO>>() {});
				final String data = getForEntity.getBody();
				retorno = reader.readValue(data);
			}
		} catch (final JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retorno;
	}
}
