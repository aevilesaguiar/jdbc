package exercicios;

public class PastaUsuario {
    public static void main(String[] args) {
        String userHomeDir = System.getProperty("user.home");
        System.out.printf("The User Home Directory is %s", userHomeDir);
    }
}
