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
import model.Produto;

/**
 *
 * @author milen
 */
public class ProdutoDAO {
    private String sql;
    private Connection conn;
    private PreparedStatement stmt;
    
    private void open() throws SQLException {
        conn = DatabasePostgreSQL.conectar();
    }

    private void close() throws SQLException {
            conn.close();
    }
    
    public void inserir(Produto produto) throws SQLException {
        open();
        sql = "INSERT INTO Produto (nome, descricao, quantidadeMinima, quantidadeAtual, valor) VALUES (?, ?, ?, ?, ?)";
        stmt = this.conn.prepareStatement(sql);
        stmt.setString(1, produto.getNome());
        stmt.setString(2, produto.getDescricao());        
        stmt.setInt(3, produto.getQuantidadeMinima());
        stmt.setInt(4, produto.getQuantidadeAtual());        
        stmt.setFloat(5, produto.getValor());
        stmt.executeUpdate();
        close();
    }

    public void update(Produto produto) throws SQLException {
        open();
        sql = "UPDATE Produto SET nome = ?, descricao = ?, quantidadeMinima = ?, quantidadeAtual = ?, valor = ?";
        stmt = this.conn.prepareStatement(sql);
        stmt.setString(1, produto.getNome());
        stmt.setString(2, produto.getDescricao());        
        stmt.setInt(3, produto.getQuantidadeMinima());
        stmt.setInt(4, produto.getQuantidadeAtual());        
        stmt.setFloat(5, produto.getValor());
        stmt.executeUpdate();
        close();
    }
}
