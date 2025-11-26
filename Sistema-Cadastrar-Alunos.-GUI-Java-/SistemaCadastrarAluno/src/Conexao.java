import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    public static Connection getConnetion(){
        try{
            String url = "jdbc:mysql: //localhost:3306/cadastro";
            String user = "root"; // troque pelo seu usuário
            String password = ""; // troque pela sua senha
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new RuntimeException("Erro na conexão: " + e.getMessage());
        }
    }
}
