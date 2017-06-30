/**
 * 
 */
package br.com.junior.agenda.testes;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.junior.agenda.ConnectionFactory;
import br.com.junior.agenda.dao.ContatoDao;
import br.com.junior.agenda.model.Contato;

/**
 * @author Junior
 *
 */
public class TestaRemove {

	public static void main(String[] args) throws SQLException {
		Contato contato = new Contato();
		contato.setId((long)21);
		
		Connection connection = new ConnectionFactory().getConnection();
		ContatoDao dao = new ContatoDao(connection);
		dao.removeContato(contato);
		System.out.println("Contato Removido com Sucesso.");
		connection.close();
	}
}
