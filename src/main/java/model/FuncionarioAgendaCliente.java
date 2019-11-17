/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


/**
 *
 * @author milen
 */
public class FuncionarioAgendaCliente {
    private String status;
    private Cliente cliente;
    private Agenda agenda;
    private FuncionarioServico funcServ;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public FuncionarioAgendaCliente(){}

    public FuncionarioAgendaCliente(String status, Cliente cliente, Agenda agenda, FuncionarioServico funcServ) {
        this.status = status;
        this.cliente = cliente;
        this.agenda = agenda;
        this.funcServ = funcServ;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public FuncionarioServico getFuncServ() {
        return funcServ;
    }

    public void setFuncServ(FuncionarioServico funcServ) {
        this.funcServ = funcServ;
    }  

    @Override
    public String toString() {
        return "FuncionarioAgendaCliente{" + "status=" + status + ", cliente=" + cliente + ", agenda=" + agenda + ", funcServ=" + funcServ + '}';
    }
   
}
