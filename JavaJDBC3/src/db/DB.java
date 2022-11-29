package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {

//    Metodo para conectar ou desconectar o banco de dados
    private static  Connection conn = null;

//    Metodo para iniciar conexao com o BD
    public static Connection getConnection() {
        if (conn == null) {
            try {
//                obj do tipo Properties recebe metodo loadProperties que é o local do arquivo
                Properties props = loadProperties();
//                obj url do tipo String recebe a propriedade de Props e como argumento a url do Banco de Dados
                String url = props.getProperty("dburl");
//                Metodo conn para conectar no banco de dados recebe DriverManager e como argumento a url do bd e o arquivo
                conn = DriverManager.getConnection(url, props);
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }

//    Metodo para fechar conexao com o banco de dados
    public static void closeConnection() {
//        Se conexao for diferente de nulo
        if (conn != null) {
            try {
//                Fechar arquivo
                conn.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }


//    Metodo do tipo Properties
//    Esse metodo vai localizar o arquivo com as propriedades para iniciar o banco de dados
    private static Properties loadProperties() {
//        Iniciando o arquivo e passando como argumento seu nome
        try (FileInputStream fs = new FileInputStream("db.properties")) {
//            Instanciando um obj do tipo Properties
            Properties props = new Properties();
//            Carregando o arquivo inicializado
            props.load(fs);
            return props;
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}
