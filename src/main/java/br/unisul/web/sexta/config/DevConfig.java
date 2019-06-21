package br.unisul.web.sexta.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.text.ParseException;
import br.unisul.web.sexta.services.DbService;

@Configuration
public class DevConfig {

	@Autowired
	private DbService dbService;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;

	@Bean
	public boolean inicializaBancoDeDados() throws ParseException {
		if (!"create".equals(strategy)) {
			return false;
		}
		dbService.inicializaBancoDeDados();
		return true;
	}
}
