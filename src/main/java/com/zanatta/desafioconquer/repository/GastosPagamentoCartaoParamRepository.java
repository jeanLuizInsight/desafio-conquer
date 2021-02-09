package com.zanatta.desafioconquer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.zanatta.desafioconquer.model.GastosPagamentoCartaoParam;

/**
 * Interface central para gerenciar os dados da entidade GastosPagamentoCartaoParam.
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 09/02/2021
 */
@Repository
public interface GastosPagamentoCartaoParamRepository extends JpaRepository<GastosPagamentoCartaoParam, Long> {

}
