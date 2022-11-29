package application;

import db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {
    public static void main(String[] args) {

//        Iniciar como Nulo
        Connection conn = null;
//        Statement serve para montar um comando SQL para ser executado
        Statement st = null;
//        ResultSet representa um objeto contendo o resultado da consulta em forma de TABELA
        ResultSet rs = null;

        try {
//            Conectar conn com o banco de dados
            conn = DB.getConnection();
//            Statement para consultar tabela do banco de dados
            st = conn.createStatement();
//            Passando como argumento qual tabela acessar do banco de dados
            rs = st.executeQuery("select * from department");

//            rs.next move para o prox da tabela, e retorna falso se ja estive na ultima posicao
            while (rs.next()) {
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
            DB.closeConnection();
        }

    }
}
