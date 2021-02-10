package com.zanatta.desafioconquer.io.rest.integracao.portalTransparencia;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.zanatta.desafioconquer.dto.TransacaoDTO;
import com.zanatta.desafioconquer.exception.portalTransparencia.ApiDadosCartoesException;
import com.zanatta.desafioconquer.vo.GastosPagamentoCartaoParamVO;

/**
 * Classe de testes unitários para PortalTransparenciaGovRest
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 05/02/2021
 */
@RunWith(SpringRunner.class)
public class PortalTransparenciaGovRestTest {

	@Autowired private PortalTransparenciaGovRest api;
	@Autowired private RestTemplate restTemplate;
	private MockRestServiceServer mockServer;
	private final ObjectMapper mapper = new ObjectMapper();

	@Test
	public void deveConverterJsonParaTransacaoDTO() throws IOException {
		// cenário
		final File inputFile = new File(this.getClass().getResource("/data.json").getFile());
		final String json = new String(Files.readAllBytes(inputFile.toPath()));
		final ObjectMapper mapper = new ObjectMapper();
		final ObjectReader reader = mapper.reader().forType(new TypeReference<TransacaoDTO>() {});

		// ação
		final TransacaoDTO dto = reader.readValue(json);

		// validação
		Assertions.assertNotNull(dto);
		Assertions.assertEquals("202525748", dto.getId());
	}

	// @Test
	public void deveBuscarGastosPorMeioDeCartaoDePagamentoParaUmIntervaloDeDatas() throws JsonProcessingException, URISyntaxException,
	ApiDadosCartoesException {
		// cenário
		final List<TransacaoDTO> transacaoList = new ArrayList<>();
		final GastosPagamentoCartaoParamVO vo = new GastosPagamentoCartaoParamVO();
		vo.setMesExtratoInicio("01/2020");
		vo.setMesExtratoFim("12/2020");
		final UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://www.portaltransparencia.gov.br/api-de-dados/cartoes")
				.queryParam("mesExtratoInicio", vo.getMesExtratoInicio())
				.queryParam("mesExtratoFim", vo.getMesExtratoFim());
		this.mockServer = MockRestServiceServer.createServer(this.restTemplate);
		this.mockServer.expect(ExpectedCount.once(), MockRestRequestMatchers.requestTo(builder.toUriString()))
		.andExpect(MockRestRequestMatchers.method(HttpMethod.GET))
		.andRespond(MockRestResponseCreators.withStatus(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(this.mapper.writeValueAsString(transacaoList)));

		// ação
		final List<TransacaoDTO> retorno = this.api.getGastosPorMeioDeCartaoDePagamento(vo);

		// validação
		// TODO: ajustar mock e validação
		Assertions.assertEquals(transacaoList, retorno);
	}
}
