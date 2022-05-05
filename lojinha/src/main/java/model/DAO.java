package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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

			// Encerrar a conexão
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

	// CRUD Read
	public ArrayList<JavaBeans> listaProdutos() {
		ArrayList<JavaBeans> produtos = new ArrayList<JavaBeans>();
		String sqlRead = "select * from Produtos order by nome";

		try {
			Connection con = conectar();
			// Preparar a query
			PreparedStatement pst = con.prepareStatement(sqlRead);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String idpro = rs.getString(1);
				String nome = rs.getString(2);
				String quantidade = rs.getString(3);
				String valor = rs.getString(4);
				String vencimento = rs.getString(5);
				String marca = rs.getString(6);
				String categoria = rs.getString(7);

				// enviando a matriz
				produtos.add(new JavaBeans(idpro, nome, quantidade, valor, vencimento, marca, categoria));
			}

			con.close();
			return produtos;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}

	public void selecionarProduto(JavaBeans produto) {
		String sqlSelect = "select * from produtos where idpro = ?";
		try {
			Connection con = conectar();
			// Preparar a query
			PreparedStatement pst = con.prepareStatement(sqlSelect);
			// Substituir os parâmetros
			pst.setString(1, produto.getIdpro());
			// Executar SQL
			ResultSet rs = pst.executeQuery();
			// Enquanto houver contatos
			while (rs.next()) {
				// Recebendo do banco
				produto.setIdpro(rs.getString(1));
				produto.setNome(rs.getString(2));
				produto.setQuantidade(rs.getString(3));
				produto.setValor(rs.getString(4));
				produto.setVencimento(rs.getString(5));
				produto.setMarca(rs.getString(6));
				produto.setCategoria(rs.getString(7));
			}

			// Encerrar a conexão
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

	public void alterarProduto(JavaBeans produto) {
		String sqlUpdate = "update produtos set nome = ?, quantidade = ?, valor = ?, vencimento = ?, marca = ?, categoria = ? where idpro = ?";
		try {
			Connection con = conectar();
			// Preparar a query
			PreparedStatement pst = con.prepareStatement(sqlUpdate);
			// Substituir os parâmetros
			pst.setString(1, produto.getNome());
			pst.setString(2, produto.getQuantidade());
			pst.setString(3, produto.getValor());
			pst.setString(4, produto.getVencimento());
			pst.setString(5, produto.getMarca());
			pst.setString(6, produto.getCategoria());
			pst.setString(7, produto.getIdpro());

			// Executar SQL
			pst.executeUpdate();
			// Encerar a conexão
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	// CRUD Delete
			public void deletarProduto(JavaBeans produto) {
				String sqlDelete = "delete from produtos where idpro = ?";
				try {
					Connection con = conectar();
					PreparedStatement pst = con.prepareStatement(sqlDelete);
					pst.setString(1, produto.getIdpro());
					pst.executeUpdate();
					con.close();
				} catch (Exception e) {
					// TODO: handle exception]
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
