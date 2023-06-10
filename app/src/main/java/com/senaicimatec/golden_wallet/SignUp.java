package com.senaicimatec.golden_wallet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.senaicimatec.golden_wallet.Entities.Transacao;
import com.senaicimatec.golden_wallet.Entities.User;
import com.senaicimatec.golden_wallet.db.DataInsertionHelper;

import java.util.ArrayList;
import java.util.Objects;


public class SignUp extends AppCompatActivity {

    DataInsertionHelper di = new DataInsertionHelper();

    public static ArrayList<User> ids = new ArrayList<User>();
    private EditText editNome;
    private EditText editPassword1;
    private EditText editPassword2;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

        editNome = (EditText) findViewById(R.id.editNome);
        editPassword1 = (EditText) findViewById(R.id.editPassword1);
        editPassword2 = (EditText) findViewById(R.id.editPassword2);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = editNome.getText().toString();
                String paswd1 = editPassword1.getText().toString();
                String paswd2 = editPassword2.getText().toString();
                int i = 0;
                if(paswd1.equals(paswd2)){
                    for(User u: ids){
                        if (u.getUsername().equals(username)) {
                            i = 1;
                            break;
                        }
                    }
                    if(i == 0){
                        di.inserirUsuario(new User(username, paswd1, "0.0"));
                        Intent intent = new Intent(SignUp.this,MainPage.class);
                        startActivity(intent);
                    }
                }
            }
        });

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ids.clear();
                for (DataSnapshot current_user : snapshot.child("Usuarios").getChildren()) {
                    String username = current_user.child("username").getValue().toString();
                    String password = current_user.child("password").getValue().toString();
                    String saldo = (current_user.child("saldo").getValue().toString());
                    User u = new User(username, password, saldo);

                    ids.add(u);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}