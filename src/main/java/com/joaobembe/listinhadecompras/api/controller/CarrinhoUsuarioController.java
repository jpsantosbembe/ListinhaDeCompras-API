package com.joaobembe.listinhadecompras.api.controller;

import com.joaobembe.listinhadecompras.api.model.CarrinhoUsuario;
import com.joaobembe.listinhadecompras.api.services.CarrinhoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/carrinhousuario")
public class CarrinhoUsuarioController {

    @Autowired
    private CarrinhoUsuarioService services;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CarrinhoUsuario> findAll() {
        return services.findAll();
    }
}
