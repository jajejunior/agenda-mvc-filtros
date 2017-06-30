package br.com.junior.agenda.testes;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.junior.agenda.ConnectionFactory;
/**
 * @author Junior
 *
 */
public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		try {
			connection = new ConnectionFactory().getConnection();
			System.out.println("Connectado com sucesso");
		}catch (RuntimeException e) {
			System.out.println("Erro ao se conectar: "+e);
		}finally {
			System.out.println("Conexão finalizada");
			connection.close();
		}
		
	}

}
