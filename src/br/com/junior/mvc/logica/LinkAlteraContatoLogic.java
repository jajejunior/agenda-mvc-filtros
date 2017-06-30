/**
 * 
 */
package br.com.junior.mvc.logica;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Junior
 *
 */
public class LinkAlteraContatoLogic implements Logica {

	/* (non-Javadoc)
	 * @see br.com.junior.mvc.logica.Logica#executa(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RequestDispatcher rd = request.getRequestDispatcher("/altera-contato.jsp");
		rd.forward(request, response);
		

	}

}
