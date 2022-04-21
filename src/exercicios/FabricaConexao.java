package exercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class FabricaConexao {



    public static Connection getConection(){

        try {
            //informações para conexão com o BD
            final String url = "jdbc:mysql://localhost:3306/curso_java?verifyServerCertificate=false&useSSL=true";
            final String usuario = "root";
            final String senha = "Ussagui0637985";

            //se  passar por esse método quer dizer que a conexão foi efetuado
            //caso contrario ele dá uma exceção
            //CRIANDO CONEXÃO COM O BD
           return  DriverManager.getConnection(url, usuario,senha);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
}
