package com.joaobembe.listinhadecompras.api.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class CarrinhoUsuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idCarrinho")
    private Carrinho carrinho;

    @Column(nullable = false)
    private Date dataAssociacao;

    public CarrinhoUsuario() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public Date getDataAssociacao() {
        return dataAssociacao;
    }

    public void setDataAssociacao(Date dataAssociacao) {
        this.dataAssociacao = dataAssociacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarrinhoUsuario that = (CarrinhoUsuario) o;
        return id == that.id && Objects.equals(usuario, that.usuario) && Objects.equals(carrinho, that.carrinho) && Objects.equals(dataAssociacao, that.dataAssociacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuario, carrinho, dataAssociacao);
    }

}
