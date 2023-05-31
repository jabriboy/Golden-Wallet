package com.senaicimatec.golden_wallet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.senaicimatec.golden_wallet.db.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}