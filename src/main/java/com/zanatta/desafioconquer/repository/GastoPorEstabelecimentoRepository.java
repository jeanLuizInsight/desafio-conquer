package com.zanatta.desafioconquer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.zanatta.desafioconquer.model.GastoPorEstabelecimento;

/**
 * Interface central para gerenciar os dados da entidade GastoPorEstabelecimento.
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 07/07/2021
 */
@Repository
public interface GastoPorEstabelecimentoRepository extends JpaRepository<GastoPorEstabelecimento, Long> {

}
