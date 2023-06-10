package com.senaicimatec.golden_wallet.Entities;

public class Transacao {
    private String valor;
    private Tipo tipo;
    private Categoria categoria;

    public Transacao(){}

    public Transacao(String valor, Tipo tipo, Categoria categoria){
        this.valor = valor;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    public String getValor(){ return this.valor; }

    public Tipo getTipo(){ return this.tipo; }

}
