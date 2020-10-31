package VO;

public class Automovel {
	String marca;
	String modelo;
	String cor;
	String placa;
	int ano;
	int quilometragem;
	Peça peças[];
	Clientes dono;
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
		if (marca.length() == 0 || marca.length() == 0) {
			System.out.println("Entrada inválida! Digite algo.");
		}
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
		if (modelo.length() == 0 || modelo.length() == 0) {
			System.out.println("Entrada inválida! Digite algo.");
		}
	}
	
	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
		if (cor.length() == 0 || cor.length() == 0) {
			System.out.println("Entrada inválida! Digite algo.");
		}
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
		if(placa.length() != 7 || !placa.substring(0, 3).matches("[A-Z]*") || !placa.substring(3, 4).matches("[0-9]*") || !placa.substring(4, 5).matches("[A-Z]*") || !placa.substring(5, 7).matches("[0-9]*")) {
			System.out.println("Placa Inválida, tente o modelo XXX0X00");
		}
		
	}
	
	
	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
		if (ano < 1886) {
			System.out.println("Entrada inválida! O primeiro automóvel foi criado somente em 1886!");
		}
	}
	
	public int getQuilometragem() {
		return quilometragem;
	}
	
	public void setQuilometragem(int quilometragem) {
		this.quilometragem = quilometragem;
		if (quilometragem < 0) {
			System.out.println("Entrada inválida! Digite um valor positivo!");
		}
	}
	
	public Peça[] getPeças() {
		return peças;
	}
	
	public void setPeças(Peça[] peças) {
		this.peças = peças;
	}
	
	public Clientes getDono() {
		return dono;
	}
	
	public void setDono(Clientes dono) {
		this.dono = dono;
	}
	
	
}
