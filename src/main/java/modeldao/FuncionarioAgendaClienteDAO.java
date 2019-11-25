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
import model.FuncionarioAgendaCliente;



/**
 *
 * @author milen
 */
public class FuncionarioAgendaClienteDAO {
    private String sql;
    private Connection conn;
    private PreparedStatement stmt;
    
    private void open() throws SQLException {
        conn = DatabasePostgreSQL.conectar();
    }

    private void close() throws SQLException {
            conn.close();
    }
    
//    public void inserir(FuncionarioAgendaCliente funcionarioAgendaCliente) throws SQLException {
//        open();
//        sql = "INSERT INTO FuncionarioAgendaCliente (funcionarioId, cpf, dia, hora, servicoId, status) VALUES (?, ?, ?, ?, ?, ?)";
//        stmt = this.conn.prepareStatement(sql);
//        stmt.setInt(1, funcionarioAgendaCliente.getFuncServ().getFunc().getCodFuncionario());
//        stmt.setString(2, funcionarioAgendaCliente.getCliente().getCpf());
//        stmt.setDate(3, funcionarioAgendaCliente.getAgenda().getData());
//        stmt.setTime(4, funcionarioAgendaCliente.getAgenda().getHorario());
//        stmt.setInt(5, funcionarioAgendaCliente.getFuncServ().getServ().getCodServico());
//        stmt.setString(6, funcionarioAgendaCliente.getStatus());
//        stmt.executeUpdate();
//        close();
//    }
//
//    public void update(FuncionarioAgendaCliente funcionarioAgendaCliente) throws SQLException {
//        open();
//        sql = "UPDATE FuncionarioAgendaCliente SET cpf = ?, data = ?, horario = ?, status = ?";
//        stmt = this.conn.prepareStatement(sql);
//        stmt.setString(1, funcionarioAgendaCliente.getCliente().getCpf());
//        stmt.setDate(2, funcionarioAgendaCliente.getAgenda().getData());
//        stmt.setTime(3, funcionarioAgendaCliente.getAgenda().getHorario());
//        stmt.setString(4, funcionarioAgendaCliente.getStatus());
//        stmt.executeUpdate();
//        close();
//    }
}
