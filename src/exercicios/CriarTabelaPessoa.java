package exercicios;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelaPessoa {
    public static void main(String[] args) throws SQLException {
        Connection connection=FabricaConexao.getConection();

        String sql = " CREATE TABLE IF NOT EXISTS pessoas(" +
                "codigo INT AUTO_INCREMENT PRIMARY KEY," +
                "nome VARCHAR(80) NOT NULL" +
                ")";

        Statement  statement = connection.createStatement();
        statement.execute(sql);

        System.out.println("Tabela Criada com Sucesso!");

        connection.close();
    }
}
