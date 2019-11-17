/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author milen
 */
public class Agenda {
    private Date data;
    private Time horario;

    public Agenda(Date data, Time horario) {
        this.data = data;
        this.horario = horario;
    } 

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHorario() {
        return horario;
    }

    public void setHorario(Time horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Agenda{" + "data=" + data + ", horario=" + horario + '}';
    }
    
}
