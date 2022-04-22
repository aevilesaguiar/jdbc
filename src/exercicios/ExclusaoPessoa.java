package exercicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExclusaoPessoa {
    public static void main(String[] args) throws SQLException {

        //criando conexão com o Bd
        Connection connection = FabricaConexao.getConection();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o código :");
        int codigo = scanner.nextInt();

        //String com o comando SQL a ser executado no banco
        String sql = "DELETE FROM pessoas WHERE codigo = ?";

        //Criando os objetos que irá conter os comandos SQL
        PreparedStatement preparedstatment =connection.prepareStatement(sql);
        preparedstatment.setInt(1, codigo);

        if(preparedstatment.executeUpdate()>0){
            System.out.println("Pessoa excluida com sucesso!");
        }else{
            System.out.println("Nada feito");
        }


        connection.close();
        scanner.close();
    }
}
