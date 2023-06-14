package com.senaicimatec.golden_wallet.db;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.senaicimatec.golden_wallet.AdicionarCategoria;
import com.senaicimatec.golden_wallet.Entities.Categoria;
import com.senaicimatec.golden_wallet.Entities.Transacao;
import com.senaicimatec.golden_wallet.Entities.User;
import com.senaicimatec.golden_wallet.SignUp;

public class DataInsertionHelper {
    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
    public void inserirUsuario(User user) {
        String id;
        if(SignUp.ids.isEmpty()){
            id = "1";
        }
        else{
            id = String.valueOf(SignUp.ids.size() + 1);
        }
        reference.child("Usuarios").child(id).setValue(user);
    }

    public void inserirTransacao(Transacao transacao){

    }

    public void inserirCategoria(Categoria categoria, String idUser){
        String id;
        if(AdicionarCategoria.categorias.isEmpty()){
            id = "1";
        }
        else{
            id = String.valueOf(AdicionarCategoria.categorias.size() + 1);
        }
        System.out.println("id: " + id);
        reference.child("Usuarios").child(idUser).child("Categorias").child(id).setValue(categoria);
    }
}
