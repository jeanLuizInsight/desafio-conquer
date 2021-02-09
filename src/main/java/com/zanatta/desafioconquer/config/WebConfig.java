package com.zanatta.desafioconquer.config;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

/**
 * Classe de configuração padrão customizada para Spring MVC
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 09/02/2021
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

	/**
	 * Bean padrão para setar o Locale.
	 * @return
	 */
	@Bean
	public LocaleResolver localeResolver() {
		final FixedLocaleResolver slr = new FixedLocaleResolver();
		slr.setDefaultLocale(new Locale("pt", "BR"));
		return slr;
	}

}
