package com.zanatta.desafioconquer.io.rest.integracao.portalTransparencia;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zanatta.desafioconquer.dto.TransacaoDTO;
import com.zanatta.desafioconquer.vo.GastosPagamentoCartaoParamVO;

/**
 * Classe de testes unitários para PortalTransparenciaGovRest
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 05/02/2021
 */
@RunWith(SpringRunner.class)
public class PortalTransparenciaGovRestTest {

	@Autowired private PortalTransparenciaGovRest api;
	@Autowired RestTemplate restTemplate;
	private MockRestServiceServer mockServer;
	private final ObjectMapper mapper = new ObjectMapper();

	@Before
	public void init() {
		this.mockServer = MockRestServiceServer.createServer(this.restTemplate);
	}

	@Test
	public void deveBuscarGastosPorMeioDeCartaoDePagamentoParaUmIntervaloDeDatas() throws JsonProcessingException, URISyntaxException {
		// cenário
		final List<TransacaoDTO> transacaoList = new ArrayList<>();
		final GastosPagamentoCartaoParamVO vo = new GastosPagamentoCartaoParamVO();
		vo.setDataTransacaoInicio("01/02/2021");
		vo.setDataTransacaoFim("05/02/2021");
		this.mockServer.expect(ExpectedCount.once(), MockRestRequestMatchers.requestTo(new URI(
				"http://www.portaltransparencia.gov.br/api-de-dados/cartoes")))
				.andExpect(MockRestRequestMatchers.method(HttpMethod.GET))
				.andRespond(MockRestResponseCreators.withStatus(HttpStatus.OK)
						.contentType(MediaType.APPLICATION_JSON)
						.body(this.mapper.writeValueAsString(transacaoList)));

		// ação
		final List<TransacaoDTO> retorno = this.api.getGastosPorMeioDeCartaoDePagamento(vo);

		// validação
		this.mockServer.verify();
		Assertions.assertEquals(transacaoList, retorno);
	}
}
