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
    private String password;
    private String nome;
    private Date nascimento;
    private String email;
    private String endereco;
    private String cpf;
    private String telefone;
    private String atuacaoProfissional;
    private String grauEscolaridade;
    private String sexo;

    public Funcionario(String password, String nome, Date nascimento, String email, String endereco, String cpf, String telefone, String atuacaoProfissional, String grauEscolaridade, String sexo) {
        this.password = password;
        this.nome = nome;
        this.nascimento = nascimento;
        this.email = email;
        this.endereco = endereco;
        this.cpf = cpf;
        this.telefone = telefone;
        this.atuacaoProfissional = atuacaoProfissional;
        this.grauEscolaridade = grauEscolaridade;
        this.sexo = sexo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
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
    
    public String getSexo() {
    	return this.sexo;
    }
    
    public void setSexo(String sexo) {
    	this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Funcionario{" +  ", password=" + password + ", nome=" + nome + ", nascimento=" + nascimento + ", email=" + email + ", endereco=" + endereco + ", cpf=" + cpf + ", telefone=" + telefone + ", atuacaoProfissional=" + atuacaoProfissional + ", grauEscolaridade=" + grauEscolaridade + '}';
    }
    
}
