package com.senaicimatec.golden_wallet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.senaicimatec.golden_wallet.Entities.User;
import com.senaicimatec.golden_wallet.db.DataInsertionHelper;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.Objects;


public class SignUp extends AppCompatActivity {

    DataInsertionHelper di = new DataInsertionHelper();

    ArrayList<User> ids = new ArrayList<User>();
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

                String nome = editNome.getText().toString();
                String paswd1 = editPassword1.getText().toString();
                String paswd2 = editPassword2.getText().toString();

                int last_id = ids.get(-1).getId();

                di.inserirUsuario(new User(last_id + 1, nome, paswd1));

            }
        });

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int id = 0;
                for (DataSnapshot current_user : snapshot.child("Usuarios").getChildren()) {
                    id = Integer.parseInt(Objects.requireNonNull(current_user.getKey()));
                    String username = Objects.requireNonNull(current_user.child(current_user.getKey()).child("username").getValue()).toString();
                    String password = Objects.requireNonNull(current_user.child(current_user.getKey()).child("password").getValue()).toString();
                    User u = new User(id, username, password);
                    ids.add(u);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}