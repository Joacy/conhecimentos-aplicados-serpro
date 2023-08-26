package com.higor.escola;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.higor.escola.controller.AlunoController;
import com.higor.escola.model.Aluno;
import com.higor.escola.respository.AlunoRepository;

@SpringBootApplication
// @ComponentScan(basePackageClasses = AlunoController.class)
@ComponentScan(basePackages = "com.higor.escola")
public class EscolaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscolaApplication.class, args);
	}

}
