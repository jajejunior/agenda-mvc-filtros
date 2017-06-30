
package br.com.junior.agenda.testes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;

import br.com.junior.agenda.ConnectionFactory;
import br.com.junior.agenda.dao.ContatoDao;
import br.com.junior.agenda.model.Contato;

/**
 * @author Junior
 * @version 1.0
 */
public class TestaInsere {

	public static void main(String[] args) throws SQLException {
		Contato contato = new Contato();
		
		contato.setNome("Antônio Pereira da Silva");
		contato.setEmail("anto@gmail.com");
		contato.setEndereco("Quadra12 conjunto 12 casa 12");
		contato.setDataNascimento(Calendar.getInstance());
		
		Connection connection = new ConnectionFactory().getConnection();
		ContatoDao dao = new ContatoDao(connection);
		
		dao.adicionaContato(contato);
		System.out.println("Contato adicionado.");
		connection.close();
	}
}
