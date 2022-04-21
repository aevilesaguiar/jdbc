package exercicios;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultarPessoas2 {

    public static void main(String[] args) throws SQLException {


        Scanner scanner= new Scanner(System.in);


        Connection connection=FabricaConexao.getConection();

        String sql = "SELECT * FROM pessoas WHERE nome like ?";

        System.out.println("Informe o valor para pesquisa: ");
        String perquisiteNome = scanner.nextLine();

        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setString(1, "%" + perquisiteNome + "%");

        ResultSet resultant= statement.executeQuery();

        List<Pessoa> pessoa = new ArrayList<>();

        while (resultant.next()){
            int codigo = resultant.getInt("codigo");
            String nome = resultant.getString("nome");
            pessoa.add(new Pessoa(codigo,nome));

        }

        for (Pessoa p:pessoa) {
            System.out.println(p.getCodigo()+"==>"+p.getNome());
        }
        statement.close();
        connection.close();
        scanner.close();

    }
    }



