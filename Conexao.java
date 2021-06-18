import java.sql.*;
public class Conexao {
	public Connection abrir() {
		// Cria objeto para conexão com BD
		Connection conn;
		try {
			// Verifica se existe o driver para o projeto
			Class.forName("org.sqlite.JDBC");  // SQLite
			//Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL
			//System.out.println("Driver JDBC encontrado!!!");
			// Cria um URL - Endereço para conexão com o BD
			String pathBD = System.getProperty("user.dir").replace("\\", "/");
			String bdUrl = "jdbc:sqlite:"+pathBD+"/bd/poo.db";
			//String bdUrl = "jdbc:mysql://localhost:3306/poo?useTimezone=true&serverTimezone=UTC";
			//System.out.println(bdUrl);
			// Cria conexão com o BD
			conn = DriverManager.getConnection(bdUrl);
			//conn = DriverManager.getConnection(bdUrl,"ale","ale");
			//System.out.println("Conexão Aberta!!!");
			return conn;
		} catch (ClassNotFoundException e) {
			System.out.println("Driver JDBC NÃO encontrado!!!");
			return null;
		} catch (SQLException e) {
			System.out.println("Problemas na conexão!!!"+e.getMessage());
			return null;
		}
		
	}
	
	public void fechar(Connection conn) {
		try {
			conn.close();
			//System.out.println("Conexão fechada com sucesso!!!");
		} catch (SQLException e) {
			System.out.println("Erro no fechamento da conexão!!!"+e.getMessage());
		}
	}
}
