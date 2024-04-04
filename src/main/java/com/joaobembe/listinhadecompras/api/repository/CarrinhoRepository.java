package com.joaobembe.listinhadecompras.api.repository;

import com.joaobembe.listinhadecompras.api.model.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
}
