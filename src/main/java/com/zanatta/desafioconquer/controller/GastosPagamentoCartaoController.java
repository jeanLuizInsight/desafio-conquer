package com.zanatta.desafioconquer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zanatta.desafioconquer.dto.TransacaoDTO;
import com.zanatta.desafioconquer.io.rest.integracao.portalTransparencia.PortalTransparenciaGovRest;
import com.zanatta.desafioconquer.vo.GastosPagamentoCartaoParamVO;

/**
 * Controller para a tela de consulta ao portal transparência
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 06/02/2021
 */
@Controller
@RequestMapping("/gastospagamentocartao")
public class GastosPagamentoCartaoController {
	
	@Autowired PortalTransparenciaGovRest apiRest;

	@GetMapping()
	public ModelAndView nova(GastosPagamentoCartaoParamVO gastosPagamentoCartaoParamVO) {
		ModelAndView mv = new ModelAndView("gastospagamentocartao/index");
		return mv;
	}
	
	@PostMapping("/consultar")
	public ModelAndView gerarConsulta(@Valid GastosPagamentoCartaoParamVO gastosPagamentoCartaoParamVO,  BindingResult result) {
		ModelAndView mv = this.nova(gastosPagamentoCartaoParamVO);
		if (result.hasErrors()) {
			return mv;
		}
		List<TransacaoDTO> dados = apiRest.getGastosPorMeioDeCartaoDePagamento(gastosPagamentoCartaoParamVO);
		mv.addObject(dados);
		return mv;
	}
	
}
