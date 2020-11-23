package com.example.armobile.models;


public class DadosPessoais {
    private String nome;
    private String email;
    private String dataNascimento;
    private String idade;

    public DadosPessoais(String nome, String email, String dataNascimento, String idade){
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }
}
