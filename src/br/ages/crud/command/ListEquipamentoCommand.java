package br.ages.crud.command;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.EquipamentoBO;
import br.ages.crud.bo.LivroBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Equipamento;
import br.ages.crud.model.Livro;

public class ListEquipamentoCommand implements Command {
	
	private String proxima;
	private EquipamentoBO equipamentoBO;
	
	@Override
	public String execute(HttpServletRequest request)
			throws SQLException, PersistenciaException, ParseException, NegocioException {
		
		this.equipamentoBO = new EquipamentoBO();
		proxima = "equipamento/listEquipamentos.jsp";

		try {
			List<Equipamento> listaEquipamentos = equipamentoBO.listarEquipamento();
			request.setAttribute("listaEquipamentos", listaEquipamentos);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msgErro", e.getMessage());
		}

		return proxima;
		
//		insert into TB_PROJETOS
//		(Id_Projeto, Nome_Projeto, Programa, Origem, Data_Cadastro, Id_Cordenador)
//		values
//		(1, "Projeto Teste", "Desenvolvimento AGES", "TESTES", "2016-04-05", 10);
//		
//		insert into TB_EQUIPAMENTOS
//		(Id_Equipamento, N_Patrimonio, Status, Modelo, 
//		 Valor_Aquisicao, Data_Cadastro, Observacao, Id_Marca, Id_Projeto)
//		VALUES
//		(1, 123, 1, "Inspiron 15R", 
//		 2500, '2016-04-05', "Observacao 1", 1, 1);
//		
//		alter table tb_equipamentos drop foreign key fk_id_projeto;
//		ALTER TABLE tb_equipamentos DROP INDEX id_projeto_unique;
//		alter table tb_equipamentos drop foreign key fk_id_marca;
//		ALTER TABLE tb_equipamentos DROP INDEX id_marca_unique;
//		
//		insert into TB_EQUIPAMENTOS
//		(Id_Equipamento, N_Patrimonio, Status, Modelo, 
//		 Valor_Aquisicao, Data_Cadastro, Observacao, Id_Marca, Id_Projeto)
//		VALUES
//		(2, 456, 1, "HP", 
//		 1000, '2016-04-05', "Observacao 2", 1, 1);
//		
//		insert into TB_EQUIPAMENTOS
//		(Id_Equipamento, N_Patrimonio, Status, Modelo, 
//		 Valor_Aquisicao, Data_Cadastro, Observacao, Id_Marca, Id_Projeto)
//		VALUES
//		(3, 789, 1, "Galaxy", 
//		 750, '2016-04-05', "Observacao 3", 1, 1);
//		
//		insert into TB_COMPUTADOR
//		(Id_Computador, Tipo_Computador, Id_Equipamento)
//		values
//		(1, "Notebook", 1);
//		
//		insert into TB_PERIFERICO
//		(Id_Periferico, Tipo_Periferico, Id_Equipamento)
//		values
//		(1, "Impressora", 2);
//		
//		alter table tb_mobile change Tipo_Equipamento Tipo_Mobile VARCHAR(120);
//		
//		insert into TB_MOBILE
//		(Id_Mobile, Tipo_Mobile, Id_Equipamento)
//		values
//		(1, "Celular", 3);
//		
//		CREATE OR REPLACE VIEW VW_EQUIPAMENTOS AS
//		SELECT 
//		if(Id_Mobile is not null, 'M', 
//		  if(Id_Computador is not null, 'C', 'P')
//		) as Tipo_Equipamento,
//		Id_Mobile, Id_Computador, Id_Periferico, N_Patrimonio, Data_Cadastro, Valor_Aquisicao, Observacao
//		FROM 
//		TB_EQUIPAMENTOS as EQUIP
//		left join TB_COMPUTADOR as COMP on COMP.ID_EQUIPAMENTO = EQUIP.ID_EQUIPAMENTO
//		left join TB_PERIFERICO as PERIF on PERIF.ID_EQUIPAMENTO = EQUIP.ID_EQUIPAMENTO
//		left join TB_MOBILE AS MOB on MOB.ID_EQUIPAMENTO = EQUIP.ID_EQUIPAMENTO;
	}

}
