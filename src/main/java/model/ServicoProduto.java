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
public class ServicoProduto {
    private Servico serv;
    private Produto prod;
    private float valorSevico;
    private float valorAjuste;
    private float valorPromocional;

    public float getValorSevico() {
        return valorSevico;
    }

    public void setValorSevico(float valorSevico) {
        this.valorSevico = valorSevico;
    }

    public float getValorAjuste() {
        return valorAjuste;
    }

    public void setValorAjuste(float valorAjuste) {
        this.valorAjuste = valorAjuste;
    }

    public float getValorPromocional() {
        return valorPromocional;
    }

    public void setValorPromocional(float valorPromocional) {
        this.valorPromocional = valorPromocional;
    }

    public ServicoProduto(Servico serv, Produto prod, float valorSevico, float valorAjuste, float valorPromocional) {
        this.serv = serv;
        this.prod = prod;
        this.valorSevico = valorSevico;
        this.valorAjuste = valorAjuste;
        this.valorPromocional = valorPromocional;
    }

    public Servico getServ() {
        return serv;
    }

    public void setServ(Servico serv) {
        this.serv = serv;
    }

    public Produto getProd() {
        return prod;
    }

    public void setProd(Produto prod) {
        this.prod = prod;
    }  
   
    @Override
    public String toString() {
        return "ServicoProduto{" + "serv=" + serv + ", prod=" + prod + '}';
    }
    
}
