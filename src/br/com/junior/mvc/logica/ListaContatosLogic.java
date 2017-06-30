/**
 * 
 */
package br.com.junior.mvc.logica;

import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.junior.agenda.dao.ContatoDao;
import br.com.junior.agenda.model.Contato;

/**
 * @author Junior
 *
 */
public class ListaContatosLogic implements Logica {

	/* (non-Javadoc)
	 * @see br.com.junior.mvc.logica.Logica#executa(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//Connection connection = new ConnectionFactory().getConnection();
		Connection connection = (Connection) request.getAttribute("conexao");
		List<Contato> contatos = new ContatoDao(connection).getLista();
		request.setAttribute("contatos", contatos);
		RequestDispatcher rd = request.getRequestDispatcher("/lista-contatos.jsp");
		rd.forward(request, response);
		
	}

}
