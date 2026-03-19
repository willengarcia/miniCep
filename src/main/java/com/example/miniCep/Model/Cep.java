package com.example.miniCep.Model;

import jakarta.persistence.*;

@Entity
public class Cep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String ibge;
    private String cep;
    @ManyToOne
    private Cliente cliente;

    public Cep() {}

    public Cep(DadosCep dadosCep) {
        try{
            this.logradouro = dadosCep.logradouro();
            this.complemento = dadosCep.complemento();
            this.bairro = dadosCep.bairro();
            this.cidade = dadosCep.cidade();
            this.uf = dadosCep.uf();
            this.ibge = dadosCep.ibge();
            this.cep = dadosCep.cep();
        } catch(Exception e){
            System.out.println("Erro ao criar coletar os dados do CEP: "+ e.getMessage());
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return  "\n======================================\n"+
                "\n Logradouro: " + logradouro +
                "\n Complemento: " + complemento +
                "\n Bairro: " + bairro +
                "\n Cidade: " + cidade +
                "\n UF: " + uf +
                "\n IBGE: " + ibge +
                "\n CEP: " + cep +
                "\n======================================\n";
    }
}
