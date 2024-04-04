package com.joaobembe.listinhadecompras.api.services;

import com.joaobembe.listinhadecompras.api.exception.ResourceNotFoundException;
import com.joaobembe.listinhadecompras.api.model.Carrinho;
import com.joaobembe.listinhadecompras.api.model.Estabelecimento;
import com.joaobembe.listinhadecompras.api.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class CarrinhoService {

    public Logger logger = Logger.getLogger(CarrinhoService.class.getName());

    @Autowired
    CarrinhoRepository repository;

    public Carrinho create(Carrinho carrinho) {
        logger.info("Creating one Carrinho");
        return repository.save(carrinho);
    }

    public Carrinho update(Carrinho carrinho) {
        logger.info("Updating one Carrinho");
        Carrinho entity = repository.findById(carrinho.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID. Can not update"));
        entity.setId(carrinho.getId());
        entity.setCriadoEm(carrinho.getCriadoEm());
        entity.setFechadoEm(carrinho.getFechadoEm());
        entity.setValorTotal(carrinho.getValorTotal());
        entity.setEstabelecimento(carrinho.getEstabelecimento());
        return repository.save(entity);
    }

    public void delete (Long id) {
        logger.info("Deleting one Estabelecimento");
        Carrinho entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID. Can not update"));
        repository.delete(entity);
    }

    public List<Carrinho> findAll() {
        logger.info("Findind all Estabelecimentos");
        return repository.findAll();
    }

    public Carrinho findById(Long id) {
        logger.info("Findind one Estabelecimento");
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
    }
}
