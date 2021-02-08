package com.zanatta.desafioconquer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Configuração de recursos para a aplicação.
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 05/02/2021
 */
@Configuration
public class ResourcesConfig {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
