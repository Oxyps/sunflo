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
import model.FuncionarioServico;

/**
 *
 * @author milen
 */
public class FuncionarioServicoDAO {
    private String sql;
    private Connection conn;
    private PreparedStatement stmt;
    
    private void open() throws SQLException {
        conn = DatabasePostgreSQL.conectar();
    }

    private void close() throws SQLException {
            conn.close();
    }
    
    public void inserir(FuncionarioServico funcServ) throws SQLException {
        open();
        sql = "INSERT INTO FuncionarioServico (codFuncionario, codServico) VALUES (?, ?)";
        stmt = this.conn.prepareStatement(sql);
        stmt.setInt(1, funcServ.getFunc().getCodFuncionario());
        stmt.setInt(2, funcServ.getServ().getCodServico());
        close();
    }
 
}
