/**
 * 
 */
package br.com.junior.mvc.logica;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.junior.agenda.dao.ContatoDao;
import br.com.junior.agenda.model.Contato;

/**
 * @author Junior
 *
 */
public class RemoveContatoLogic implements Logica {

	/* (non-Javadoc)
	 * @see br.com.junior.mvc.logica.Logica#executa(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long id = Long.parseLong(request.getParameter("id"));
		
		Contato contato = new Contato();
		contato.setId(id);
		
		Connection connection = (Connection) request.getAttribute("conexao");
		
		ContatoDao dao = new ContatoDao(connection);
		dao.removeContato(contato);
		
		
		System.out.println("Contato removido com sucesso.");
		RequestDispatcher rd = request.getRequestDispatcher("mvc?logica=ListaContatosLogic");
		rd.forward(request, response);
	}
}
