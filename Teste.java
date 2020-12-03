package DAO;

import java.util.ArrayList;
import java.util.List;

import VO.AutomovelVO;
import VO.ClientesVO;

public class Teste {

	public static void main(String[] args) {
		
		ClientesDAO cdao = new ClientesDAO();
		AutomovelDAO adao = new AutomovelDAO();
		ClientesVO vo = new ClientesVO();
		//ClientesVO vo2 = new ClientesVO();
		List<AutomovelVO> lvo = new ArrayList<AutomovelVO>();
		AutomovelVO avo = new AutomovelVO();
		
		/*vo.setId((long) 1);
		vo.setCpf("125.658.024-47");
		vo.setNome("Rennan Schwartzman");
		vo.setEndereço("Ecoville");
		//dao.modificar(vo);
		
		avo.setDono(vo);
		avo.setId((long) 1);
		avo.setMarca("Chevrolet");
		avo.setModelo("Cruze");
		avo.setCor("Branco Pérola");
		avo.setAno(2019);
		avo.setPlaca("GAY0O24");
		avo.setQuilometragem(6924);
		adao.inserir(avo);*/
		
		vo.setId((long) 2);
		vo.setCpf("702.915.614-72");
		vo.setNome("Francisco Jarismar");
		vo.setEndereço("Planalto");
		//dao.inserir(vo);
		
		avo.setDono(vo);
		avo.setId((long) 2);
		avo.setMarca("Jeep");
		avo.setModelo("Compass Trailhawlk");
		avo.setCor("Grafite");
		avo.setAno(2020);
		avo.setPlaca("NNY5E03");
		avo.setQuilometragem(1000);
		//adao.modificar(avo);
		
		
		//lvo = adao.listar();
		for(AutomovelVO avo1: lvo) {
			ClientesVO dono = new ClientesVO();
			dono = avo1.getDono();
			System.out.println("CPF: " + dono.getCpf());
			System.out.println("Placa: " + avo1.getPlaca());
			System.out.println("Marca: " + avo1.getMarca());
			System.out.println("Modelo: " + avo1.getModelo());
			System.out.println("Cor: " + avo1.getCor());
			System.out.println("Ano: " + avo1.getAno());
			System.out.println("Quilometragem: " + avo1.getQuilometragem());
			System.out.println("\n");
		/*  System.out.println(vo2.getNome());
			System.out.println(vo2.getCpf());
			System.out.println(vo2.getEndereço());*/
		}
		
		
		
	}

}
