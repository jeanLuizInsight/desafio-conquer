package com.zanatta.desafioconquer.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.zanatta.desafioconquer.dto.TransacaoDTO;
import com.zanatta.desafioconquer.exception.portalTransparencia.ApiDadosCartoesException;
import com.zanatta.desafioconquer.io.rest.integracao.portalTransparencia.PortalTransparenciaGovRest;
import com.zanatta.desafioconquer.model.GastoPorMunicipio;
import com.zanatta.desafioconquer.service.GastoPorMunicipioService;
import com.zanatta.desafioconquer.util.MessageUtil;
import com.zanatta.desafioconquer.vo.GastosPagamentoCartaoParamVO;

/**
 * Controller para a tela de consulta ao portal transparência
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 06/02/2021
 */
@Controller
@RequestMapping("/gastospagamentocartao")
public class GastosPagamentoCartaoController {

	@Autowired private MessageUtil messageUtil;
	@Autowired private PortalTransparenciaGovRest apiRest;
	@Autowired private GastoPorMunicipioService gastoPorMunicipioService;

	@GetMapping()
	public ModelAndView nova(final GastosPagamentoCartaoParamVO gastosPagamentoCartaoParamVO) {
		final ModelAndView mv = new ModelAndView("gastospagamentocartao/index");
		return mv;
	}

	@GetMapping("/consultar")
	public ResponseEntity<String> gerarConsulta(final HttpServletRequest request, final HttpServletResponse response,
			@Valid final GastosPagamentoCartaoParamVO gastosPagamentoCartaoParamVO, final BindingResult result) {
		if (result.hasErrors()) {
			return new ResponseEntity<>(this.messageUtil.getMessageErrorBindResult(result), HttpStatus.BAD_GATEWAY);
		}
		try {
			final List<TransacaoDTO> dadosApi = this.apiRest.getGastosPorMeioDeCartaoDePagamento(gastosPagamentoCartaoParamVO);
			if (CollectionUtils.isEmpty(dadosApi)) {
				return new ResponseEntity<>(this.messageUtil.getText("msg.api.dados.empty"), HttpStatus.BAD_GATEWAY);
			}
			final List<GastoPorMunicipio> dadosReport = this.gastoPorMunicipioService.saveGastoPorMunicipio(dadosApi,
					GastosPagamentoCartaoParamVO.buildGastosPagamentoCartaoParam(gastosPagamentoCartaoParamVO));
			response.setContentType("text/csv");
			response.setHeader("charset", "UTF-8");
			this.gerarArquivoCsv(response.getWriter(), dadosReport);
		} catch (final ApiDadosCartoesException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
		} catch (final Exception e) {
			return new ResponseEntity<>(this.messageUtil.getText("error.desconhecido"), HttpStatus.BAD_GATEWAY);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Método responsável por converter a lista de GastoPorMunicipio para arquivo no formato CSV.
	 * @param writer
	 * @param dados
	 * @throws IOException
	 */
	private void gerarArquivoCsv(final PrintWriter writer, final List<GastoPorMunicipio> dados) throws IOException {
		final CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(GastoPorMunicipio.getFieldsToCsv()));
		csvPrinter.printRecords(dados.stream()
				.map(GastoPorMunicipio::getValuesToCsv)
				.collect(Collectors.toList()));
		csvPrinter.flush();
	}
}
