package com.daoprojectv2.model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author wesle
 */

public class User {
    private Integer id;
    private String nome;
    private String sexo;
    private String telefone;

    public User(Integer id, String nome, String sexo, String telefone) {
        this.id = id;
        this.nome = nome;
        this.setSexo(sexo);
        this.telefone = telefone;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) {
        if (sexo != null && (sexo.equalsIgnoreCase("m") || sexo.equalsIgnoreCase("f"))) {
            this.sexo = sexo.toLowerCase();
        } else {
            throw new IllegalArgumentException("Sexo deve ser 'm' ou 'f'");
        }
    }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
}

