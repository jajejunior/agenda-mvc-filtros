package br.com.junior.agenda.testes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;

import br.com.junior.agenda.ConnectionFactory;
import br.com.junior.agenda.dao.ContatoDao;
import br.com.junior.agenda.model.Contato;

/**
 * @author Junior
 *
 */
public class TestaAltera {

	public static void main(String[] args) throws SQLException {
		Contato contato = new Contato();
		contato.setId((long) 20);
		contato.setNome("Jesus Cristo");
		contato.setEmail("jc@bencaemail.graca");
		contato.setEndereco("Quadra 1 tenda2 Jerusalém JM");
		contato.setDataNascimento(Calendar.getInstance());
		Connection connection = new ConnectionFactory().getConnection();
		ContatoDao dao = new ContatoDao(connection);
		dao.alteraContato(contato);
		System.out.println("Dados Alterados");
		
		connection.close();
	}
}
