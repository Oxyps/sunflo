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
import model.ServicoProduto;

/**
 *
 * @author milen
 */
public class ServicoProdutoDAO {
    private String sql;
    private Connection conn;
    private PreparedStatement stmt;
    
    private void open() throws SQLException {
        conn = DatabasePostgreSQL.conectar();
    }

    private void close() throws SQLException {
            conn.close();
    }
    
    public void inserir(ServicoProduto servicoProduto) throws SQLException {
        open();
        sql = "INSERT INTO ServicoProduto (servicoId, produtoId, valorServico, valorAjuste, valorPromocional) VALUES (?, ?, ?, ?, ?)";
        stmt = this.conn.prepareStatement(sql);
        stmt.setInt(1, servicoProduto.getServ().getCodServico());
//        stmt.setInt(2, servicoProduto.getProd().getCodProduto());
        stmt.setFloat(3, servicoProduto.getValorSevico());
        stmt.setFloat(4, servicoProduto.getValorAjuste());
        stmt.setFloat(5, servicoProduto.getValorPromocional());
        stmt.executeUpdate();
        close();
    }

    public void update(ServicoProduto servicoProduto) throws SQLException {
        open();
        sql = "UPDATE FuncionarioAgendaCliente SET valorServico = ?, valorAjuste = ?, valorPromocional = ?";
        stmt = this.conn.prepareStatement(sql);
        stmt.setFloat(1, servicoProduto.getValorSevico());
        stmt.setFloat(2, servicoProduto.getValorAjuste());
        stmt.setFloat(3, servicoProduto.getValorPromocional());
        stmt.executeUpdate();
        close();
    }
}
