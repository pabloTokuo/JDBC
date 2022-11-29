package application;

import db.DB;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {
    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DB.getConnection();
//            Inserir na tabela Seller nos campos de Nome,Email,BirthDate,Salary,DepartmentId, os valores Indefinidos(?)
            st = conn.prepareStatement("INSERT INTO seller " + "(Name, Email, Birthdate, BaseSalary, DepartmentId) " + "VALUES " + "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
//            Atribuindo os valores aos campos
            st.setString(1, "Pablo Tokuo");
            st.setString(2, "pablo@gmail.com");
            st.setDate(3, new java.sql.Date(sdf.parse("18/12/1996").getTime()));
            st.setDouble(4, 3000.0);
            st.setInt(5, 4);

//            Executar o update na tabela retorna um inteiro
            int rowsAffected = st.executeUpdate();
            if (rowsAffected > 0) {
//                rs para retornar o resultado da key add na tabela
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    System.out.println("Done! Id = " + id);
                }
            }

        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }

    }
}
