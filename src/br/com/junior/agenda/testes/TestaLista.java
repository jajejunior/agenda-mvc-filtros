package br.com.junior.agenda.testes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.junior.agenda.ConnectionFactory;
import br.com.junior.agenda.dao.ContatoDao;
import br.com.junior.agenda.model.Contato;

/**
 * @author Junior
 *
 */


public class TestaLista {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = new ConnectionFactory().getConnection();
		ContatoDao dao = new ContatoDao(connection);
		List<Contato> contatoList = dao.getLista();
		
		for (Contato contato : contatoList){
			System.out.println("Id: "+ contato.getId());
			System.out.println("Nome: "+ contato.getNome());
			System.out.println("Email: "+ contato.getEmail());
			System.out.println("Endereço: "+ contato.getEndereco());
			System.out.println("Nascimento: "+ contato.getDataNascimento().getTime()+"\n");
		}
		connection.close();
	}
}
