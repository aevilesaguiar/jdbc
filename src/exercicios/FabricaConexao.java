package exercicios;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static java.sql.DriverManager.getConnection;

public class FabricaConexao {



    public static Connection getConection(){

        try {
            Properties properties = getProperties();
            //informações para conexão com o BD
            final String url = properties.getProperty("banco.url");
            final String usuario = properties.getProperty("banco.usuario");
            final String senha = properties.getProperty("banco.senha");

            //se  passar por esse método quer dizer que a conexão foi efetuado
            //caso contrario ele dá uma exceção
            //CRIANDO CONEXÃO COM O BD
           return  DriverManager.getConnection(url, usuario,senha);
        }catch (SQLException | IOException e){
            throw new RuntimeException(e);
        }

    }

    private static Properties getProperties() throws IOException {
        Properties properties=new Properties();
        String path = "/conexao.properties";
       properties.load(FabricaConexao.class.getResourceAsStream(path));
       return properties;
    }
}
