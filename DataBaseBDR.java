import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DataBaseBDR {
    private static UserAuthentication novoUsuario;
    private static UserAuthentication usuarioDB;
    

    public static void novoUsuario() throws SQLException {

	Scanner entrada = new Scanner(System.in);

	String login;
	String senha;

	System.out.println("Informe seu login:");
	login = entrada.nextLine();
	System.out.println("Informe sua senha:");
	senha = entrada.nextLine();

	novoUsuario = new UserAuthentication();
	novoUsuario.setLogin(login);
	novoUsuario.setSenha(senha);
	
	

	autenticacao();
    }

    public static boolean verificarUsuario() throws SQLException {
	final String query = "SELECT * FROM usuario WHERE login = ?";

	Connection conexao = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	try {

	    conexao = ConnectionDB.getConexao();
	    statement = conexao.prepareStatement(query);
	    statement.setString(1, novoUsuario.getLogin());

	    resultSet = statement.executeQuery();
	    while (resultSet.next()) {
		usuarioDB = new UserAuthentication();
		usuarioDB.setId(resultSet.getInt("id_usuario"));
		usuarioDB.setLogin(resultSet.getString("login"));
		usuarioDB.setSenha(resultSet.getString("senha"));
		usuarioDB.setNome(resultSet.getString("nome"));
		usuarioDB.setAdministrador(resultSet.getBoolean("administrador"));
	    }
	} finally {
	    try {
		if (resultSet != null) {
		    resultSet.close();
		}
		if (statement != null) {
		    statement.close();
		}
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	return true;

    }

    public static void autenticacao() {
	try {
	    verificarUsuario();
		if (novoUsuario.getLogin().equals(usuarioDB.getLogin())
			&& novoUsuario.getSenha().equals(usuarioDB.getSenha())) {
		    System.out.printf("Usuário %S código %d autenticado com sucesso!", usuarioDB.getNome(), usuarioDB.getId());

		}
	   
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
	
    }

}
