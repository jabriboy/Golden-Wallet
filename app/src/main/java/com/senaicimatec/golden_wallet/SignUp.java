package com.senaicimatec.golden_wallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.senaicimatec.golden_wallet.db.DatabaseHelper;
import com.senaicimatec.golden_wallet.db.DataInsertionHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SignUp extends AppCompatActivity {

    private EditText editNome;
    private EditText editPassword1;
    private EditText editPassword2;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

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

                Connection connection = null;
                int unique = 0;

                if(paswd1.equals(paswd2)) {
                    try {
                        connection = DatabaseHelper.getConnection();
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery("Select username form usuario");

                        while(resultSet.next()){
                            String user = resultSet.getString("username");
                            if(nome.equals(user)){
                                System.out.println("usuário ja cadastrado");
                                unique = 1;
                                break;
                            }
                        }
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                    if(unique == 0){
                        DataInsertionHelper.inserirDados(nome, paswd1);
                    }
                }
            }
        });

    }
}