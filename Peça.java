package VO;
public class Peça {
	private String nome;
	private float preço;
	private String fabricante;
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		if (nome.length() == 0 || nome.length() == 0) {
			System.out.println("Entrada inválida! Digite algo.");
		}
		else {
			this.nome = nome;
		}
	}
	
	public float getPreço() {
		return preço;
	}
	
	public void setPreço(float preço) {
		if (this.preço < 0) {
			System.out.println("Entrada inválida! Digite um valor positivo!");
		}
		else {
			this.preço = preço;
		}	
	}
	
	public String getFabricante() {
		return fabricante;
	}
	
	public void setFabricante(String fabricante) {
		if (fabricante.length() == 0 || fabricante.length() == 0) {
			System.out.println("Entrada inválida! Digite algo.");
		}
		else {
			this.fabricante = fabricante;
		}
	}
	
	
}
