package exercicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NovaPessoa {
    public static void main(String[] args) throws SQLException {


        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o nome");
        String nome = scanner.next();
        System.out.println(nome);

        Connection connection=FabricaConexao.getConection();

        String sql = "INSERT INTO pessoas (nome) VALUES (?)";
        PreparedStatement statement =connection.prepareStatement(sql);

        statement.setString(1,nome);
        statement.execute();
        System.out.println("Pessoa incluida com sucesso!");
        scanner.close();
    }
}
