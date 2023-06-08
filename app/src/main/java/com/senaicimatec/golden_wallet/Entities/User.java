package com.senaicimatec.golden_wallet.Entities;

import java.util.ArrayList;

public class User {
    private static int id;
    private String username;
    private String password;
    private Double saldo;
    private ArrayList<Transacao> transacoes;

    public User(){}

    public User(int id, String username, String password){
        User.id = id;
        this.username = username;
        this.password = password;
        this.saldo = 0.0;
        this.transacoes = null;
    }

    public User(int id, String username, String password, Double saldo){
        User.id = id;
        this.username = username;
        this.password = password;
        this.saldo = saldo;
        this.transacoes = null;
    }

    public User(int id, String username, String password, Double saldo, Transacao transacao){
        User.id = id;
        this.username = username;
        this.password = password;
        this.saldo = saldo;
        this.transacoes.add(transacao);
    }

    public int getId(){
        return User.id;
    }

    public void setUsername(String new_username){
        //check for double
        this.username = new_username;
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

    public void addTransacoes(Transacao new_transacao){
        this.transacoes.add(new_transacao);
    }

    public ArrayList<Transacao> getTransacoes(){
        return this.transacoes;
    }

}
