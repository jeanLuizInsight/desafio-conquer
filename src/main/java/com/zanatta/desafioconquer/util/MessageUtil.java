package com.zanatta.desafioconquer.util;

import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

/**
 * Classe utilitária para mensagens da aplicação.
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 09/02/2021
 */
@Component
public class MessageUtil {

	@Autowired private MessageSource messageSource;

	/**
	 * Retorna a mensagem com base no seu id.
	 * @param id
	 * @return String
	 */
	public String getText(final String id) {
		final Locale locale = LocaleContextHolder.getLocale();
		String text = "";
		try {
			text = this.messageSource.getMessage(id, null, locale);
		} catch (final NoSuchMessageException e) {
			text = "???" + id + "???";
		}
		return text;
	}

	/**
	 * Retorna a mensagem com base no seu id e argumentos.
	 * @param id
	 * @param args
	 * @return
	 */
	public String getText(final String id, final Object... args) {
		final Locale locale = LocaleContextHolder.getLocale();
		String text = "";
		try {
			text = this.messageSource.getMessage(id, args, locale);
		} catch (final NoSuchMessageException e) {
			text = "???" + id + "???";
		}
		return text;
	}

	public String getMessageErrorBindResult(final BindingResult bindResult) {
		final StringBuilder strErro = new StringBuilder();

		final List<ObjectError> errors = bindResult.getAllErrors();
		for (final ObjectError error : errors) {
			strErro.append(error.getDefaultMessage()).append("<br />");
		}

		return strErro.toString();
	}
}
