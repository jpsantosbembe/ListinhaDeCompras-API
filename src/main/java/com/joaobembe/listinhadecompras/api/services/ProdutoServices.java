package com.joaobembe.listinhadecompras.api.services;

import com.joaobembe.listinhadecompras.api.model.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class ProdutoServices {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(ProdutoServices.class.getName());

    public Produto create(Produto produto) {
        logger.info("Creating one Product");
        return produto;
    }
    public Produto update(Produto produto) {
        logger.info("Updating one Product");
        return produto;
    }
    public void delete(String id) {
        logger.info("Deleting one Product");
    }
    public List<Produto> findAll(){
        List<Produto> produtos = new ArrayList<>();
        logger.info("Finding all Product");
        for (int i = 0; i < 8 ; i++){
            Produto produto = mockProduto();
            produtos.add(produto);
        }
        return produtos;
    }
    public Produto findById(String id) {
        logger.info("Finding one Product");
        Produto produto = new Produto();
        produto.setId(counter.incrementAndGet());
        produto.setCodigoGtinEan("Teste " + produto.getId());
        produto.setDescricao("Descrição: " + produto.getId());
        produto.setImgURL("http:// " + produto.getId());
        return produto;
    }
    private Produto mockProduto() {
        Produto produto = new Produto();
        produto.setId(counter.incrementAndGet());
        produto.setCodigoGtinEan("Teste " + counter.get());
        produto.setDescricao("Descrição: " + counter.get());
        produto.setImgURL("http:// " + counter.get());
        return produto;
    }


}
