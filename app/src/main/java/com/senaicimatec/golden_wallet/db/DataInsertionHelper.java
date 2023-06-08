package com.senaicimatec.golden_wallet.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataInsertionHelper {
    public static boolean inserirDados(String nome, String paswd) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseHelper.getConnection();
            if (connection != null) {
                String query = "INSERT INTO usuarios (username, password) VALUES (?, ?)";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, nome);
                preparedStatement.setString(2, paswd);
                preparedStatement.executeUpdate();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
