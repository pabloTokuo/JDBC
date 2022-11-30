package application;

import db.DB;
import db.DbIntegrityException;

import java.sql.*;

public class Program {
    public static void main(String[] args) {

        Connection conn = null;
//        Forma de fazer insercao no banco de dados mais segura onde vc prepara os parametros para serem inseridos.
        PreparedStatement st = null;
        try {
            conn = DB.getConnection();
//            Comando para deletar da tabela
            st = conn.prepareStatement("DELETE FROM department " + "WHERE " + "Id = ?");

            st.setInt(1, 2);

            int rowsAffected = st.executeUpdate();
            System.out.println("Done! Rows Affected: " + rowsAffected);

        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }

    }
}
