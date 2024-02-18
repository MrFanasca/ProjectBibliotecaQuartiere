package org.generation.italy.bibliotecaQuartiere;

import org.generation.italy.bibliotecaQuartiere.servlet.DatasourceProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(DatasourceProperties.class)
public class BibliotecaQuartiereApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaQuartiereApplication.class, args);
	}

}
