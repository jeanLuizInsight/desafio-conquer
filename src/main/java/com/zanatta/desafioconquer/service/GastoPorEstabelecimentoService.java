package com.zanatta.desafioconquer.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zanatta.desafioconquer.model.GastoPorEstabelecimento;
import com.zanatta.desafioconquer.model.GastosPagamentoCartaoParam;
import com.zanatta.desafioconquer.repository.GastoPorEstabelecimentoRepository;
import com.zanatta.desafioconquer.repository.GastosPagamentoCartaoParamRepository;

/**
 * Service Manager com as regras de persistencia da entidade GastoPorestabelecimento
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 09/02/2021
 */
@Service
public class GastoPorEstabelecimentoService {

	@Autowired private GastoPorEstabelecimentoRepository gastoPorEstabelecimentoRepository;
	@Autowired private GastosPagamentoCartaoParamRepository gastosPagamentoCartaoParamRepository;

	@Transactional
	public void saveGastoPorEstabelecimento(final GastosPagamentoCartaoParam param, final List<GastoPorEstabelecimento> dadosPersistencia) {
		this.gastosPagamentoCartaoParamRepository.save(param);
		this.gastoPorEstabelecimentoRepository.saveAll(dadosPersistencia);
	}

}
