package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {

    private static final String BANCO = "senai";
    private static final String USER = "root";
    private static final String PASSWD = "";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    private Conexao() {
    }

    public static Connection conectar() {
        Connection con = null;
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + BANCO, USER, PASSWD);
        } catch (SQLException e) { 
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }       
        return con;
    }

    public static void desconectar(Connection con) {
        try {
            con.close();           
        } catch (SQLException e) { 
            e.printStackTrace();
        }
    }

    public static Connection criarBanco() {
        Connection con = null;
        try {
            Class.forName(DRIVER);

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=" + USER + "&password=" + PASSWD);
            Statement statement = con.createStatement();
            statement.executeUpdate("create database if not exists " + BANCO);

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return con;

    }
}