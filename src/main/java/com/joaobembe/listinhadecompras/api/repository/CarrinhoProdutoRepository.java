package com.joaobembe.listinhadecompras.api.repository;

import com.joaobembe.listinhadecompras.api.model.CarrinhoProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoProdutoRepository extends JpaRepository<CarrinhoProduto, Long> {
}
