package com.zanatta.desafioconquer.io.rest.integracao.portalTransparencia;

import java.net.URISyntaxException;
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
import com.fasterxml.jackson.databind.JsonMappingException;
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
	public void deveConverterJsonParaTransacaoDTO() throws JsonMappingException, JsonProcessingException {
		// cenário
		final String json =
				"{\"id\":202525741,\"mesExtrato\":\"02/2020\",\"dataTransacao\":\"23/01/2020\",\"valorTransacao\":\"99,89\",\"tipoCartao\":{\"id\":1,\"codigo\":\"1\",\"descricao\":\"Cartão de Pagamento do Governo Federal - CPGF\"},\"estabelecimento\":{\"numeroInscricaoSocial\":\"\",\"nome\":\"ROSANE & LAIS ATACADO E VAREJO LTDA\",\"razaoSocialReceita\":\"ROSANE & LAIS ATACADO E VAREJO LTDA\",\"nomeFantasiaReceita\":\"KI-CENTRAO\",\"cnae\":{\"codigoSecao\":\"G\",\"secao\":\"COMÉRCIO; REPARAÇÃO DE VEÍCULOS AUTOMOTORES E MOTOCICLETAS\",\"codigoSubclasse\":\"4641903\",\"subclasse\":\"Comércio atacadista de artigos de armarinho\",\"codigoDivisao\":\"46\",\"divisao\":\"COMÉRCIO POR ATACADO, EXCETO VEÍCULOS AUTOMOTORES E MOTOCICLETAS\",\"codigoGrupo\":\"464\",\"grupo\":\"Comércio atacadista de produtos de consumo não-alimentar\",\"codigoClasse\":\"46419\",\"classe\":\"Comércio atacadista de tecidos, artefatos de tecidos e de armarinho\"},\"municipio\":{\"codigoIBGE\":\"4208302\",\"nomeIBGE\":\"ITAPEMA\",\"pais\":\"BRASIL\",\"uf\":{\"sigla\":\"SC\",\"nome\":\"SANTA CATARINA\"}},\"localidadePessoa\":\"Municipal\",\"naturezaJuridica\":{\"codigo\":\"2062    \",\"descricao\":\"Sociedade Empresária Limitada\",\"codigoTipo\":\"2\",\"descricaoTipo\":\"Entidades Empresariais\"},\"dataAbertura\":\"21/06/2017\",\"enderecoEletronico\":\"KICENTRAO@HOTMAIL.COM\",\"numeroTelefone\":\"47  92584431 \",\"descricaoLogradouro\":\"AV NEREU RAMOS\",\"numeroEndereco\":\"90\",\"complementoEndereco\":\"\",\"numeroCEP\":\"        \",\"nomeBairro\":\"CENTRO\",\"codigoFormatado\":\"28.006.705/0001-35\",\"tipoCodigo\":\"CNPJ\",\"tipoPessoa\":\"Entidades Empresariais Privadas\"},\"unidadeGestora\":{\"codigo\":\"158460\",\"nome\":\"IF CATARINENSE - CAMPUS CAMBORIU\",\"orgaoVinculado\":{\"nome\":\"Instituto Federal Catarinense\",\"codigoSIAFI\":\"26422\",\"cnpj\":\"10635424000186\",\"sigla\":\"IFC\",\"descricaoPoder\":\"EXECUTIVO\",\"orgaoMaximo\":{\"codigo\":\"26000\",\"sigla\":\"MEC\",\"nome\":\"Ministério da Educação\"}}},\"portador\":{\"codigoFormatado\":\"***.314.500-**\",\"nome\":\"MARCEL AMARAL DAOUD\"}}";
		final ObjectMapper mapper = new ObjectMapper();
		final ObjectReader reader = mapper.reader().forType(new TypeReference<TransacaoDTO>() {});

		// ação
		final TransacaoDTO dto = reader.readValue(json);

		// validação
		Assertions.assertNotNull(dto);
		Assertions.assertEquals("202525741", dto.getId());
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
