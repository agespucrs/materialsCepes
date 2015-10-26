package br.ages.crud.validator;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.ages.crud.exception.ValidationException;
import br.ages.crud.util.MensagemContantes;
import br.ages.crud.util.Util;

public class CPFValidator implements Validator {

	@Override
	public boolean validar(Map<String, Object> valores) throws ValidationException {
		Pattern pattern = Pattern.compile("​^(\\d{2}.\\d{3}.\\d{3}\\/\\d{4}-\\d{2})|(\\d{14})|(\\d{3}.\\d{3}.\\d{3}-\\d{2})|(\\d{11})$");
				String msgErro = "";
		for (String key : valores.keySet()) {
			String cpf = (String) valores.get(key);

			if (!"".equals(cpf)) {
				if (!Util.isCPF(cpf)) {
					msgErro += MensagemContantes.MSG_ERR_CAMPO_INVALIDO.replace("?", key).concat("<br/>");
				}
				if (cpf.length() < 11) {
					msgErro += MensagemContantes.MSG_ERR_CAMPO_CPF_MENOR_RECOMENDADO.replace("?", key).concat("<br/>");
				}
				if (cpf.length() > 11) {				
					msgErro += MensagemContantes.MSG_ERR_CAMPO_CPF_MAIOR_RECOMENDADO.replace("?", key).concat("<br/>");
				}
				Matcher matcher = pattern.matcher(cpf);

				if (matcher.find()) {
					msgErro += MensagemContantes.MSG_SENHA_INVALIDA.concat("<br/>");
				}
			} else {
				msgErro += MensagemContantes.MSG_ERR_CAMPO_OBRIGATORIO.replace("?", key).concat("<br/>");
			}
		}
		if (!"".equals(msgErro)) {
			throw new ValidationException(msgErro);
		}
		return true;
	}
		
			 /*(  ​​private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
			   private static final int[] pesoCNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

			   private static int calcularDigito(String str, int[] peso) {
			      int soma = 0;
			      for (int indice=str.length()-1, digito; indice >= 0; indice-- ) {
			         digito = Integer.parseInt(str.substring(indice,indice+1));
			         soma += digito*peso[peso.length-str.length()+indice];
			      }
			      soma = 11 - soma % 11;
			      return soma > 9 ? 0 : soma;
			   }

			   public static boolean isValidCPF(String cpf) {
			      if ((cpf==null) || (cpf.length()!=11)) return false;

			      Integer digito1 = calcularDigito(cpf.substring(0,9), pesoCPF);
			      Integer digito2 = calcularDigito(cpf.substring(0,9) + digito1, pesoCPF);
			      return cpf.equals(cpf.substring(0,9) + digito1.toString() + digito2.toString());
			   }

			   public static boolean isValidCNPJ(String cnpj) {
			      if ((cnpj==null)||(cnpj.length()!=14)) return false;

			      Integer digito1 = calcularDigito(cnpj.substring(0,12), pesoCNPJ);
			      Integer digito2 = calcularDigito(cnpj.substring(0,12) + digito1, pesoCNPJ);
			      return cnpj.equals(cnpj.substring(0,12) + digito1.toString() + digito2.toString());			  
			   }
		**/
	
		}


