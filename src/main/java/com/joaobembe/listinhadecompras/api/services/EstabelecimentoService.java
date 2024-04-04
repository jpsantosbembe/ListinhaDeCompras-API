package com.joaobembe.listinhadecompras.api.services;

import com.joaobembe.listinhadecompras.api.exception.ResourceNotFoundException;
import com.joaobembe.listinhadecompras.api.model.Estabelecimento;
import com.joaobembe.listinhadecompras.api.repository.EstabelecimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class EstabelecimentoService {

    private Logger logger = Logger.getLogger(EstabelecimentoService.class.getName());

    @Autowired
    EstabelecimentoRepository repository;

    public Estabelecimento create(Estabelecimento estabelecimento) {
        logger.info("Creating one Estabelecimento");
        return repository.save(estabelecimento);
    }

    public Estabelecimento update(Estabelecimento estabelecimento) {
        logger.info("Updating one Estabelecimento");
        Estabelecimento entity = repository.findById(estabelecimento.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID. Can not update"));
        entity.setId(estabelecimento.getId());
        entity.setNomeFantasia(estabelecimento.getNomeFantasia());
        entity.setLatitude(estabelecimento.getLatitude());
        entity.setLongitude(estabelecimento.getLongitude());
        return repository.save(entity);
    }

    public void delete (Long id) {
        logger.info("Deleting one Estabelecimento");
        Estabelecimento entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID. Can not update"));
        repository.delete(entity);
    }

    public List<Estabelecimento> findAll() {
        logger.info("Findind all Estabelecimentos");
        return repository.findAll();
    }

    public Estabelecimento findById(Long id) {
        logger.info("Findind one Estabelecimento");
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
    }
}
