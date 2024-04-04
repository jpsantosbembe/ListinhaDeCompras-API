package com.joaobembe.listinhadecompras.api.controller;

import com.joaobembe.listinhadecompras.api.model.Carrinho;
import com.joaobembe.listinhadecompras.api.model.Produto;
import com.joaobembe.listinhadecompras.api.services.CarrinhoService;
import com.joaobembe.listinhadecompras.api.services.ProdutoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoService services;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Carrinho create (@RequestBody() Carrinho carrinho) {
        return services.create(carrinho);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Carrinho update (@RequestBody() Carrinho carrinho){
        return services.update(carrinho);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        services.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Carrinho> findAll() {
        return services.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Carrinho findById(@PathVariable("id") Long id) {
        return services.findById(id);
    }

}
