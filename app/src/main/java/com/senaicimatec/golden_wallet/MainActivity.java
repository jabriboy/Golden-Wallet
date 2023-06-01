package com.senaicimatec.golden_wallet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

import com.senaicimatec.golden_wallet.db.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    private EditText editUsername;
    private EditText editPassword;
    private Button btnLogin;
    private Button btnSignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUsername = (EditText) findViewById(R.id.editUsername);
        editPassword = (EditText) findViewById(R.id.editPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnSignup = (Button) findViewById(R.id.btnSignup);

        Connection connection = null;
        try {
            connection = DatabaseHelper.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select nome_conta from tb_conta");

            while (resultSet.next()) {
                String nome = resultSet.getString("nome_conta");
                System.out.println(nome);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editUsername.getText().toString();
                String password = editPassword.getText().toString();

                Connection connection = null;
                try {
                    connection = DatabaseHelper.getConnection();
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("Select user, password form tb_usuario");

                    while (resultSet.next()) {
                        String user = resultSet.getString("user");
                        if(Objects.equals(user, username)){
                            String password_bd = resultSet.getString("password");
                            if(Objects.equals(password_bd, password)){

                                System.out.println("Login feito com sucesso");
                                // ir para próxima página
                            }
                        }
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }

                System.out.println("Usuário ou senha errado");
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ir para a página de signup
            }
        });

    }
}