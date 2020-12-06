package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import VO.AutomovelVO;
import VO.ClientesVO;
import VO.FuncionárioVO;

public class Teste {

	public static void main(String[] args) {
		
		ClientesDAO cdao = new ClientesDAO();
		AutomovelDAO adao = new AutomovelDAO();
		FuncionárioDAO fdao = new FuncionárioDAO();
		ClientesVO vo = new ClientesVO();
		FuncionárioVO func = new FuncionárioVO();
		FuncionárioVO func2 = new FuncionárioVO();
		ClientesVO vo2 = new ClientesVO();
		List<AutomovelVO> lvo = new ArrayList<AutomovelVO>();
		AutomovelVO avo = new AutomovelVO();
		
		/*func.setId((long) 2);
		func.setCpf("710.600.500-40");
		func.setNome("Adilson Genocida");
		func.setEndereço("Sampa");
		func.setUsuario("PicaDeAço");
		func.setSenha("opapa123");
		fdao.inserirFuncionário(func);*/
		
		/*func.setId((long) 1);
		func.setCpf("700.600.500-40");
		func.setNome("Alexandre Oliveira");
		func.setEndereço("Sampa");*/
		func.setUsuario("PicaDeAço"); //-------------------- 
		func.setSenha("opapa123"); //---------------------- 
		func2 = fdao.buscar(func); //----------------------
		
		/*vo.setId((long) 3);
		vo.setCpf("701.920.614-72");
		vo.setNome("Geraldo Henriqson");
		vo.setEndereço("Ecoville");
		try {
			vo2 = cdao.buscar(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println("Nome: " + func2.getNome()); //------------------
		
		/*avo.setDono(vo);
		avo.setId((long) 1);
		avo.setMarca("Chevrolet");
		avo.setModelo("Cruze");
		avo.setCor("Branco Pérola");
		avo.setAno(2019);
		avo.setPlaca("GAY0O24");
		avo.setQuilometragem(6924);
		adao.inserir(avo);*/
		
		/*vo.setId((long) 2);
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
		//adao.modificar(avo);*/
		
		
		try {
			lvo = adao.listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			/*System.out.println(vo2.getNome());
			System.out.println(vo2.getCpf());
			System.out.println(vo2.getEndereço());*/
		}
		
		
		
	}

}
