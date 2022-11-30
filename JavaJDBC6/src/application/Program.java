package application;

import db.DB;
import db.DbException;

import java.sql.*;

public class Program {
    public static void main(String[] args) {

        Connection conn = null;
        Statement st = null;

        try {
            conn = DB.getConnection();

//            autoCommit false espera por confirmação do envio
            conn.setAutoCommit(false);

            st = conn.createStatement();

//            Executando update na tabela
            int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");

//            Caso ocorra uma Exception no meio da transação do commit, usar rollback no tratamento da exceção

//            int x = 1;
//            if (x < 2) {
//                throw new SQLException("Fake error!");
//            }

            int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");

//            Dando commit na transação
            conn.commit();

            System.out.println("Rows affected: " + rows1);
            System.out.println("Rows affected: " + rows2);
        } catch (SQLException e) {
            try {
//                Caso ocorra erro, voltar a transação pelo começo sem atualizar nada
                conn.rollback();
                throw new DbException(e.getMessage());

            } catch (SQLException ex) {
                throw new DbException(ex.getMessage());
            }
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }

    }
}
