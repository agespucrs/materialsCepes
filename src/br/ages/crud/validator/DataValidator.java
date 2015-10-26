package br.ages.crud.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.regex.Pattern;

import br.ages.crud.exception.ValidationException;
import br.ages.crud.util.MensagemContantes;

public class DataValidator implements Validator {

	public boolean validar(Map<String, Object> valores) throws ValidationException {
		Pattern pattern = Pattern.compile("​^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");
		String msgErro = "";
		for (String key : valores.keySet()) {
			String data = (String) valores.get(key);
			if (!"".equals(data)) {
				try {
					if (data.length() < 10) {
						msgErro += MensagemContantes.MSG_ERR_CAMPO_DATA_MENOR_RECOMENDADO.replace("?", key).concat("<br/>");
					}
					if (data.length() > 11) {				
						msgErro += MensagemContantes.MSG_ERR_CAMPO_DATA_MAIOR_RECOMENDADO.replace("?", key).concat("<br/>");
					}
					new SimpleDateFormat("dd/MM/yyyy").parse(data);
				} catch (ParseException e) {
					msgErro += MensagemContantes.MSG_ERR_CAMPO_INVALIDO.replace("?", key).concat("<br/>");
				}
			}
		}
		if (!"".equals(msgErro)) {
			throw new ValidationException(msgErro);
		}
		
		return true;
	}
	
}
