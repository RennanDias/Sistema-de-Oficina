package VO;

public class Automovel {
	String marca;
	String modelo;
	String cor;
	String placa;
	int ano;
	int quilometragem;
	Pe�a pe�as[];
	Clientes dono;
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
		if (marca.length() == 0 || marca.length() == 0) {
			System.out.println("Entrada inv�lida! Digite algo.");
		}
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
		if (modelo.length() == 0 || modelo.length() == 0) {
			System.out.println("Entrada inv�lida! Digite algo.");
		}
	}
	
	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
		if (cor.length() == 0 || cor.length() == 0) {
			System.out.println("Entrada inv�lida! Digite algo.");
		}
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
		if (placa.length() < 7 || placa.length() > 7) {
			System.out.println("Placa inv�lida! Use a configura��o XXX0X00");
		}
	}
	
	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
		if (ano < 1886) {
			System.out.println("Entrada inv�lida! O primeiro autom�vel foi criado somente em 1886!");
		}
	}
	
	public int getQuilometragem() {
		return quilometragem;
	}
	
	public void setQuilometragem(int quilometragem) {
		this.quilometragem = quilometragem;
		if (quilometragem < 0) {
			System.out.println("Entrada inv�lida! Digite um valor positivo!");
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
