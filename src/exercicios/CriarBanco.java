package exercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBanco {
    public static void main(String[] args) throws SQLException {

        //conexão com o banco de dados jdbc

        final String url = "jdbc:mysql://localhost:3306/?verifyServerCertificate=false&useSSL=true";
        final String usuario = "root";
        final String senha = "Ussagui0637985";

        //se  passar por esse método quer dizer que a conexão foi efetuado
        //caso contrario ele dá uma exceção
        Connection connection= DriverManager.getConnection(url, usuario,senha);

        Statement stmt = connection.createStatement();
        stmt.execute("CREATE DATABASE IF NOT EXISTS curso_java");

        System.out.println("Banco criado com sucesso");

        connection.close();



    }
}
