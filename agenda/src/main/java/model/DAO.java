package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	// Par�metros de conex�o
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "";

	// Conex�o
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

	public void inserirContato(JavaBeans contato) {
		String SQLinsert = "insert into contatos(nome, fone, email) values(?, ?, ?);";

		try {
			Connection con = conectar();
			// Preparar a query
			PreparedStatement pst = con.prepareStatement(SQLinsert);

			// Substituir as ?
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			/* pst.setString(4, contato.getObsPath()); */

			// Executar SQL
			pst.executeUpdate();

			// Encerrar a conex�o
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

	// CRUD Read
	public ArrayList<JavaBeans> listaContatos() {
		ArrayList<JavaBeans> contatos = new ArrayList<JavaBeans>();
		String sqlRead = "select * from contatos order by nome";

		try {
			Connection con = conectar();
			// Preparar a query
			PreparedStatement pst = con.prepareStatement(sqlRead);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);

				// enviando a matriz
				contatos.add(new JavaBeans(idcon, nome, fone, email));
			}

			con.close();
			return contatos;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}
	
	public void selecionarContato(JavaBeans contato) {
		String sqlSelect = "select * from contatos where idcon = ?";
		try {
			Connection con = conectar();
			// Preparar a query
			PreparedStatement pst = con.prepareStatement(sqlSelect);
			// Substituir os par�metros
			pst.setString(1, contato.getIdcon());
			// Executar SQL
			ResultSet rs = pst.executeQuery();
			// Enquanto houver contatos
			while (rs.next()) {
				// Recebendo do banco
				contato.setIdcon(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setFone(rs.getString(3));
				contato.setEmail(rs.getString(4));
			}
			
			// Encerrar a conex�o
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	public void alterarContato(JavaBeans contato) {
		String sqlUpdate = "update contatos set nome = ?, fone = ?, email = ? where idcon = ?";
		try {
			Connection con = conectar();
			// Preparar a query
			PreparedStatement pst = con.prepareStatement(sqlUpdate);
			// Substituir os par�metros
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.setString(4, contato.getIdcon());
			
			// Executar SQL
			pst.executeUpdate();
			// Encerar a conex�o
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	// CRUD Delete
		public void deletarContato(JavaBeans contato) {
			String sqlDelete = "delete from contatos where idcon = ?";
			try {
				Connection con = conectar();
				PreparedStatement pst = con.prepareStatement(sqlDelete);
				pst.setString(1, contato.getIdcon());
				pst.executeUpdate();
				con.close();
			} catch (Exception e) {
				// TODO: handle exception]
				System.out.println(e);
			}
		}

	// Teste de conex�o
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
