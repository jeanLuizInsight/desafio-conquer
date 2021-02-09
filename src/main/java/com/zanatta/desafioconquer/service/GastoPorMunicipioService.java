package com.zanatta.desafioconquer.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zanatta.desafioconquer.dto.TransacaoDTO;
import com.zanatta.desafioconquer.model.GastoPorMunicipio;
import com.zanatta.desafioconquer.repository.GastoPorMunicipioRepository;

/**
 * Manager com as regras para dados da entidade GastoPorMunicipio
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 09/02/2021
 */
@Service
public class GastoPorMunicipioService {

	@Autowired GastoPorMunicipioRepository gastoPorMunicipioRepository;

	@Transactional
	public List<GastoPorMunicipio> saveGastoPorMunicipio(final List<TransacaoDTO> dadosApi) {
		final List<GastoPorMunicipio> dadosPersistencia = new ArrayList<>();

		return dadosPersistencia;
	}
}
