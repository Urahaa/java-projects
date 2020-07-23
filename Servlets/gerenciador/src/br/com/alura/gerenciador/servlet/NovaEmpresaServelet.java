package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServelet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServelet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");
		PrintWriter out = response.getWriter();
		
		String nome = request.getParameter("nome");
		System.out.println(nome);
		
		out.println("<html>");
		out.println("<body>");
		out.println("Empresa " + nome +" cadastrada com sucesso!");
		out.println("</body>");
		out.println("</html>");
		
	}
	

}
