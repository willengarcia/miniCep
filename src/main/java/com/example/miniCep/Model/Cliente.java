package com.example.miniCep.Model;

import jakarta.persistence.*;

import java.util.List;
import java.util.regex.Pattern;

@Entity(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String cpf;
    @Column(unique = true)
    private String email;
    private String telefone;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Cep> endereco;




    public Cliente() {}

    public Cliente(String cpf, String nome, String email, String telefone, List<Cep> endereco) {
        try{
            this.cpf = cpf;
            this.nome = nome;
            this.email = email;
            this.telefone = telefone;
            this.endereco = endereco;
        } catch (Exception e){
            System.out.println("Erro ao criar coletar os dados: "+ e.getMessage());
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Cep> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Cep> endereco) {
        endereco.forEach(c -> c.setCliente(this));
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "\nNome: "+nome+
                "\nCpf: "+cpf+
                "\nEmail: "+email+
                "\nTelefone: "+telefone+
                "\nEndereço: "+endereco.toString();
    }
}
