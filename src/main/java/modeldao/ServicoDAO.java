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
import model.Servico;

/**
 *
 * @author milen
 */
public class ServicoDAO {
     private String sql;
    private Connection conn;
    private PreparedStatement stmt;
    
    private void open() throws SQLException {
        conn = DatabasePostgreSQL.conectar();
    }

    private void close() throws SQLException {
            conn.close();
    }
    
    public void inserir(Servico servico) throws SQLException {
        open();
        sql = "INSERT INTO Servico (nome, descricao) VALUES (?, ?)";
        stmt = this.conn.prepareStatement(sql);
        stmt.setString(1, servico.getNome());
        stmt.setString(2, servico.getDescricao());        
        stmt.executeUpdate();
        close();
    }

    public void update(Servico servico) throws SQLException {
        open();
        sql = "UPDATE Servico SET nome = ?, descricao = ?";
        stmt = this.conn.prepareStatement(sql);
        stmt.setString(1, servico.getNome());
        stmt.setString(2, servico.getDescricao());
        stmt.executeUpdate();
        close();
    }
}
