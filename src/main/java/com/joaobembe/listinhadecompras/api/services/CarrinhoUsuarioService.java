package com.joaobembe.listinhadecompras.api.services;

import com.joaobembe.listinhadecompras.api.model.CarrinhoProduto;
import com.joaobembe.listinhadecompras.api.model.CarrinhoUsuario;
import com.joaobembe.listinhadecompras.api.repository.CarrinhoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class CarrinhoUsuarioService {

    Logger logger = Logger.getLogger(CarrinhoUsuarioService.class.getName());

    @Autowired
    CarrinhoUsuarioRepository repository;

    public List<CarrinhoUsuario> findAll() {
        logger.info("Findind all CarrinhoUsuarios");
        return repository.findAll();
    }
}
