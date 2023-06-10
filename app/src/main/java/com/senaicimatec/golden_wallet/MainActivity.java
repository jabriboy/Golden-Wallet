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
import com.senaicimatec.golden_wallet.SignUp;

public class MainActivity extends AppCompatActivity {

    private EditText editUsername;
    private EditText editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

        editUsername = (EditText) findViewById(R.id.editUsername);
        editPassword = (EditText) findViewById(R.id.editPassword);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        Button btnSignup = (Button) findViewById(R.id.btnSignup);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editUsername.getText().toString();
                String password = editPassword.getText().toString();

                for(User u: SignUp.ids){
                    if(u.getUsername().equals(username)){
                        if(u.getPassword().equals(password)){
                            Intent i = new Intent(MainActivity.this,MainPage.class);
                            startActivity(i);
                        }
                    }
                }

            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SignUp.class);
                startActivity(i);
            }
        });

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                SignUp.ids.clear();
                for (DataSnapshot current_user : snapshot.child("Usuarios").getChildren()) {
                    String username = current_user.child("username").getValue().toString();
                    String password = current_user.child("password").getValue().toString();
                    String saldo = (current_user.child("saldo").getValue().toString());
                    User u = new User(username, password, saldo);

                    SignUp.ids.add(u);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


}