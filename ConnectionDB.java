import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

	private static final String URL = "jdbc:postgresql://localhost:5432/TesteBDR";
	    private static final String USUARIO = "postgres";
	    private static final String SENHA = "32823282";

	    private static Connection conexao;

	    private ConnectionDB() {
		// TODO Auto-generated constructor stub
	    } 
	    
	    public static Connection getConexao() throws SQLException {
		if (conexao == null) {
		    conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		}
		return conexao;
    }

}
