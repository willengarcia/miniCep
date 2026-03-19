package com.example.miniCep.Principal;

import com.example.miniCep.Model.Cep;
import com.example.miniCep.Model.Cliente;
import com.example.miniCep.Model.DadosCep;
import com.example.miniCep.Repository.RepositoryCliente;
import com.example.miniCep.Service.ConsumoApi;
import com.example.miniCep.Service.ConverteDados;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.persistence.Transient;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Principal {
    final String URL = "https://viacep.com.br/ws/";
    final String modelo = "/json/";
    private String cep;
    private Scanner sc = new Scanner(System.in);
    private ConsumoApi api = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private List<Cep> endereco = new ArrayList<>();
    private RepositoryCliente repositoryCliente;
    Pattern regexEmail = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.\\w+$");
    Pattern regexCPF = Pattern.compile("^\\d{11}$");

    public Principal(RepositoryCliente repositoryCliente) {
        this.repositoryCliente = repositoryCliente;
    }

    public void cadastroCliente() throws JsonProcessingException {
        System.out.println("Digite seu nome: ");
        String nome = sc.nextLine();
        System.out.println("Digite seu CPF");
        String cpf = sc.nextLine();
        System.out.println("Digite seu email");
        String email = sc.nextLine();
        System.out.println("Digite seu telefone");
        String telefone =  sc.nextLine();
        int contador = 1;
        while(contador !=0){
            System.out.println("Digite um CEP válido: ");
            cep = sc.nextLine();
            if(cep.length() == 8){
                String json = api.obterDados(URL+cep+modelo);
                DadosCep dadosConvertidos = conversor.obterDados(json, DadosCep.class);
                Cep cep = new Cep(dadosConvertidos);
                endereco.add(cep);
                System.out.println("Digite 1 para continuar o cadastro do Endereço, ou 0 para sair!");
                contador = sc.nextInt();
            } else {
                System.out.println("Cep inválido!");
            }
        }
        if(regexCPF.matcher(cpf).matches() && regexEmail.matcher(email).matches()){
            Cliente cliente = new Cliente(cpf, nome, email, telefone, endereco);
            cliente.setEndereco(endereco);
            System.out.println(cliente);
            repositoryCliente.save(cliente);
        } else {
            System.out.println("Email ou CPF inválidos!");
        }
    }

}
