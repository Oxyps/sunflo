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
import model.Agenda;

/**
 *
 * @author milen
 */
public class AgendaDAO {
    private String sql;
    private Connection conn;
    private PreparedStatement stmt;
    
    private void open() throws SQLException {
        conn = DatabasePostgreSQL.conectar();
    }

    private void close() throws SQLException {
            conn.close();
    }
    
    public void inserir(Agenda agenda) throws SQLException {
        open();
        sql = "INSERT INTO Agenda (dia, hora) VALUES (?, ?)";
        stmt = this.conn.prepareStatement(sql);
        stmt.setDate(1, agenda.getData());
        stmt.setTime(2, agenda.getHorario());
        stmt.executeUpdate();
        close();
    }

    public void update(Agenda agenda) throws SQLException {
        open();
        sql = "UPDATE Agenda SET dia = ?, hora = ?";
        stmt = this.conn.prepareStatement(sql);
        stmt.setDate(1, agenda.getData());
        stmt.setTime(2, agenda.getHorario());
        stmt.executeUpdate();
        close();
    }   
    
}
