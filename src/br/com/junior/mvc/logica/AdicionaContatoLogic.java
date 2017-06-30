/**
 * 
 */
package br.com.junior.mvc.logica;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.junior.agenda.dao.ContatoDao;
import br.com.junior.agenda.model.Contato;

/**
 * @author Junior
 *
 */
public class AdicionaContatoLogic implements Logica {

	
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Contato contato = new Contato();
		contato.setNome(request.getParameter("nome"));
		contato.setEmail(request.getParameter("email"));
		contato.setEndereco(request.getParameter("endereco"));

	    String dataEmTexto = request.getParameter("dataNascimento");
	    Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
	    Calendar dataNascimento = Calendar.getInstance();
	    dataNascimento.setTime(date);
	    
	    contato.setDataNascimento(dataNascimento);
		//Connection connection = new ConnectionFactory().getConnection();
	    Connection connection = (Connection) request.getAttribute("conexao");
	    ContatoDao dao = new ContatoDao(connection);
	    dao.adicionaContato(contato);
	    System.out.println("Dados adicionados");
	    
	    RequestDispatcher rd = request.getRequestDispatcher("/contato-adicionado.jsp");
	    rd.forward(request, response);
	    
	    connection.close();
	}
}
