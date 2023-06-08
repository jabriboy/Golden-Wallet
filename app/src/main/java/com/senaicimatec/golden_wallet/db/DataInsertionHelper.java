package com.senaicimatec.golden_wallet.db;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.senaicimatec.golden_wallet.Entities.User;

public class DataInsertionHelper {
    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
    public void inserirUsuario(User user) {
        String id = String.valueOf(user.getId());
        reference.child("Usuarios").child(id).setValue(user);
    }
}
