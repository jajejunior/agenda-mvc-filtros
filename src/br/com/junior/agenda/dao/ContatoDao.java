/**
 * @author Junior
 * @version 1.0
 */
package br.com.junior.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.junior.agenda.model.Contato;

/**
 * @author Junior
 *
 */
public class ContatoDao {
	private Connection connection;
	
	public ContatoDao(Connection _connection){
		this.connection = _connection;
	}
	
	public void adicionaContato(Contato contato){
		String sql = "insert into contatos "
				+ "(nome, email, endereco, dataNascimento) "
				+ "values(?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.execute();
			System.out.println("Adicionando contato...");
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void removeContato(Contato contato){
		String sql = "delete from contatos where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, contato.getId());
			stmt.execute();
			System.out.println("Removendo contato...");
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Erro ao remover contato."+e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void alteraContato(Contato contato){
		String sql = "update contatos set nome=?, email=?, endereco=?, dataNascimento=? where id=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			stmt.execute();
			System.out.println("Alterando dados...");
			stmt.close();
			
		} catch (SQLException e) {
			System.out.println("Erro ao alterar contato."+e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public List<Contato> getLista(){
		String sql = "select * from contatos";
		try {
			List<Contato> contatoList = new ArrayList<>();
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				
				contatoList.add(contato);
			}
			stmt.close();
			rs.close();
			return contatoList;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao listar...");
			throw new RuntimeException(e);			
		}
	}
}
