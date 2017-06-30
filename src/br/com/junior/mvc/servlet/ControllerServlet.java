package br.com.junior.mvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.junior.mvc.logica.Logica;

/**
 * @author Junior
 *
 */

@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parametro = request.getParameter("logica");
		String className = "br.com.junior.mvc.logica."+parametro;
		
		try {
			Class<?> classe = Class.forName(className);
			Logica logica = (Logica) classe.newInstance();
			logica.executa(request, response);
		} catch (Exception e) {
			throw new ServletException("A l�gica de neg�cios causou uma excess�o:", e);
		}
	}
}