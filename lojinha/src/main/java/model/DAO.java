package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DAO {
	// Parâmetros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dblojinha?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "";

	// Conexão
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}
	
	public void inserirProduto(JavaBeans produto) {
		String SQLinsert = "insert into produtos(nome, quantidade, valor, vencimento, marca, categoria) values(?, ?, ?, ?, ?, ?);";
		
		try {
			Connection con = conectar();
			// Preparar a query
			PreparedStatement pst = con.prepareStatement(SQLinsert);
			
			// Substituir as ?
			pst.setString(1, produto.getNome());
			pst.setString(2, produto.getQuantidade());
			pst.setString(3, produto.getValor());
			pst.setString(4, produto.getVencimento());
			pst.setString(5, produto.getMarca());
			pst.setString(6, produto.getCategoria());
			
			// Executar SQL
			pst.executeUpdate();
			
			//Encerrar a conexão
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	// Teste de conexão
	public void testeConexao() {
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}
