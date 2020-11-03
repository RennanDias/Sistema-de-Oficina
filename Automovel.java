package VO;

public class Automovel {
	private String marca;
	private String modelo;
	private String cor;
	private String placa;
	private int ano;
	private int quilometragem;
	private Pe�a pe�as[];
	private Clientes dono;
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		if (marca.length() == 0 || marca.length() == 0) {
			System.out.println("Entrada inv�lida! Digite algo.");
		}
		else {
			this.marca = marca;
		}
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		if (modelo.length() == 0 || modelo.length() == 0) {
			System.out.println("Entrada inv�lida! Digite algo.");
		}
		else {
			this.modelo = modelo;
		}
	}
	
	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		if (cor.length() == 0 || cor.length() == 0) {
			System.out.println("Entrada inv�lida! Digite algo.");
		}
		else {
			this.cor = cor;
		}
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		if(placa.length() != 7 || !placa.substring(0, 3).matches("[A-Z]*") || !placa.substring(3, 4).matches("[0-9]*") || !placa.substring(4, 5).matches("[A-Z]*") || !placa.substring(5, 7).matches("[0-9]*")) {
			System.out.println("Placa Inv�lida, tente o modelo XXX0X00");
		}
		else {
			this.placa = placa;
		}
		
	}
	
	
	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		if (ano < 1886) {
			System.out.println("Entrada inv�lida! O primeiro autom�vel foi criado somente em 1886!");
		}
		else {
			this.ano = ano;
		}
	}
	
	public int getQuilometragem() {
		return quilometragem;
	}
	
	public void setQuilometragem(int quilometragem) {
		if (quilometragem < 0) {
			System.out.println("Entrada inv�lida! Digite um valor positivo!");
		}
		else {
			this.quilometragem = quilometragem;
		}
	}
	
	public Pe�a[] getPe�as() {
		return pe�as;
	}
	
	public void setPe�as(Pe�a[] pe�as) {
		this.pe�as = pe�as;
	}
	
	public Clientes getDono() {
		return dono;
	}
	
	public void setDono(Clientes dono) {
		this.dono = dono;
	}
	
	
}
