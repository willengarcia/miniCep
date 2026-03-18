package com.example.miniCep.Repository;

import com.example.miniCep.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryCliente extends JpaRepository<Cliente, Long> {

}
