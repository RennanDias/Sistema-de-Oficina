package BO;

import java.sql.SQLException;

import DAO.AutomovelDAO;
import DAO.OrçamentoDAO;
import DAO.VendaDAO;
import VO.AutomovelVO;
import VO.ClientesVO;
import VO.OrçamentoVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class OrçamentoBO implements BaseInterBO <OrçamentoVO> {
	OrçamentoDAO dao = new OrçamentoDAO();
	VendaDAO vdao = new VendaDAO();
	AutomovelDAO adao = new AutomovelDAO();
	
public OrçamentoVO adicionar(OrçamentoVO r) { //Recebe o vetor total de automoveis
	//peças e serviços e, com isso, vai adicionar peças e serviços para o veículo específico dito
	try {
		r = dao.inserir(r);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	/*try {
		vdao.inserir(r.getVenda());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	
		return r;
}

	public OrçamentoVO atualizarValor(OrçamentoVO o) { //Recebe um vetor de orçamentos, roda cada um deles para decidir qual
	
		try {
			o = dao.atualizar(o);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return o;
	}
	
	public OrçamentoVO alterar(OrçamentoVO o) { //Recebe um vetor de orçamentos, roda cada um deles para decidir qual
		
		/*vdao.modificarPeça(o.getVenda());
		vdao.modificarServiço(o.getVenda());*/
		try {
			o = dao.modificar(o);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return o;
	}

	public void deletar(OrçamentoVO a) { //Deleta um orçamento 
		
		try {
			dao.excluir(a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ObservableList<OrçamentoVO> listar() { //Recebe um vetor de orçamentos, busca dentro dele os orçamentos relativos
		//à placa do veículo digitada e exibe eles
		ObservableList<OrçamentoVO> orçamentos = FXCollections.observableArrayList();
		
		try {
			orçamentos = dao.listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return orçamentos;
	}	
	
	public ObservableList<OrçamentoVO> pesquisar(OrçamentoVO a) { //Recebe um vetor de orçamentos, busca dentro dele os orçamentos relativos
		//à placa do veículo digitada e exibe eles
		ObservableList<OrçamentoVO> orçamentos = FXCollections.observableArrayList();
		ObservableList<OrçamentoVO> orçamentosRetornados = FXCollections.observableArrayList();
		ObservableList<AutomovelVO> automoveis = FXCollections.observableArrayList();
		AutomovelVO autovo = new AutomovelVO();
		autovo.setPlaca("ZZZ9Z99");
		a.setAutomoveis(autovo);
		try {
			orçamentos = dao.buscar(a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(OrçamentoVO ovo : orçamentos) {
			AutomovelVO auto = new AutomovelVO();
			ClientesVO cliente = new ClientesVO();
			auto = ovo.getAutomoveis();
			cliente.setCpf("000.000.000-00");
			auto.setDono(cliente);
			auto.setId((long) 0);
			automoveis = adao.buscar(auto);
			for(AutomovelVO avo : automoveis) {
				ovo.setAutomoveis(avo);
			}
			orçamentosRetornados.add(ovo);
		}
		return orçamentosRetornados;
	}	
}
