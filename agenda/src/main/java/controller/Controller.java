package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = { "/Controller", "/main", "/inserir", "/select", "/update", "/delete" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DAO dao = new DAO();
	JavaBeans contato = new JavaBeans();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		// Teste de conexão
		/*
		 * DAO dao = new DAO(); dao.testeConexao();
		 */
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			contatos(request, response);
		} else if (action.equals("/inserir")) {
			novoContato(request, response);
		} else if (action.equals("/select")) {
			listarContato(request, response);
		} else if (action.equals("/update")) {
			editarContato(request, response);
		} else if (action.equals("/delete")) {
			removerContato(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* response.sendRedirect("agenda.jsp"); */
		// receber dados da instância JavaBeans
		ArrayList<JavaBeans> lista = dao.listaContatos();

		// teste
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getIdcon());
			System.out.println(lista.get(i).getNome());
			System.out.println(lista.get(i).getFone());
			System.out.println(lista.get(i).getEmail());
		}
		
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);
	}

	// CRUD Create
	protected void novoContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * System.out.println(request.getParameter("nome"));
		 * System.out.println(request.getParameter("fone"));
		 * System.out.println(request.getParameter("email"));
		 */

		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		/* contato.setObsPath(request.getParameter("obsPath")); */

		dao.inserirContato(contato);

		response.sendRedirect("main");
	}
	
	// CRUD Read
	protected void listarContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recebe o parâmetro idcon
		String idcon = request.getParameter("idcon");
		// Testa o envio do parâmetro
		System.out.println(idcon);
		// Configura o parâmetro do objeto
		this.contato.setIdcon(idcon);
		// Selecionar o contato
		this.dao.selecionarContato(contato);
		// Teste
		request.setAttribute("idcon", contato.getIdcon());
		request.setAttribute("nome", contato.getNome());
		request.setAttribute("email", contato.getEmail());
		request.setAttribute("fone", contato.getFone());
		
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}
	
	// CRUD Update
	protected void editarContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.contato.setIdcon(request.getParameter("idcon"));
		this.contato.setNome(request.getParameter("nome"));
		this.contato.setFone(request.getParameter("fone"));
		this.contato.setEmail(request.getParameter("email"));
		this.dao.alterarContato(this.contato);
		response.sendRedirect("main");
	}
	
	// CRUD Delete
	protected void removerContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idcon = request.getParameter("idcon");
		contato.setIdcon(idcon);
		dao.deletarContato(contato);
		response.sendRedirect("main");
	}

}
