import java.sql.*;
public class Conexao {
	public Connection abrir() {
		// Cria objeto para conex�o com BD
		Connection conn;
		try {
			// Verifica se existe o driver para o projeto
			Class.forName("org.sqlite.JDBC");  // SQLite
			//Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL
			//System.out.println("Driver JDBC encontrado!!!");
			// Cria um URL - Endere�o para conex�o com o BD
			String pathBD = System.getProperty("user.dir").replace("\\", "/");
			String bdUrl = "jdbc:sqlite:"+pathBD+"/bd/poo.db";
			//String bdUrl = "jdbc:mysql://localhost:3306/poo?useTimezone=true&serverTimezone=UTC";
			//System.out.println(bdUrl);
			// Cria conex�o com o BD
			conn = DriverManager.getConnection(bdUrl);
			//conn = DriverManager.getConnection(bdUrl,"ale","ale");
			//System.out.println("Conex�o Aberta!!!");
			return conn;
		} catch (ClassNotFoundException e) {
			System.out.println("Driver JDBC N�O encontrado!!!");
			return null;
		} catch (SQLException e) {
			System.out.println("Problemas na conex�o!!!"+e.getMessage());
			return null;
		}
		
	}
	
	public void fechar(Connection conn) {
		try {
			conn.close();
			//System.out.println("Conex�o fechada com sucesso!!!");
		} catch (SQLException e) {
			System.out.println("Erro no fechamento da conex�o!!!"+e.getMessage());
		}
	}
}
