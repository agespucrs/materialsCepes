package br.ages.crud.bo;

import java.util.List;

import br.ages.crud.dao.MobileDAO;
import br.ages.crud.exception.NegocioException;

public class MobileBO {

	private MobileDAO mobileDAO;

	public MobileBO() {
		mobileDAO = new MobileDAO();
	}

}
