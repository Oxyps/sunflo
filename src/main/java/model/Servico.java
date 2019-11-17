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
public class Servico {
    private int codServico;
    private String nome;
    private String descricao;

    public Servico(int codServico, String nome, String descricao) {
        this.codServico = codServico;
        this.nome = nome;
        this.descricao = descricao;
    }

    public int getCodServico() {
        return codServico;
    }

    public void setCodServico(int codServico) {
        this.codServico = codServico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Servico{" + "codServico=" + codServico + ", nome=" + nome + ", descricao=" + descricao + '}';
    }
    
}
