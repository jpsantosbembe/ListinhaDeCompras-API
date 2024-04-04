package com.joaobembe.listinhadecompras.api.services;

import com.joaobembe.listinhadecompras.api.model.CarrinhoProduto;
import com.joaobembe.listinhadecompras.api.repository.CarrinhoProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class CarrinhoProdutoService {

    public Logger logger = Logger.getLogger(CarrinhoProdutoService.class.getName());

    @Autowired
    private CarrinhoProdutoRepository repository;

    public List<CarrinhoProduto> findAll() {
        logger.info("Findind all CarrinhoProdutos");
        return repository.findAll();
    }
}
