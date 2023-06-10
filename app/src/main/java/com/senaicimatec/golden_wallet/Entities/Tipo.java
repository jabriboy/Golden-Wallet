package com.senaicimatec.golden_wallet.Entities;

public class Tipo {
    private String description;

    public Tipo(){}

    public Tipo(String description, String id){
        this.description = description;
    }

    public void setDescription(String new_description){ this.description = new_description; }

    public String getDescription(){
        return this.description;
    }

}
