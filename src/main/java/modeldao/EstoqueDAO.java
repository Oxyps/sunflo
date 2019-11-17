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
import model.Estoque;

/**
 *
 * @author milen
 */
public class EstoqueDAO {
    private String sql;
    private Connection conn;
    private PreparedStatement stmt;
    
    private void open() throws SQLException {
        conn = DatabasePostgreSQL.conectar();
    }

    private void close() throws SQLException {
            conn.close();
    }
    
    public void inserir(Estoque estoque) throws SQLException {
        open();
        sql = "INSERT INTO Estoque (nome) VALUES (?)";
        stmt = this.conn.prepareStatement(sql);
        stmt.setString(1, estoque.getNome());
        stmt.executeUpdate();
        close();
    }

    public void update(Estoque estoque) throws SQLException {
        open();
        sql = "UPDATE Estoque SET nome = ?";
        stmt = this.conn.prepareStatement(sql);        
        stmt.setString(1, estoque.getNome());
        stmt.executeUpdate();
        close();
    }    
}
