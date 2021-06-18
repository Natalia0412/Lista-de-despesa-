import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PessoaDAO {
	
	public static void insert(Pessoa pessoa) {	
		// String com comando SQL
		String sql = "Insert Into Pessoa (cpf, dataNascimento, nome, email, peso) Values (?, ?, ?, ?, ?)";

		// Criação de objeto para execução de comandos SQL
		PreparedStatement comandoSQL;
		
		// Objeto para conexão com o BD
		Connection conn;
		// Criação de uma conexão com o BD
		Conexao conexao = new Conexao();
		conn = conexao.abrir();

		try {
			// Execução de instruções SQL
			comandoSQL = conn.prepareStatement(sql);
		
			// Set Parametro e executa
			comandoSQL.setString(1, pessoa.getCpf());
			comandoSQL.setDate(2, pessoa.getDataNascimento());
			comandoSQL.setString(3, pessoa.getNome());
			comandoSQL.setString(4, pessoa.getEmail());
			comandoSQL.setFloat(5, pessoa.getPeso());
			comandoSQL.executeUpdate();
			
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conexao.fechar(conn);
	}
	
	public static void update(Pessoa pessoa) {
		// String com comando SQL
		String sql = "Update Pessoa Set cpf=?, dataNascimento=?, nome=?, email=?, peso=? Where idPessoa=?";

		// Criação de objeto para execução de comandos SQL
		PreparedStatement comandoSQL;
		
		// Objeto para conexão com o BD
		Connection conn;
		// Criação de uma conexão com o BD
		Conexao conexao = new Conexao();
		conn = conexao.abrir();

		try {
			// Execução de instruções SQL
			comandoSQL = conn.prepareStatement(sql);
		
			// Set Parametro e executa
			comandoSQL.setString(1, pessoa.getCpf());
			comandoSQL.setDate(2, pessoa.getDataNascimento());
			comandoSQL.setString(3, pessoa.getNome());
			comandoSQL.setString(4, pessoa.getEmail());
			comandoSQL.setFloat(5, pessoa.getPeso());
			comandoSQL.setInt(6, pessoa.getIdPessoa());
			comandoSQL.executeUpdate();
			
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conexao.fechar(conn);
	}
	
	public static void delete(int idPessoa) {
		// String com comando SQL
		String sql = "Delete From Pessoa Where idPessoa = ?";

		// Criação de objeto para execução de comandos SQL
		PreparedStatement comandoSQL;
		
		// Objeto para conexão com o BD
		Connection conn;
		// Criação de uma conexão com o BD
		Conexao conexao = new Conexao();
		conn = conexao.abrir();

		try {
			// Execução de instruções SQL
			comandoSQL = conn.prepareStatement(sql);
		
			// Set Parametro e executa
			comandoSQL.setInt(1, idPessoa);
			comandoSQL.executeUpdate();
			
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conexao.fechar(conn);
	}
	
	public static Pessoa find(int idPessoa) {
		Pessoa pessoa = new Pessoa();
		// String com comando SQL
		String sql = "Select * From Pessoa Where idPessoa = ?";

		// Criação de objeto para execução de comandos SQL
		PreparedStatement comandoSQL;
		// Criação de um objeto para resultado de Select's
		ResultSet rs;

		// Objeto para conexão com o BD
		Connection conn;
		// Criação de uma conexão com o BD
		Conexao conexao = new Conexao();
		conn = conexao.abrir();

		try {
			// Execução de instruções SQL
			comandoSQL = conn.prepareStatement(sql);
		
			// Set Parametro e executa
			comandoSQL.setInt(1, idPessoa);
			rs = comandoSQL.executeQuery();
			
			if (rs.next()) { // lê uma linha do ResultSet
				pessoa.setIdPessoa(rs.getInt("idPessoa"));
				pessoa.setCpf(rs.getString("cpf"));
				pessoa.setDataNascimento(rs.getDate("dataNascimento"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setEmail(rs.getString("email"));
				pessoa.setPeso(rs.getFloat("peso"));
			}
			
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conexao.fechar(conn);
		return pessoa;
	}
	
	public static ArrayList<Pessoa> getAll() {
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		// String com comando SQL
		String sql = "Select * From Pessoa";

		// Criação de objeto para execução de comandos SQL
		PreparedStatement comandoSQL;
		// Criação de um objeto para resultado de Select's
		ResultSet rs;

		// Objeto para conexão com o BD
		Connection conn;
		// Criação de uma conexão com o BD
		Conexao conexao = new Conexao();
		conn = conexao.abrir();

		try {
			// Execução de instruções SQL
			comandoSQL = conn.prepareStatement(sql);
		
			// Set Parametro e executa
			rs = comandoSQL.executeQuery();
			
			while (rs.next()) { // lê uma linha do ResultSet
				Pessoa pessoa = new Pessoa();
				pessoa.setIdPessoa(rs.getInt("idPessoa"));
				pessoa.setCpf(rs.getString("cpf"));
				pessoa.setDataNascimento(rs.getDate("dataNascimento"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setEmail(rs.getString("email"));
				pessoa.setPeso(rs.getFloat("peso"));
				pessoas.add(pessoa);
			}
			
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conexao.fechar(conn);
		return pessoas;
	}

	public static void insertDespesa(int idPessoa, Despesa despesa) {
		// String com comando SQL
		String sql = "Insert Into DespesaPessoa (idPessoa, descrDespesa, dataDespesa, idTipo, valor) Values (?, ?, ?, ?, ?)";

		// Criação de objeto para execução de comandos SQL
		PreparedStatement comandoSQL;
		
		// Objeto para conexão com o BD
		Connection conn;
		// Criação de uma conexão com o BD
		Conexao conexao = new Conexao();
		conn = conexao.abrir();

		try {
			// Execução de instruções SQL
			comandoSQL = conn.prepareStatement(sql);
		
			// Set Parametro e executa
			comandoSQL.setInt(1, idPessoa);
			comandoSQL.setString(2, despesa.getDescr());
			comandoSQL.setDate(3, despesa.getData());
			comandoSQL.setInt(4, despesa.getTipoDespesa().getIdTipo());
			comandoSQL.setFloat(5, despesa.getValor());
			comandoSQL.executeUpdate();
			
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conexao.fechar(conn);		
	}

	public static void UpdateDespesa(Despesa despesa) {
		// String com comando SQL
		String sql = "Update DespesaPessoa set descrDespesa=?, dataDespesa=?, idTipo=?, valor=? Where idDespesa=?";

		// Criação de objeto para execução de comandos SQL
		PreparedStatement comandoSQL;
		
		// Objeto para conexão com o BD
		Connection conn;
		// Criação de uma conexão com o BD
		Conexao conexao = new Conexao();
		conn = conexao.abrir();

		try {
			// Execução de instruções SQL
			comandoSQL = conn.prepareStatement(sql);
		
			// Set Parametro e executa
			comandoSQL.setString(1, despesa.getDescr());
			comandoSQL.setDate(2, despesa.getData());
			comandoSQL.setInt(3, despesa.getTipoDespesa().getIdTipo());
			comandoSQL.setFloat(4, despesa.getValor());
			comandoSQL.setInt(5, despesa.getIdDespesa());
			comandoSQL.executeUpdate();
			
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conexao.fechar(conn);		
	}
	
	public static ArrayList<Despesa> getAllDespesa(int idPessoa){
		ArrayList<Despesa> despesas = new ArrayList<Despesa>();
		// String com comando SQL
		String sql = 
				"Select " + 
				" dp.idDespesa," + 
				" dp.descrDespesa," + 
				" dp.idTipo," + 
				" td.descrTipo," + 
				" dp.dataDespesa," + 
				" dp.valor " + 
				"From DespesaPessoa dp " + 
				"Inner Join TipoDespesa td On td.idTipo = dp.idTipo " + 
				"Where dp.idPessoa=?";

		// Criação de objeto para execução de comandos SQL
		PreparedStatement comandoSQL;
		// Criação de um objeto para resultado de Select's
		ResultSet rs;

		// Objeto para conexão com o BD
		Connection conn;
		// Criação de uma conexão com o BD
		Conexao conexao = new Conexao();
		conn = conexao.abrir();

		try {
			// Execução de instruções SQL
			comandoSQL = conn.prepareStatement(sql);

			// Set Parametro e executa
			comandoSQL.setInt(1, idPessoa);
			rs = comandoSQL.executeQuery();
			
			while (rs.next()) { // lê uma linha do ResultSet
				Despesa despesa = new Despesa();
				despesa.setIdDespesa(rs.getInt("idDespesa"));
				despesa.setDescr(rs.getString("descrDespesa"));
				despesa.setData(rs.getDate("dataDespesa"));
				despesa.setTipoDespesa(new TipoDespesa(rs.getInt("idTipo"), rs.getString("descrTipo")));
				despesa.setValor(rs.getFloat("valor"));
				despesas.add(despesa);
			}
			
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conexao.fechar(conn);
		return despesas;		
	}

	public static void deleteDespesa(int idDespesa) {
		// String com comando SQL
		String sql = "Delete From DespesaPessoa Where idDespesa = ?";

		// Criação de objeto para execução de comandos SQL
		PreparedStatement comandoSQL;
		
		// Objeto para conexão com o BD
		Connection conn;
		// Criação de uma conexão com o BD
		Conexao conexao = new Conexao();
		conn = conexao.abrir();

		try {
			// Execução de instruções SQL
			comandoSQL = conn.prepareStatement(sql);
		
			// Set Parametro e executa
			comandoSQL.setInt(1, idDespesa);
			comandoSQL.executeUpdate();
			
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conexao.fechar(conn);
	}
}