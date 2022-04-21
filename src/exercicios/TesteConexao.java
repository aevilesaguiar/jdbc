package exercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {

    public static void main(String[] args) throws SQLException {

        //conexão com o banco de dados jdbc

        final String url = "jdbc:mysql://localhost:3306/banco?verifyServerCertificate=false&useSSL=true";
        final String usuario = "root";
        final String senha = "Ussagui0637985";

        //se  passar por esse método quer dizer que a conexão foi efetuado
        //caso contrario ele dá uma exceção
        Connection connection= DriverManager.getConnection(url, usuario,senha);

        System.out.println("Conexão efetuada com sucesso!");
        connection.close();



    }
}
