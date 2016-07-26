package br.ages.crud.bo;

import java.sql.SQLException;
import java.util.List;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import br.ages.crud.dao.DispositivoMovelDAO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.model.DispositivoMovel;

public class DispositivoMovelBO {
	DispositivoMovelDAO dispositivoMovelDAO = null;
	
	public DispositivoMovelBO() {
		dispositivoMovelDAO = new DispositivoMovelDAO();
	}
	
	public boolean cadastraDispositivoMovel(DispositivoMovel dispositivoMovel) throws NegocioException, SQLException, ParseException {
		try {
			return dispositivoMovelDAO.cadastrarDispositivoMovel(dispositivoMovel);
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
	} 
	
	public List<DispositivoMovel> listarDispositivoMovel() throws NegocioException {
		List<DispositivoMovel> listDispositivoMovel = null;
		try {
			listDispositivoMovel = dispositivoMovelDAO.listarDispositivosMoveis();
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
		return listDispositivoMovel;
	} 
	
	public void alterarDispositivoMovel(DispositivoMovel dispositivoMovel) throws NegocioException, SQLException, ParseException {
		try {
			dispositivoMovelDAO.alterarDispositivoMovel(dispositivoMovel);
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
	}
}
