package com.joaobembe.listinhadecompras.api.services;

import com.joaobembe.listinhadecompras.api.exception.ResourceNotFoundException;
import com.joaobembe.listinhadecompras.api.model.Produto;
import com.joaobembe.listinhadecompras.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class ProdutoServices {
    private Logger logger = Logger.getLogger(ProdutoServices.class.getName());
    @Autowired
    ProdutoRepository repository;
    public Produto create(Produto produto) {
        logger.info("Creating one Product");
        return repository.save(produto);
    }
    public Produto update(Produto produto) {
        logger.info("Updating one Product");
        Produto entity = repository.findById(produto.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID. Cam not update"));
        entity.setCodigoGtinEan(produto.getCodigoGtinEan());
        entity.setDescricao(produto.getDescricao());
        entity.setImgURL(produto.getImgURL());
        return repository.save(entity);
    }
    public void delete(Long id) {
        logger.info("Deleting one Product");
        Produto entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID. Can not delete"));
        repository.delete(entity);
    }
    public List<Produto> findAll(){
        logger.info("Finding all Product");
        return repository.findAll();
    }
    public Produto findById(Long id) {
        logger.info("Finding one Product");
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
    }

}
