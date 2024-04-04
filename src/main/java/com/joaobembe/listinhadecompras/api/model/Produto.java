package com.joaobembe.listinhadecompras.api.model;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
//@Table(name = "PRODUTO")
public class Produto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String codigoGtinEan;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String imgURL;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<CarrinhoProduto> carrinhoProdutos = new ArrayList<>();

    public Produto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigoGtinEan() {
        return codigoGtinEan;
    }

    public void setCodigoGtinEan(String codigoGtinEan) {
        this.codigoGtinEan = codigoGtinEan;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return id == produto.id && Objects.equals(codigoGtinEan, produto.codigoGtinEan) && Objects.equals(descricao, produto.descricao) && Objects.equals(imgURL, produto.imgURL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigoGtinEan, descricao, imgURL);
    }
}
