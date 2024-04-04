package com.joaobembe.listinhadecompras.api.repository;

import com.joaobembe.listinhadecompras.api.model.CarrinhoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoUsuarioRepository extends JpaRepository<CarrinhoUsuario, Long> {
}
