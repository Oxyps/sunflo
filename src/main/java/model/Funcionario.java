/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author milen
 */
public class Funcionario {
    private int codFuncionario;
    private String apelido;
    private String nome;
    private Date dataNascimento;
    private String email;
    private String endereco;
    private String cpf;
    private String telefone;
    private String atuacaoProfissional;
    private String grauEscolaridade;

    public Funcionario(int codFuncionario, String apelido, String nome, Date dataNascimento, String email, String endereco, String cpf, String telefone, String atuacaoProfissional, String grauEscolaridade) {
        this.codFuncionario = codFuncionario;
        this.apelido = apelido;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.endereco = endereco;
        this.cpf = cpf;
        this.telefone = telefone;
        this.atuacaoProfissional = atuacaoProfissional;
        this.grauEscolaridade = grauEscolaridade;
    }

    public int getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(int codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getAtuacaoProfissional() {
        return atuacaoProfissional;
    }

    public void setAtuacaoProfissional(String atuacaoProfissional) {
        this.atuacaoProfissional = atuacaoProfissional;
    }

    public String getGrauEscolaridade() {
        return grauEscolaridade;
    }

    public void setGrauEscolaridade(String grauEscolaridade) {
        this.grauEscolaridade = grauEscolaridade;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "codFuncionario=" + codFuncionario + ", apelido=" + apelido + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", email=" + email + ", endereco=" + endereco + ", cpf=" + cpf + ", telefone=" + telefone + ", atuacaoProfissional=" + atuacaoProfissional + ", grauEscolaridade=" + grauEscolaridade + '}';
    }
    
}
