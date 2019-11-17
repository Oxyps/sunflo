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
public class Produto {
    private int codProduto;
    private String nome;
    private String descricao;
    private int quantidadeMinima;
    private int quantidadeAtual;
    private int codEstoque;
    private float valor;

    public Produto(int codProduto, String nome, String descricao, int quantidadeMinima, int quantidadeAtual, int codEstoque, float valor) {
        this.codProduto = codProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidadeMinima = quantidadeMinima;
        this.quantidadeAtual = quantidadeAtual;
        this.codEstoque = codEstoque;
        this.valor = valor;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
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

    public int getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(int quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    public int getQuantidadeAtual() {
        return quantidadeAtual;
    }

    public void setQuantidadeAtual(int quantidadeAtual) {
        this.quantidadeAtual = quantidadeAtual;
    }

    public int getCodEstoque() {
        return codEstoque;
    }

    public void setCodEstoque(int codEstoque) {
        this.codEstoque = codEstoque;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Produto{" + "codProduto=" + codProduto + ", nome=" + nome + ", descricao=" + descricao + ", quantidadeMinima=" + quantidadeMinima + ", quantidadeAtual=" + quantidadeAtual + ", codEstoque=" + codEstoque + ", valor=" + valor + '}';
    }
    
}
