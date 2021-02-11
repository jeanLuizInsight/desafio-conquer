package com.zanatta.desafioconquer.io.rest.integracao.portalTransparencia;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.zanatta.desafioconquer.dto.TransacaoDTO;
import com.zanatta.desafioconquer.vo.GastosPagamentoCartaoParamVO;

/**
 * Classe de testes unitários para PortalTransparenciaGovRest
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 05/02/2021
 */
@SpringBootTest
public class PortalTransparenciaGovRestTest {

	@Autowired private PortalTransparenciaGovRest api;
	@Autowired private RestTemplate restTemplate;
	@Autowired private ObjectMapper mapper;
	private MockRestServiceServer mockServer;

	@BeforeEach
	public void init() {
		this.mockServer = MockRestServiceServer.createServer(this.restTemplate);
	}

	@Test
	public void deveConverterJsonParaTransacaoDTO() throws IOException {
		// cenário
		final File inputFile = new File(this.getClass().getResource("/data.json").getFile());
		final String json = new String(Files.readAllBytes(inputFile.toPath()));
		final ObjectReader reader = this.mapper.reader().forType(new TypeReference<TransacaoDTO>() {});

		// ação
		final TransacaoDTO dto = reader.readValue(json);

		// validação
		Assertions.assertNotNull(dto);
		Assertions.assertEquals("202525748", dto.getId());
	}

	@Test
	public void deveValidarRequisicaoParaEndPointGastosPorCartao() throws Exception {
		// cenário
		final GastosPagamentoCartaoParamVO vo = new GastosPagamentoCartaoParamVO();
		vo.setMesExtratoInicio("12/2020");
		vo.setMesExtratoFim("01/2021");
		final UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://www.portaltransparencia.gov.br/api-de-dados/cartoes")
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
		// gravando expectativa
		this.mockServer.expect(ExpectedCount.manyTimes(), MockRestRequestMatchers.requestTo(builder.toUriString()))
				.andExpect(MockRestRequestMatchers.method(HttpMethod.GET))
				.andRespond(MockRestResponseCreators.withStatus(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON));

		// ação
		final List<TransacaoDTO> retorno = this.api.getGastosPorMeioDeCartaoDePagamento(vo);

		// validação
		Assertions.assertTrue(CollectionUtils.isEmpty(retorno), "Lista retornada com registros!");
	}

}
