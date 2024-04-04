package com.joaobembe.listinhadecompras.api.repository;

import com.joaobembe.listinhadecompras.api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
