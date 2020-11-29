package DAO;

import java.util.ArrayList;
import java.util.List;

import VO.ClientesVO;

public class Teste {

	public static void main(String[] args) {
		
		ClientesDAO dao = new ClientesDAO();
		ClientesVO vo = new ClientesVO();
		ClientesVO vo2 = new ClientesVO();
		//List<ClientesVO> lvo = new ArrayList<ClientesVO>();
		
		vo.setId((long) 1);
		vo.setCpf("125.658.024-47");
		vo.setNome("Rennan Schwartzman");
		vo.setEndereço("Ecoville");
		//dao.modificar(vo);
		
		vo.setId((long) 2);
		vo.setCpf("702.915.614-72");
		vo.setNome("Francisco Jarismar");
		vo.setEndereço("Planalto");
		dao.inserir(vo);
		
		//lvo = dao.listar();
		//for(ClientesVO vo: lvo) {
		/*vo2 = dao.buscar(vo);
			System.out.println(vo2.getNome());
			System.out.println(vo2.getCpf());
			System.out.println(vo2.getEndereço());
		//}*/
		
		
		
	}

}
