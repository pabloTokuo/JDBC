package application;

import db.DB;

import java.sql.Connection;

public class Program {
    public static void main(String[] args) {

//        Instaciando obj do tipo Connection para dar inicio no Banco de Dados
        Connection conn = DB.getConnection();
//        Fechando Banco de Dados
        DB.closeConnection();

    }
}
