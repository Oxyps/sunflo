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
import model.Funcionario;

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
        sql = "INSERT INTO cliente (cpf, nome, telefone, endereco, email, nascimento) VALUES (?, ?, ?, ?, ?, ?)";
        stmt = this.conn.prepareStatement(sql);
        stmt.setString(1, cliente.getCpf());
        stmt.setString(2, cliente.getNome());        
        stmt.setString(3, cliente.getTelefone());
        stmt.setString(4, cliente.getEndereco());        
        stmt.setString(5, cliente.getEmail());     
        stmt.setDate(6, cliente.getNascimento());
        stmt.executeUpdate();
        close();
    }

    public void update(Cliente cliente) throws SQLException {
        open();
        sql = "UPDATE Cliente SET cpf = ?, nome = ?, telefone = ?, endere�o = ?, email = ?";
        stmt = this.conn.prepareStatement(sql);
        stmt.setString(1, cliente.getCpf());
        stmt.setString(2, cliente.getNome());        
        stmt.setString(3, cliente.getTelefone());
        stmt.setString(4, cliente.getEndereco());        
        stmt.setString(5, cliente.getEmail());
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
    				resultado.getString("telefone"),
    				resultado.getString("endereco"),
    				resultado.getString("email"),
    				resultado.getDate("nascimento")
    			);
    			
    			clientes.add(cliente);
    		}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		close();
		return clientes;
	}
}
