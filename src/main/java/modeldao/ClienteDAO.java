/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeldao;

import dbdao.DatabasePostgreSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        sql = "INSERT INTO cliente (cpf, nome, telefone, endereco, email, dataNascimento) VALUES (?, ?, ?, ?, ?, ?)";
        stmt = this.conn.prepareStatement(sql);
        stmt.setString(1, cliente.getCpf());
        stmt.setString(2, cliente.getNome());        
        stmt.setString(3, cliente.getTelefone());
        stmt.setString(4, cliente.getEndereco());        
        stmt.setString(5, cliente.getEmail());     
        stmt.setString(6, cliente.getNascimento());
        stmt.executeUpdate();
        close();
    }

    public void update(Cliente cliente) throws SQLException {
        open();
        sql = "UPDATE Cliente SET cpf = ?, nome = ?, telefone = ?, endereço = ?, email = ?";
        stmt = this.conn.prepareStatement(sql);
        stmt.setString(1, cliente.getCpf());
        stmt.setString(2, cliente.getNome());        
        stmt.setString(3, cliente.getTelefone());
        stmt.setString(4, cliente.getEndereco());        
        stmt.setString(5, cliente.getEmail());
        stmt.executeUpdate();
        close();
    }
}
