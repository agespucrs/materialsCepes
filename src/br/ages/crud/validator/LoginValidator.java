package br.ages.crud.validator;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.ages.crud.util.*;
import br.ages.crud.exception.ValidationException;

public class LoginValidator implements Validator {

	public boolean validar(Map<String, Object> valores) throws ValidationException {
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9_]{4,20}$");
		String msgErro = "";
		for (String key : valores.keySet()) {
			String login = (String) valores.get(key);
			if (login == null || "".equals(login)) {
				msgErro += MensagemContantes.MSG_ERR_CAMPO_OBRIGATORIO.replace("?", key).concat("<br/>");
			}
			Matcher matcher = pattern.matcher(login);

			if (matcher.find()) {
				msgErro += MensagemContantes.MSG_SENHA_INVALIDA.concat("<br/>");
			}
		}
		if (!"".equals(msgErro)) {
			throw new ValidationException(msgErro);
		}

		return true;
	}

}