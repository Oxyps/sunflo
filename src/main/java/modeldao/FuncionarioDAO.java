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
        sql = "INSERT INTO Funcionario (apelido, nome, dataNascimento, email, endereco, cpf, telefone, atuacaoProfissional, grauEscolaridade) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        stmt = this.conn.prepareStatement(sql);
        stmt.setString(1, funcionario.getApelido());
        stmt.setString(2, funcionario.getNome());
        stmt.setDate(3, funcionario.getDataNascimento());
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
        sql = "UPDATE Funcionario SET apelido = ?, nome = ?, dataNascimento = ?, email = ?, endereco = ?, cpf = ?, telefone = ?, atuacaoProfissional = ?, grauEscolaridade = ?";
        stmt = this.conn.prepareStatement(sql);
        stmt.setString(1, funcionario.getApelido());
        stmt.setString(2, funcionario.getNome());
        stmt.setDate(3, funcionario.getDataNascimento());
        stmt.setString(4, funcionario.getEmail());
        stmt.setString(5, funcionario.getEndereco());
        stmt.setString(6, funcionario.getCpf());
        stmt.setString(7, funcionario.getAtuacaoProfissional());
        stmt.setString(8, funcionario.getGrauEscolaridade());
        stmt.executeUpdate();
        close();
    }   
}
