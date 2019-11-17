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
public class Estoque {
    private int codEstoque;
    private String nome;

    public Estoque(int codEstoque, String nome) {
        this.codEstoque = codEstoque;
        this.nome = nome;
    }

    public int getCodEstoque() {
        return codEstoque;
    }

    public void setCodEstoque(int codEstoque) {
        this.codEstoque = codEstoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Estoque{" + "codEstoque=" + codEstoque + ", nome=" + nome + '}';
    }
    
}
