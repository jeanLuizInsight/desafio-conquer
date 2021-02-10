package com.zanatta.desafioconquer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	@ResponseBody
	public ResponseEntity<String> gerarConsulta(final HttpServletRequest request,
			@Valid final GastosPagamentoCartaoParamVO gastosPagamentoCartaoParamVO, final BindingResult result) {
		if (result.hasErrors()) {
			return new ResponseEntity<>(messageUtil.getMessageErrorBindResult(result), HttpStatus.BAD_GATEWAY);
		}
		try {
			final List<TransacaoDTO> dadosApi = apiRest.getGastosPorMeioDeCartaoDePagamento(gastosPagamentoCartaoParamVO);
			final List<GastoPorMunicipio> dadosReport = gastoPorMunicipioService.saveGastoPorMunicipio(dadosApi,
					GastosPagamentoCartaoParamVO.buildGastosPagamentoCartaoParam(gastosPagamentoCartaoParamVO));

			// TODO: aqui fazer a geração pro csv.
			dadosReport.isEmpty();
		} catch (final ApiDadosCartoesException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
		} catch (Exception e) {
			return new ResponseEntity<>(messageUtil.getText("error.desconhecido"), HttpStatus.BAD_GATEWAY);
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
