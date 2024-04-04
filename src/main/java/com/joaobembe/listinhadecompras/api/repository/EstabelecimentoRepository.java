package com.joaobembe.listinhadecompras.api.repository;

import com.joaobembe.listinhadecompras.api.model.Estabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long> {
}
