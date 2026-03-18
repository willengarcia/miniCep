package com.example.miniCep;

import com.example.miniCep.Principal.Principal;
import com.example.miniCep.Repository.RepositoryCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private RepositoryCliente repositoryCliente;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repositoryCliente);
		principal.cadastroCliente();
	}
}
