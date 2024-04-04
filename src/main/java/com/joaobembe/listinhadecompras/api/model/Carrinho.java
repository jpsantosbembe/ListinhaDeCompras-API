package com.joaobembe.listinhadecompras.api.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Carrinho implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private Date criadoEm;

    @Column(nullable = true)
    private Date fechadoEm;

    @Column(nullable = true)
    private double valorTotal;

    @ManyToOne
    @JoinColumn(name = "idEstabelecimento")
    private Estabelecimento estabelecimento;

    @OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL)
    private List<CarrinhoProduto> carrinhoProdutos = new ArrayList<>();

    public Carrinho() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(Date criadoEm) {
        this.criadoEm = criadoEm;
    }

    public Date getFechadoEm() {
        return fechadoEm;
    }

    public void setFechadoEm(Date fechadoEm) {
        this.fechadoEm = fechadoEm;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carrinho carrinho = (Carrinho) o;
        return id == carrinho.id && Double.compare(valorTotal, carrinho.valorTotal) == 0 && Objects.equals(criadoEm, carrinho.criadoEm) && Objects.equals(fechadoEm, carrinho.fechadoEm) && Objects.equals(estabelecimento, carrinho.estabelecimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, criadoEm, fechadoEm, valorTotal, estabelecimento);
    }
}
