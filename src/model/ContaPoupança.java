/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Lucas
 */
public class ContaPoupança {
    private int idPoupanca;
    private Double saldo; //soma de todos os depositos
    private int idCliente;

    public ContaPoupança() {
        
    }

    public int getIdPoupanca() {
        return idPoupanca;
    }

    public void setIdPoupanca(int idPoupanca) {
        this.idPoupanca = idPoupanca;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "ContaPoupan\u00e7a{" + "idPoupanca=" + idPoupanca + ", saldo=" + saldo + ", idCliente=" + idCliente + '}';
    }

   

   
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.idPoupanca;
        return hash;
    }

}
