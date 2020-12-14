package BO;

import java.sql.SQLException;

import DAO.AutomovelDAO;
import DAO.Or�amentoDAO;
import DAO.VendaDAO;
import VO.AutomovelVO;
import VO.ClientesVO;
import VO.Or�amentoVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Or�amentoBO implements BaseInterBO <Or�amentoVO> {
	Or�amentoDAO dao = new Or�amentoDAO();
	VendaDAO vdao = new VendaDAO();
	AutomovelDAO adao = new AutomovelDAO();
	
public Or�amentoVO adicionar(Or�amentoVO r) { //Recebe o vetor total de automoveis
	//pe�as e servi�os e, com isso, vai adicionar pe�as e servi�os para o ve�culo espec�fico dito
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

	public Or�amentoVO atualizarValor(Or�amentoVO o) { //Recebe um vetor de or�amentos, roda cada um deles para decidir qual
	
		try {
			o = dao.atualizar(o);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return o;
	}
	
	public Or�amentoVO alterar(Or�amentoVO o) { //Recebe um vetor de or�amentos, roda cada um deles para decidir qual
		
		/*vdao.modificarPe�a(o.getVenda());
		vdao.modificarServi�o(o.getVenda());*/
		try {
			o = dao.modificar(o);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return o;
	}

	public void deletar(Or�amentoVO a) { //Deleta um or�amento 
		
		try {
			dao.excluir(a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ObservableList<Or�amentoVO> listar() { //Recebe um vetor de or�amentos, busca dentro dele os or�amentos relativos
		//� placa do ve�culo digitada e exibe eles
		ObservableList<Or�amentoVO> or�amentos = FXCollections.observableArrayList();
		
		try {
			or�amentos = dao.listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return or�amentos;
	}	
	
	public ObservableList<Or�amentoVO> pesquisar(Or�amentoVO a) { //Recebe um vetor de or�amentos, busca dentro dele os or�amentos relativos
		//� placa do ve�culo digitada e exibe eles
		ObservableList<Or�amentoVO> or�amentos = FXCollections.observableArrayList();
		ObservableList<Or�amentoVO> or�amentosRetornados = FXCollections.observableArrayList();
		ObservableList<AutomovelVO> automoveis = FXCollections.observableArrayList();
		AutomovelVO autovo = new AutomovelVO();
		autovo.setPlaca("ZZZ9Z99");
		a.setAutomoveis(autovo);
		try {
			or�amentos = dao.buscar(a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Or�amentoVO ovo : or�amentos) {
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
			or�amentosRetornados.add(ovo);
		}
		return or�amentosRetornados;
	}	
}
