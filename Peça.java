package VO;
public class Peça {
	String nome;
	float preço;
	String fabricante;
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
		if (nome.length() == 0 || nome.length() == 0) {
			System.out.println("Entrada inválida! Digite algo.");
		}
	}
	
	public float getPreço() {
		return preço;
	}
	
	public void setPreço(float preço) {
		this.preço = preço;
		if (this.preço < 0) {
			System.out.println("Entrada inválida! Digite um valor positivo!");
		}
				
	}
	
	public String getFabricante() {
		return fabricante;
	}
	
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
		if (fabricante.length() == 0 || fabricante.length() == 0) {
			System.out.println("Entrada inválida! Digite algo.");
		}
	}
	
	
}
