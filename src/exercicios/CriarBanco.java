package exercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBanco {
    public static void main(String[] args) throws SQLException {

        //criando conexão com o banco de daos
        Connection connection = FabricaConexao.getConection();

        //criando um objeto que irá conter os comandos sql
        Statement stmt = connection.createStatement();
        //criando o banco de dados
        stmt.execute("CREATE DATABASE IF NOT EXISTS curso_java");

        System.out.println("Banco criado com sucesso");

        connection.close();



    }
}
