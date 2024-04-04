package com.joaobembe.listinhadecompras.api.controller;

import com.joaobembe.listinhadecompras.api.model.Estabelecimento;
import com.joaobembe.listinhadecompras.api.services.EstabelecimentoService;
import com.joaobembe.listinhadecompras.api.services.ProdutoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estabelecimento")
public class EstabelecimentoController {
    @Autowired
    private EstabelecimentoService services;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Estabelecimento create (@RequestBody() Estabelecimento estabelecimento) {
        return services.create(estabelecimento);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Estabelecimento update (@RequestBody() Estabelecimento estabelecimento) {
        return services.update(estabelecimento);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        services.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Estabelecimento> findAll() {
        return services.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Estabelecimento findById(@PathVariable("id") Long id) {
        return services.findById(id);
    }
}
