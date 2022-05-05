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
	JavaBeans produto = new JavaBeans();

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
			produtos(request, response);
		} else if (action.equals("/inserir")) {
			novoProduto(request, response);
		} else if (action.equals("/select")) {
			listarProduto(request, response);
		} else if (action.equals("/update")) {
			editarProduto(request, response);
		} else if (action.equals("/delete")) {
			removerProduto(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	protected void produtos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* response.sendRedirect("agenda.jsp"); */
		// receber dados da instância JavaBeans
		ArrayList<JavaBeans> lista = dao.listaProdutos();

		// teste
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getIdpro());
			System.out.println(lista.get(i).getNome());
			System.out.println(lista.get(i).getQuantidade());
			System.out.println(lista.get(i).getValor());
			System.out.println(lista.get(i).getVencimento());
			System.out.println(lista.get(i).getMarca());
			System.out.println(lista.get(i).getCategoria());
		}

		request.setAttribute("produtos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("lojinha.jsp");
		rd.forward(request, response);
	}

	protected void novoProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		produto.setNome(request.getParameter("nome"));
		produto.setQuantidade(request.getParameter("quantidade"));
		produto.setValor(request.getParameter("valor"));
		produto.setVencimento(request.getParameter("vencimento"));
		produto.setMarca(request.getParameter("marca"));
		produto.setCategoria(request.getParameter("categoria"));

		dao.inserirProduto(produto);

		response.sendRedirect("main");
	}

	// CRUD Read
	protected void listarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recebe o parâmetro idcon
		String idpro = request.getParameter("idpro");
		// Testa o envio do parâmetro
		System.out.println(idpro);
		// Configura o parâmetro do objeto
		this.produto.setIdpro(idpro);
		// Selecionar o contato
		this.dao.selecionarProduto(produto);
		// Teste
		request.setAttribute("idpro", produto.getIdpro());
		request.setAttribute("nome", produto.getNome());
		request.setAttribute("quantidade", produto.getQuantidade());
		request.setAttribute("valor", produto.getValor());
		request.setAttribute("vencimento", produto.getVencimento());
		request.setAttribute("marca", produto.getMarca());
		request.setAttribute("categoria", produto.getCategoria());

		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}

	// CRUD Update
	protected void editarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.produto.setIdpro(request.getParameter("idpro"));
		this.produto.setNome(request.getParameter("nome"));
		this.produto.setQuantidade(request.getParameter("quantidade"));
		this.produto.setValor(request.getParameter("valor"));
		this.produto.setVencimento(request.getParameter("vencimento"));
		this.produto.setMarca(request.getParameter("marca"));
		this.produto.setCategoria(request.getParameter("categoria"));
		this.dao.alterarProduto(this.produto);
		response.sendRedirect("main");
	}
	
	// CRUD Delete
		protected void removerProduto(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String idpro = request.getParameter("idpro");
			produto.setIdpro(idpro);
			dao.deletarProduto(produto);
			response.sendRedirect("main");
		}

}
