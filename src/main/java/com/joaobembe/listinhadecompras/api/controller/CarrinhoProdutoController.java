package com.joaobembe.listinhadecompras.api.controller;

import com.joaobembe.listinhadecompras.api.model.CarrinhoProduto;
import com.joaobembe.listinhadecompras.api.model.Produto;
import com.joaobembe.listinhadecompras.api.services.CarrinhoProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/carrinhoprodutos")
public class CarrinhoProdutoController {

    @Autowired
    private CarrinhoProdutoService services;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CarrinhoProduto> findAll() {
        return services.findAll();
    }

}
