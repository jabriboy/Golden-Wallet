package com.senaicimatec.golden_wallet.Entities;

public class Categoria {
    private Tipo tipo;
    private String description;

    public Categoria(){}

    public Categoria(Tipo tipo, String description){
        this.tipo = tipo;
        this.description = description;
    }

    public void setDescription(String new_description){ this.description = new_description; }

    public String getDescription(){
        return this.description;
    }

}
