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
public class FuncionarioServico {
    private Funcionario func; 
    private Servico serv;

    public FuncionarioServico(Funcionario func, Servico serv) {
        this.func = func;
        this.serv = serv;
    }

    public Funcionario getFunc() {
        return func;
    }

    public void setFunc(Funcionario func) {
        this.func = func;
    }

    public Servico getServ() {
        return serv;
    }

    public void setServ(Servico serv) {
        this.serv = serv;
    }

    @Override
    public String toString() {
        return "FuncionarioServico{" + "func=" + func + ", serv=" + serv + '}';
    }
}
