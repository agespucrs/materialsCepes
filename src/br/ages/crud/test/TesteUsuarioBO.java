package br.ages.crud.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import br.ages.crud.bo.UsuarioBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.model.Usuario;



public class TesteUsuarioBO {
	
	private Usuario usuarioListaUsuario, usuarioSenhaCerta, usuarioCadastraUsuario, usuarioValidaCadastraUsuario, usuarioCadastraUsuarioA, usuarioRemoveUsuario;
	private UsuarioBO usuarioBO;
	
	
	@Before
	public void init(){
		usuarioListaUsuario = new Usuario("admin", "admin");
		usuarioSenhaCerta = new Usuario("admin", "admin");
		usuarioValidaCadastraUsuario = new Usuario("admin", "admin");
		usuarioRemoveUsuario = new Usuario("admin", "admin");
		usuarioCadastraUsuarioA = new Usuario("admin", "admin");
		usuarioCadastraUsuario = new Usuario("admin", "admin");
		usuarioBO = new UsuarioBO();
	}

	@Test
	public void testValidaUsuarioSenhaCerta() throws NegocioException {
		boolean ok = false;
		ok = usuarioBO.validaUsuario(usuarioSenhaCerta);
		assertTrue(ok);
	}
	
	@Test
	public void testValidaCadastroUsuarioA() throws NegocioException{		
		boolean ok = false;
		usuarioCadastraUsuarioA.setNome("Teste Unitario Valida A");
		usuarioCadastraUsuarioA.setAdministrador("N");
		usuarioCadastraUsuarioA.setEmail("testeUnitario@testeUnitario.com");
		usuarioCadastraUsuarioA.setMatricula("123");
		
		ok = usuarioBO.validaCadastroUsuarioA(usuarioCadastraUsuarioA);
		
		assertTrue(ok);
	}

	@Test
	public void testValidaCadastroUsuario() throws NegocioException {
		boolean ok = false;
		usuarioValidaCadastraUsuario.setNome("Teste Unitario Valida");
		usuarioValidaCadastraUsuario.setAdministrador("N");
		usuarioValidaCadastraUsuario.setEmail("testeUnitario@testeUnitario.com");
		usuarioValidaCadastraUsuario.setMatricula("1234");
		ok = usuarioBO.validaCadastroUsuario(usuarioValidaCadastraUsuario);
		assertTrue(ok);
	}
	
	@Test 
	public void testRemoverUsuario() throws NegocioException, SQLException, ParseException {
		boolean ok = false;
		usuarioRemoveUsuario.setNome("Teste Unitario");
		usuarioRemoveUsuario.setAdministrador("N");
		usuarioRemoveUsuario.setEmail("testeUnitario@testeUnitario.com");
		usuarioRemoveUsuario.setMatricula("9898");
		
		usuarioBO.cadastraUsuario(usuarioRemoveUsuario);
		
		ok = usuarioBO.removerUsuario(usuarioRemoveUsuario.getIdUsuario());
		
		assertTrue(ok);
	}

	@Test
	public void testCadastraUsuario() throws NegocioException, SQLException, ParseException {		
		boolean ok = false;
		usuarioCadastraUsuario.setNome("Teste Unitario Cadastra");
		usuarioCadastraUsuario.setAdministrador("N");
		usuarioCadastraUsuario.setEmail("testeUnitario@testeUnitario.com");
		usuarioCadastraUsuario.setMatricula("989898");
		ok = usuarioBO.cadastraUsuario(usuarioCadastraUsuario);
		
		usuarioBO.removerUsuario(usuarioCadastraUsuario.getIdUsuario());
		
		assertTrue(ok);
		
	}

	@Test
	public void testListarUsuario() throws NegocioException {
		assertTrue(usuarioBO.listarUsuario().size() > 0);
	}

}
