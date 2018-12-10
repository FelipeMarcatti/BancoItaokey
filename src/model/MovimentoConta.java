/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Lucas
 */
public class MovimentoConta {
    private int idMovimento;
    private Boolean tipoMovimento;
    private String descricao;
    private Double valor;
    private LocalDate data;
    private int idConta;
    
    public MovimentoConta() {}

    public int getIdMovimento() {
        return idMovimento;
    }

    public void setIdMovimento(int idMovimento) {
        this.idMovimento = idMovimento;
    }

    public Boolean getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(Boolean tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    @Override
    public String toString() {
        return "MovimentoConta{" + "idMovimento=" + idMovimento + ", tipoMovimento=" + tipoMovimento + ", descricao=" + descricao + ", valor=" + valor + ", data=" + data + ", idConta=" + idConta + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + this.idMovimento;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MovimentoConta other = (MovimentoConta) obj;
        if (this.idMovimento != other.idMovimento) {
            return false;
        }
        return true;
    }

 


   


    
}
