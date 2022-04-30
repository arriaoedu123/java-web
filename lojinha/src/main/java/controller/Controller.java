package controller;

import java.io.IOException;


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
@WebServlet(urlPatterns = {"/Controller", "/main", "/inserir"})
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		// Teste de conexão
		/*DAO dao = new DAO();
		dao.testeConexao();*/
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			produtos(request, response);
		} else if (action.equals("/inserir")) {
			novoProduto(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}
	
	protected void produtos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("lojinha.jsp");
	}
	
	protected void novoProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		produto.setNome(request.getParameter("nome"));
		produto.setQuantidade(request.getParameter("quantidade"));
		produto.setValor(request.getParameter("valor"));
		produto.setVencimento(request.getParameter("vencimento"));
		produto.setMarca(request.getParameter("marca"));
		produto.setCategoria(request.getParameter("categoria"));
		
		dao.inserirProduto(produto);
		
		response.sendRedirect("main");
	}

}
