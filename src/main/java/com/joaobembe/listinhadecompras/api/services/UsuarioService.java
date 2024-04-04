package com.joaobembe.listinhadecompras.api.services;

import com.joaobembe.listinhadecompras.api.exception.ResourceNotFoundException;
import com.joaobembe.listinhadecompras.api.model.Produto;
import com.joaobembe.listinhadecompras.api.model.Usuario;
import com.joaobembe.listinhadecompras.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class UsuarioService {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    UsuarioRepository repository;

    public Usuario create(Usuario usuario) {
        logger.info("Creating one usuario");
        return repository.save(usuario);
    }

    public Usuario update(Usuario usuario) {
        logger.info("Updating one usuario");
        Usuario entity = repository.findById(usuario.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID. Cam not update"));
        entity.setNome(usuario.getNome());
        entity.setEmail(usuario.getEmail());
        entity.setGoogleIdToken(usuario.getGoogleIdToken());
        return repository.save(entity);
    }

    public void delete(Long id) {
        logger.info("Deleting one Product");
        Usuario entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID. Can not delete"));
        repository.delete(entity);
    }

    public List<Usuario> findAll(){
        logger.info("Finding all Product");
        return repository.findAll();
    }

    public Usuario findById(Long id) {
        logger.info("Finding one Product");
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
    }
}
