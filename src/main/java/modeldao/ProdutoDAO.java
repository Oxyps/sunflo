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
        sql = "INSERT INTO Produto (nome, descricao, marca, quantidadeMinima, quantidadeAtual, preco) VALUES (?, ?, ?, ?, ?, ?)";
        stmt = this.conn.prepareStatement(sql);
        stmt.setString(1, produto.getNome());
        stmt.setString(2, produto.getDescricao());   
        stmt.setString(3, produto.getMarca());
        stmt.setInt(4, produto.getQuantidadeMinima());
        stmt.setInt(5, produto.getQuantidadeAtual());
        stmt.setDouble(6, produto.getPreco());   
        stmt.executeUpdate();
        close();
    }

    public void alterar(Produto produto) throws SQLException {
        open();
        sql = "UPDATE Produto SET nome = ?, descricao = ?, quantidadeMinima = ?, quantidadeAtual = ?, marca = ?, preco = ? WHERE produtoId = ?";
        stmt = this.conn.prepareStatement(sql);
        stmt.setString(1, produto.getNome());
        stmt.setString(2, produto.getDescricao());
        stmt.setInt(3, produto.getQuantidadeMinima());
        stmt.setInt(4, produto.getQuantidadeAtual());
        stmt.setString(5, produto.getMarca());
        stmt.setDouble(6, produto.getPreco());
        stmt.setInt(7, produto.getProdutoId());
        stmt.executeUpdate();
        close();
    }
    
    public List<Produto> carregar() throws SQLException {
		open();
		String query= "SELECT * FROM Produto";
		List<Produto> produtos= new ArrayList<Produto>();
		
		try {
			PreparedStatement pstm= conn.prepareStatement(query);
    		ResultSet resultado= pstm.executeQuery();
    		
    		while(resultado.next()) {
    			Produto produto= new Produto(
    				resultado.getString("nome"),
    				resultado.getString("marca"),
    				resultado.getInt("quantidadeMinima"),
    				resultado.getInt("quantidadeAtual"),
    				resultado.getDouble("preco")
    			);

    			if(resultado.getString("descricao") != null)
    				produto.setDescricao(resultado.getString("descricao"));
    			
    			produto.setProdutoId(resultado.getInt("produtoId"));
    			
    			produtos.add(produto);
    		}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		close();
		return produtos;
	}
}
