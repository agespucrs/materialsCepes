package br.ages.crud.command;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.EquipamentoBO;
import br.ages.crud.util.MensagemContantes;

public class RemoveEquipamentoCommand implements Command {

	private String proximo;

	private EquipamentoBO equipamentoBO;

	@Override
	public String execute(HttpServletRequest request) {
		proximo = "main?acao=listEquipamento";
		this.equipamentoBO = new EquipamentoBO();
		try {
			Integer idEquipamento = Integer.parseInt(request.getParameter("id_equipamento"));
			equipamentoBO.removerEquipamento(idEquipamento);
			request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_REMOVE_EQUIPAMENTO.
					replace("?", idEquipamento.toString()).concat("<br/>"));
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}
		return proximo;
	}
}
