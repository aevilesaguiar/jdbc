package exercicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdatePessoa {
    public static void main(String[] args) throws SQLException {

        //criando conexão com o Bd
        Connection connection = FabricaConexao.getConection();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o código da pessoa:");
        int codigo = scanner.nextInt();

        //String com o comando SQL a ser executado no banco
        String sqlSelect = "SELECT * FROM pessoas WHERE codigo = ?";
        String sqlUpdate = " UPDATE pessoas SET nome= ? WHERE codigo =?";
        //Criando os objetos que irá conter os comandos SQL
        PreparedStatement preparedstatment =connection.prepareStatement(sqlSelect);

        preparedstatment.setInt(1, codigo);

        //O objetivo é realizar uma consulta no BD vamos pegar o retorno e inicializar um objeto ResultSet, proprio para tratar o retorno de consultas
        ResultSet resultSet = preparedstatment.executeQuery();

        if(resultSet.next()){
            Pessoa p = new Pessoa(resultSet.getInt(1), resultSet.getString(2));
            System.out.println("O nome atual é: " + p.getNome());
            scanner.nextLine();

            System.out.println("Informe o novo nome  : ");
            String novoNome = scanner.nextLine();


            preparedstatment.close();

           preparedstatment=connection.prepareStatement(sqlUpdate);

           preparedstatment.setString(1, novoNome);
           preparedstatment.setInt(2, codigo);

           preparedstatment.executeUpdate();

            System.out.println("Pessoa alterada com sucesso!");
        }else {

            System.out.println("Pessoa não encontrada!");
            }

        scanner.close();
        connection.close();

    }
}
