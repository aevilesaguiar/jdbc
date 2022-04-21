package exercicios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConsultarPessoas1 {

    public static void main(String[] args) throws SQLException {

        //CRIAR CONEXÃO COM O BANCO DE DADOS
        Connection connection=FabricaConexao.getConection();

        //Temos também a PreparedStatement, que pré-compila o comando e armazena o SQL em um objeto.
        //CRIAR UM OBJETO QUE IRÁ CONTER OS COMANDOS SQL
        Statement statement=connection.createStatement();

        //String com o comando sql a ser executado no BD
        String sql = "SELECT * FROM pessoas";

        //Realizar consulta no BD , vamos pegar o retorno e inicializar um objeto ResultSet, proprio para tratar o retorno de consultas.
       ResultSet resultado= statement.executeQuery(sql);

       //Criar uma lista de pessoas
        List<Pessoa>pessoas = new ArrayList<>();

       while (resultado.next()){
           int codigo = resultado.getInt("codigo");
           String nome = resultado.getString("nome");
           pessoas.add(new Pessoa(codigo,nome));

    }

        for (Pessoa p:pessoas) {
            System.out.println(p.getCodigo()+"==>"+p.getNome());
        }
        //fechando o objeto
        statement.close();
        connection.close();

    }
}
