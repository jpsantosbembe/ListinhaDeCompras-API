package com.joaobembe.listinhadecompras.api.controller;

import com.joaobembe.listinhadecompras.api.model.Produto;
import com.joaobembe.listinhadecompras.api.services.ProdutoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController{
    @Autowired
    private ProdutoServices services;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Produto create (@RequestBody() Produto produto){
        return services.create(produto);
    }
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Produto update (@RequestBody() Produto produto){
        return services.update(produto);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        services.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Produto> findAll() {
        return services.findAll();
    }
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Produto findById(@PathVariable("id") Long id) {
        return services.findById(id);
    }


}
