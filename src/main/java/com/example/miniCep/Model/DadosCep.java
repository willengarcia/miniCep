package com.example.miniCep.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosCep(@JsonAlias("cep") String cep
, @JsonAlias("logradouro") String logradouro
, @JsonAlias("complemento") String complemento
, @JsonAlias("bairro") String bairro
, @JsonAlias("localidade") String cidade
, @JsonAlias("uf") String uf
, @JsonAlias("ibge") String ibge) {
}
