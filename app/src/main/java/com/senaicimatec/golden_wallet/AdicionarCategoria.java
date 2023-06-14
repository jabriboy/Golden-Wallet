package com.senaicimatec.golden_wallet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.chip.Chip;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.senaicimatec.golden_wallet.Entities.Categoria;
import com.senaicimatec.golden_wallet.Entities.User;

import com.senaicimatec.golden_wallet.db.DataInsertionHelper;

import com.senaicimatec.golden_wallet.AdicionarTransacao;

import java.util.ArrayList;

public class AdicionarCategoria extends AppCompatActivity {

    String id = "";

    private EditText desc;

    public static ArrayList<Categoria> categorias = new ArrayList<Categoria>();

    DataInsertionHelper di = new DataInsertionHelper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_categoria);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

        Button btnAdicionarCategoria = (Button) findViewById(R.id.btnAdicionarCategoria);
        desc = (EditText) findViewById(R.id.editNomeCategoria);



        btnAdicionarCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user;
                if(SignUp.user != null){
                    user = SignUp.user;
                }
                else{
                    user = MainActivity.user;
                }
                int i = 0;
                for(User u: SignUp.ids){
                    i++;
                    if(u.getUsername().equals(user)){
                        id = String.valueOf(i);
                    }
                }
                String idTipo = null;
                if(AdicionarTransacao.chipGasto.isChecked()){
                    idTipo = "2";
                }
                else if(AdicionarTransacao.chipRenda.isChecked()){
                    idTipo = "1";
                }

                di.inserirCategoria(new Categoria(idTipo, desc.getText().toString()), id);
                Intent intent = new Intent(AdicionarCategoria.this,AdicionarTransacao.class);
                startActivity(intent);
            }
        });

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                System.out.println("called onDataChange");
                categorias.clear();
                for (DataSnapshot current_user: snapshot.child("Usuarios").child(id).child("Categorias").getChildren()) {

                    String tipo = current_user.child("tipo").getValue().toString();
                    String description = current_user.child("description").getValue().toString();

                    System.out.println(current_user);
                    Categoria c = new Categoria(tipo, description);

                    categorias.add(c);
                    System.out.println(categorias.size());
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}