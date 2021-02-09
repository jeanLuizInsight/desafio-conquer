package com.zanatta.desafioconquer.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class ValidationConfig {

	/**
	 * Bean utilizado para configurar as mensagens de validação do projeto.
	 * Os arquivos de mensagens utilizados para exibir mensagens de validação serão os mesmos utilizados na internacionalização do projeto.
	 * @param messageSource
	 * @return
	 */
	@Bean
	public LocalValidatorFactoryBean validator(final MessageSource messageSource) {
		final LocalValidatorFactoryBean validatorFactoryBean = new LocalValidatorFactoryBean();
		validatorFactoryBean.setValidationMessageSource(messageSource);
		return validatorFactoryBean;
	}
}
