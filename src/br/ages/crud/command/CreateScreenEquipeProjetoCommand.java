package br.ages.crud.command;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.ProjetoBO;
import br.ages.crud.bo.UsuarioBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Projeto;
import br.ages.crud.model.Usuario;
import br.ages.crud.model.UsuarioProjeto;

public class CreateScreenEquipeProjetoCommand implements Command{
	
	@Override
	public String execute(HttpServletRequest request)
			throws SQLException, PersistenciaException, ParseException, NegocioException {
		
		final List<Projeto> projetos = new ProjetoBO().listarProjetos();
		final ProjetoBO projetoBO = new ProjetoBO();
		
		
		request.setAttribute("projetos", projetos);
		
		String projetoSelecionado = request.getParameter("idProjeto");
		
		if (null != projetoSelecionado && !projetoSelecionado.isEmpty()){
			request.setAttribute("idProjeto", projetoSelecionado);
			
			Projeto projeto = projetoBO.buscarProjeto(Integer.parseInt(projetoSelecionado));
		
			final List<Usuario> usuarios = new UsuarioBO().listarUsuario();
			final List<UsuarioProjeto> integrantes = projetoBO.consultarUsuariosProjeto(Integer.parseInt(projetoSelecionado));
			
			List<Usuario> usuariosDiferentes = new ArrayList<>();
			
			for (Usuario usr : usuarios){
				if (!(validarUsuarioExistente(usr.getIdUsuario(), integrantes)))
					usuariosDiferentes.add(usr);
			}
			
			request.setAttribute("usuarios", usuariosDiferentes);
			request.setAttribute("integrantes", integrantes);
			
		}
					
		return "projeto/equipeProjeto.jsp";
	}
	
	private Boolean validarUsuarioExistente(Integer id, List<UsuarioProjeto> lista){
		for (UsuarioProjeto usr : lista){
			if (usr.getIdUsuario() == id)
				return true;
		}
		return false;
	}

}
