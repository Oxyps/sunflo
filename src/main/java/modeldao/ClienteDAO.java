/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeldao;

import dbdao.DatabasePostgreSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;

/**
 *
 * @author milen
 */
public class ClienteDAO {
    private String sql;
    private Connection conn;
    private PreparedStatement stmt;
    
    private void open() throws SQLException {
        conn = DatabasePostgreSQL.conectar();
    }

    private void close() throws SQLException {
        conn.close();
    }
    
    public void inserir(Cliente cliente) throws SQLException {
        open();
        sql = "INSERT INTO cliente (cpf, nome, endereco, nascimento) VALUES (?, ?, ?, ?)";
        stmt = this.conn.prepareStatement(sql);
        stmt.setString(1, cliente.getCpf());
        stmt.setString(2, cliente.getNome());
        stmt.setString(3, cliente.getEndereco()); 
        stmt.setDate(4, cliente.getNascimento());
        stmt.executeUpdate();
        close();
    }

    public void alterar(Cliente cliente) throws SQLException {
        open();
        sql = "UPDATE Cliente SET nome = ?, telefone = ?, endereco = ?, email = ?, nascimento = ? WHERE cpf = ?";
        stmt = this.conn.prepareStatement(sql);
        stmt.setString(6, cliente.getCpf());
        stmt.setString(1, cliente.getNome());        
        stmt.setString(2, cliente.getTelefone());
        stmt.setString(3, cliente.getEndereco());        
        stmt.setString(4, cliente.getEmail());        
        stmt.setDate(5, cliente.getNascimento());
        stmt.executeUpdate();
        close();
    }
    
    public List<Cliente> carregar() throws SQLException {
		open();
		String query= "SELECT * FROM Cliente";
		List<Cliente> clientes= new ArrayList<Cliente>();
		
		try {
			PreparedStatement pstm= conn.prepareStatement(query);
    		ResultSet resultado= pstm.executeQuery();
    		
    		while(resultado.next()) {
    			Cliente cliente= new Cliente(
    				resultado.getString("cpf"),
    				resultado.getString("nome"),
    				resultado.getString("endereco"),
    				resultado.getDate("nascimento")
    			);
    			if(resultado.getString("email") != null)
    				cliente.setEmail(resultado.getString("email"));

    			if(resultado.getString("telefone") != null)
    				cliente.setTelefone(resultado.getString("telefone"));
    			
    			clientes.add(cliente);
    		}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		close();
		return clientes;
	}
}
