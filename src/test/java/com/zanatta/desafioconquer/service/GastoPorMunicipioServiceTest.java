package com.zanatta.desafioconquer.service;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.zanatta.desafioconquer.dto.MunicipioDTO;
import com.zanatta.desafioconquer.dto.TransacaoDTO;
import com.zanatta.desafioconquer.model.GastoPorMunicipio;
import com.zanatta.desafioconquer.model.GastosPagamentoCartaoParam;
import com.zanatta.desafioconquer.repository.GastoPorMunicipioRepository;
import com.zanatta.desafioconquer.repository.GastosPagamentoCartaoParamRepository;

/**
 * Classe de testes unitários para GastoPorMunicipioService
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 10/02/2021
 */
public class GastoPorMunicipioServiceTest {

	@InjectMocks @Spy private GastoPorMunicipioService gastoPorMunicipioService;
	@Mock private GastoPorMunicipioRepository gastoPorMunicipioRepository;
	@Mock private GastosPagamentoCartaoParamRepository gastosPagamentoCartaoParamRepository;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void deveAgruparDadosApiPorMunicipio() throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		// cenário
		final File inputFile = new File(this.getClass().getResource("/dataList.json").getFile());
		final String json = new String(Files.readAllBytes(inputFile.toPath()));
		final ObjectMapper mapper = new ObjectMapper();
		final ObjectReader reader = mapper.reader().forType(new TypeReference<List<TransacaoDTO>>() {});
		final List<TransacaoDTO> dados = reader.readValue(json);
		// tornando acessivel método privado
		final Class<GastoPorMunicipioService> clazz = GastoPorMunicipioService.class;
		final Method metodo = clazz.getDeclaredMethod("agruparDadosApiPorMunicipio", List.class);
		metodo.setAccessible(true);

		// ação
		final Map<MunicipioDTO, List<TransacaoDTO>> map = (Map<MunicipioDTO, List<TransacaoDTO>>) metodo.invoke(this.gastoPorMunicipioService, dados);

		// validação
		final MunicipioDTO dto = new MunicipioDTO();
		dto.setCodigoIBGE("4314902");
		Assertions.assertTrue(map.get(dto).size() == 2, "A regra não realizou o agrupamento da forma esperada!");
	}

	@Test
	public void deveConverterDtoDosRegistrosDaApiParaGastoPorMunicipio() throws IOException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// cenário
		final GastosPagamentoCartaoParam param = new GastosPagamentoCartaoParam();
		final File inputFile = new File(this.getClass().getResource("/dataList.json").getFile());
		final String json = new String(Files.readAllBytes(inputFile.toPath()));
		final ObjectMapper mapper = new ObjectMapper();
		final ObjectReader reader = mapper.reader().forType(new TypeReference<List<TransacaoDTO>>() {});
		final List<TransacaoDTO> dados = reader.readValue(json);
		final Map<MunicipioDTO, List<TransacaoDTO>> map = dados.stream()
				.collect(Collectors.groupingBy(dto -> dto.getEstabelecimento().getMunicipio()));
		// tornando acessivel método privado
		final Class<GastoPorMunicipioService> clazz = GastoPorMunicipioService.class;
		final Method metodo = clazz.getDeclaredMethod("getGastoPorMunicipio", Map.class, GastosPagamentoCartaoParam.class);
		metodo.setAccessible(true);

		// ação
		final List<GastoPorMunicipio> listaConvertida = (List<GastoPorMunicipio>) metodo.invoke(this.gastoPorMunicipioService, map, param);

		// validação
		Assertions.assertTrue(listaConvertida.size() == 7, "A regra não realizou a conversão do número de objetos esperado!");
	}

	@Test
	public void deveCalcularValorTotalDasTransacoesPorMunicipio() throws IOException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// cenário
		final File inputFile = new File(this.getClass().getResource("/dataList.json").getFile());
		final String json = new String(Files.readAllBytes(inputFile.toPath()));
		final ObjectMapper mapper = new ObjectMapper();
		final ObjectReader reader = mapper.reader().forType(new TypeReference<List<TransacaoDTO>>() {});
		final List<TransacaoDTO> dados = reader.readValue(json);
		// tornando acessiveel do método privado
		final Class<GastoPorMunicipioService> clazz = GastoPorMunicipioService.class;
		final Method metodo = clazz.getDeclaredMethod("calcularValorTotalDasTransacoesPorMunicipio", List.class);
		metodo.setAccessible(true);

		// acao
		final BigDecimal valor = (BigDecimal) metodo.invoke(this.gastoPorMunicipioService, dados);

		// verificacao
		MatcherAssert.assertThat(valor, CoreMatchers.is(new BigDecimal("12781.22")));
	}

	@Test
	public void deveSalvarGastoPorMunicipio() throws IOException {
		// cenário
		final GastosPagamentoCartaoParam param = new GastosPagamentoCartaoParam();
		final GastoPorMunicipio dadoRetorno = new GastoPorMunicipio();
		dadoRetorno.setCodigoIBGE("1600303");
		dadoRetorno.setGastosPagamentoCartaoParam(param);
		dadoRetorno.setNomeIBGE("MACAPÁ");
		dadoRetorno.setPais("BRASIL");
		dadoRetorno.setUfNome("AMAPÁ");
		dadoRetorno.setUfSigla("AP");
		dadoRetorno.setValorTotal(new BigDecimal("202.52"));
		final List<GastoPorMunicipio> listaRetorno = Arrays.asList(dadoRetorno);
		final File inputFile = new File(this.getClass().getResource("/data.json").getFile());
		final String json = new String(Files.readAllBytes(inputFile.toPath()));
		final ObjectMapper mapper = new ObjectMapper();
		final ObjectReader reader = mapper.reader().forType(new TypeReference<TransacaoDTO>() {});
		final TransacaoDTO dado = reader.readValue(json);
		final List<TransacaoDTO> dadoList = Arrays.asList(dado);

		// gravando a expectativa
		Mockito.when(this.gastoPorMunicipioService.saveGastoPorMunicipio(dadoList, param)).thenReturn(listaRetorno);

		// ação
		final List<GastoPorMunicipio> gmpList = this.gastoPorMunicipioService.saveGastoPorMunicipio(dadoList, param);

		// validação
		Assertions.assertTrue(gmpList.size() == 1, "Não gerou o número de registro corretamente!");
		MatcherAssert.assertThat(gmpList.get(0).getCodigoIBGE(), CoreMatchers.is("1600303"));
		MatcherAssert.assertThat(gmpList.get(0).getValorTotal(), CoreMatchers.is(new BigDecimal("202.52")));

	}
}
