package br.ages.crud.test;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ages.crud.bo.UsuarioBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.model.Usuario;
import br.ages.crud.util.MensagemContantes;

public class TesteLogin {
	
	private Usuario usuarioTrue, usuarioFalse;
	private UsuarioBO usuarioBO = new UsuarioBO();
	
	@Before
	public void init(){
		usuarioTrue = new Usuario("admin", "admin");
		usuarioFalse = new Usuario("admin", "nimda");
		usuarioBO = new UsuarioBO();
	}

	@Test
	public void validaLoginCerto() throws NegocioException {
		boolean ok = false;
		ok = usuarioBO.validaUsuario(usuarioTrue);
		assertTrue(ok);
	}
	
	@Test(expected=NegocioException.class)
	public void validaLoginErrado() throws NegocioException {
		boolean ok = false;
		ok = usuarioBO.validaUsuario(usuarioFalse);
		assertFalse(ok);
	}
}