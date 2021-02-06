package com.zanatta.desafioconquer.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zanatta.desafioconquer.vo.GastosPagamentoCartaoParamVO;

/**
 * Controller para a tela de consulta ao portal transparência
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 06/02/2021
 */
@Controller
@RequestMapping("/gastospagamentocartao")
public class GastosPagamentoCartaoController {

	@GetMapping()
	public ModelAndView nova(GastosPagamentoCartaoParamVO vo) {
		ModelAndView mv = new ModelAndView("gastospagamentocartao/index");
		return mv;
	}
	
	@PostMapping("/consultar")
	public ResponseEntity<byte[]> gerarConsulta(GastosPagamentoCartaoParamVO vo) throws Exception {
		byte[] relatorio = null;
		
		return ResponseEntity.ok()
				.body(relatorio);
	}
	
}
