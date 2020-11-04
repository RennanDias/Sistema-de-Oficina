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
	private Or�amento or�amento[];
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		if (marca != null) {
			if (marca.length() == 0) {
				System.out.println("Entrada inv�lida! Digite algo.");
			}
			else {
				this.marca = marca;
			}
		}
		else {
			System.out.println("Entrada inv�lida! Digite algo.");
		}
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		if (modelo != null) {
			if (modelo.length() == 0) {
				System.out.println("Entrada inv�lida! Digite algo.");
			}
			else {
				this.modelo = modelo;
			}
		}
		else {
			System.out.println("Entrada inv�lida! Digite algo.");
		}
	}
	
	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		if (cor != null) {
			if (cor.length() == 0) {
				System.out.println("Entrada inv�lida! Digite algo.");
			}
			else {
				this.cor = cor;
			}
		}
		else {
			System.out.println("Entrada inv�lida! Digite algo.");
		}
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		if (placa != null) {
			if(placa.length() != 7 || !placa.substring(0, 3).matches("[A-Z]*") || !placa.substring(3, 4).matches("[0-9]*") ||
					  !placa.substring(4, 5).matches("[A-Z]*") || !placa.substring(5, 7).matches("[0-9]*")) {
						System.out.println("Placa Inv�lida, tente o modelo XXX0X00");
					}
					else {
						this.placa = placa;
					}
		}
		else {
			System.out.println("Entrada inv�lida! Digite algo.");
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
		if (pe�as != null) {
			this.pe�as = pe�as;
		}
		else {
			System.out.println("Nada encontrado! Adicione pe�as para este autom�vel!");
		}
	}
	
	public Clientes getDono() {
		return dono;
	}
	
	public void setDono(Clientes dono) {
		this.dono = dono;
	}
	
	public Or�amento[] getOr�amento() {
		return or�amento;
	}
	
	public void setOr�amento(Or�amento[] or�amento) {
		if (or�amento != null) {
			this.or�amento = or�amento;
		}
		else {
			System.out.println("Nada encontrado! Adicione um or�amento para este autom�vel!");
		}
	}
	
}
