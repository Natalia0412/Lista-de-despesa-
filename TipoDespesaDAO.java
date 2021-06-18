import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class TipoDespesaDAO {
	public static void insert(TipoDespesa tipoDespesa) {
		// String com comando SQL
		String sql = "Insert Into TipoDespesa (descrTipo) Values (?)";

		// Cria��o de objeto para execu��o de comandos SQL
		PreparedStatement comandoSQL;
		
		// Objeto para conex�o com o BD
		Connection conn;
		// Cria��o de uma conex�o com o BD
		Conexao conexao = new Conexao();
		conn = conexao.abrir();

		try {
			// Execu��o de instru��es SQL
			comandoSQL = conn.prepareStatement(sql);
		
			// Set Parametro e executa
			comandoSQL.setString(1, tipoDespesa.getDescrTipo());
			comandoSQL.executeUpdate();
			
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conexao.fechar(conn);
	}
	
	public static void update(TipoDespesa tipoDespesa) {
		// String com comando SQL
		String sql = "Update TipoDespesa Set descrTipo=? Where idTipo=?";

		// Cria��o de objeto para execu��o de comandos SQL
		PreparedStatement comandoSQL;
		
		// Objeto para conex�o com o BD
		Connection conn;
		// Cria��o de uma conex�o com o BD
		Conexao conexao = new Conexao();
		conn = conexao.abrir();

		try {
			// Execu��o de instru��es SQL
			comandoSQL = conn.prepareStatement(sql);
		
			// Set Parametro e executa
			comandoSQL.setString(1, tipoDespesa.getDescrTipo());
			comandoSQL.setInt(2, tipoDespesa.getIdTipo());
			comandoSQL.executeUpdate();
			
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conexao.fechar(conn);
	}
	
	public static void delete(int idTipo) {
		// String com comando SQL
		String sql = "Delete From TipoDespesa Where idTipo = ?";

		// Cria��o de objeto para execu��o de comandos SQL
		PreparedStatement comandoSQL;
		
		// Objeto para conex�o com o BD
		Connection conn;
		// Cria��o de uma conex�o com o BD
		Conexao conexao = new Conexao();
		conn = conexao.abrir();

		try {
			// Execu��o de instru��es SQL
			comandoSQL = conn.prepareStatement(sql);
		
			// Set Parametro e executa
			comandoSQL.setInt(1, idTipo);
			comandoSQL.executeUpdate();
			
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conexao.fechar(conn);
	}
	
	public static TipoDespesa find(int idTipo) {
		TipoDespesa tipoDespesa = new TipoDespesa();
		// String com comando SQL
		String sql = "Select idTipo, descrTipo From TipoDespesa Where idTipo = ?";

		// Cria��o de objeto para execu��o de comandos SQL
		PreparedStatement comandoSQL;
		// Cria��o de um objeto para resultado de Select's
		ResultSet rs;

		// Objeto para conex�o com o BD
		Connection conn;
		// Cria��o de uma conex�o com o BD
		Conexao conexao = new Conexao();
		conn = conexao.abrir();

		try {
			// Execu��o de instru��es SQL
			comandoSQL = conn.prepareStatement(sql);
		
			// Set Parametro e executa
			comandoSQL.setInt(1, idTipo);
			rs = comandoSQL.executeQuery();
			
			if (rs.next()) { // l� uma linha do ResultSet
				tipoDespesa.setIdTipo(rs.getInt("idTipo"));
				tipoDespesa.setDescrTipo(rs.getString("descrTipo"));
			}
			
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conexao.fechar(conn);
		
		return tipoDespesa;
	}

	public static ArrayList<TipoDespesa> getAll() {
		ArrayList<TipoDespesa> tipoDespesas = new ArrayList<TipoDespesa>();
		// String com comando SQL
		String sql = "Select idTipo, descrTipo From TipoDespesa";

		// Cria��o de objeto para execu��o de comandos SQL
		PreparedStatement comandoSQL;
		// Cria��o de um objeto para resultado de Select's
		ResultSet rs;

		// Objeto para conex�o com o BD
		Connection conn;
		// Cria��o de uma conex�o com o BD
		Conexao conexao = new Conexao();
		conn = conexao.abrir();

		try {
			// Execu��o de instru��es SQL
			comandoSQL = conn.prepareStatement(sql);
		
			// Executa SQL
			rs = comandoSQL.executeQuery();
			
			while (rs.next()) { // l� uma linha do ResultSet
				TipoDespesa tipoDespesa = new TipoDespesa();
				tipoDespesa.setIdTipo(rs.getInt("idTipo"));
				tipoDespesa.setDescrTipo(rs.getString("descrTipo"));
				tipoDespesas.add(tipoDespesa);
			}
			
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conexao.fechar(conn);
		
		return tipoDespesas;
	}

}
