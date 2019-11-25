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
import model.Funcionario;

/**
 *
 * @author milen
 */
public class FuncionarioDAO {
    private String sql;
    private Connection conn;
    private PreparedStatement stmt;
    
    private void open() throws SQLException {
        conn = DatabasePostgreSQL.conectar();
    }

    private void close() throws SQLException {
        conn.close();
    }
    
    public void inserir(Funcionario funcionario) throws SQLException {
        open();
        sql = "INSERT INTO Funcionario (password, nome, nascimento, email, endereco, cpf, telefone, atuacaoProfissional, grauEscolaridade) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        stmt = this.conn.prepareStatement(sql);
        stmt.setString(1, funcionario.getPassword());
        stmt.setString(2, funcionario.getNome());
        stmt.setDate(3, funcionario.getNascimento());
        stmt.setString(4, funcionario.getEmail());
        stmt.setString(5, funcionario.getEndereco());
        stmt.setString(6, funcionario.getCpf());
        stmt.setString(7, funcionario.getAtuacaoProfissional());
        stmt.setString(8, funcionario.getGrauEscolaridade());
        stmt.executeUpdate();
        close();
    }

    public void update(Funcionario funcionario) throws SQLException {
        open();
        sql = "UPDATE Funcionario SET password = ?, nome = ?, nascimento = ?, email = ?, endereco = ?, cpf = ?, telefone = ?, atuacaoProfissional = ?, grauEscolaridade = ?";
        stmt = this.conn.prepareStatement(sql);
        stmt.setString(1, funcionario.getPassword());
        stmt.setString(2, funcionario.getNome());
        stmt.setDate(3, funcionario.getNascimento());
        stmt.setString(4, funcionario.getEmail());
        stmt.setString(5, funcionario.getEndereco());
        stmt.setString(6, funcionario.getCpf());
        stmt.setString(7, funcionario.getAtuacaoProfissional());
        stmt.setString(8, funcionario.getGrauEscolaridade());
        stmt.executeUpdate();
        close();
    }
    
    public Funcionario buscarPorCpf(String cpf) throws SQLException {
    	open();
    	
    	String query= "SELECT * FROM Funcionario WHERE cpf=?";
    	Funcionario funcionarioCadastrado= null;
    	try {
    		PreparedStatement pstm= conn.prepareStatement(query);
    		pstm.setString(1, cpf);
    		ResultSet resultado= pstm.executeQuery();
    		if(resultado.next()) {
    			funcionarioCadastrado= new Funcionario(
    					resultado.getString("password"),
    					resultado.getString("nome"),
    					resultado.getDate("nascimento"),
    					resultado.getString("email"),
    					resultado.getString("endereco"),
    					resultado.getString("cpf"),
    					resultado.getString("telefone"),
    					resultado.getString("atuacaoProfissional"),
    					resultado.getString("grauEscolaridade"),
    					resultado.getString("sexo")
            	);
    		}
    		return funcionarioCadastrado;
    	} catch(SQLException ex) {
    		ex.printStackTrace();
    	}

    	close();
    	return null;
    }
}
