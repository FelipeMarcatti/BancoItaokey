/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;

/**
 *
 * @author Lucas
 */
public class Conta {
    private int idConta;
    private Double saldo;
    private int idCliente;
    
    
    
    

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
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

 
    
    

    public void deposita(double saldo){
        this.saldo += saldo;
    }
    public void saque(double saldo){
        this.saldo -= saldo;
    }
    public void paga(double saldo){
        this.saldo -= saldo;
    }
    public void transfere(double saldo){
        this.saldo -= saldo;
    }
   /* public void extrato(double saldo){
        this.saldo -= saldo;
    } */

    
    
    
    
    


    @Override
    public String toString() {
        return "Conta{" + "idConta=" + idConta + ", saldo=" + saldo + ", idCliente=" + idCliente + '}';
    }

}