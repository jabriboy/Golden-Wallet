package com.senaicimatec.golden_wallet.Entities;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private String saldo;
    private ArrayList<Transacao> transacoes;

    public User(){}

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String saldo){
        this.username = username;
        this.password = password;
        this.saldo = saldo;
    }

    public String getUsername(){
        return this.username;
    }

    public void setPassword(String new_password){
        this.password = new_password;
    }

    public String getPassword(){
        return this.password;
    }

    public String getSaldo(){ return this.saldo; }

    public void addTransacoes(Transacao new_transacao){
        Double valor = Double.valueOf(new_transacao.getValor());
        Tipo tipo = new_transacao.getTipo();
        if(tipo.getDescription().equals("renda")){
            this.saldo = String.valueOf(Double.parseDouble(this.saldo) + valor);
        }
        else{
            this.saldo = String.valueOf(Double.parseDouble(this.saldo) - valor);
        }
        this.transacoes.add(new_transacao);
    }

    public ArrayList<Transacao> getTransacoes(){
        return this.transacoes;
    }

}
