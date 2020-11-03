package VO;
public class Pe�a {
	private String nome;
	private float pre�o;
	private String fabricante;
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		if (nome.length() == 0 || nome.length() == 0) {
			System.out.println("Entrada inv�lida! Digite algo.");
		}
		else {
			this.nome = nome;
		}
	}
	
	public float getPre�o() {
		return pre�o;
	}
	
	public void setPre�o(float pre�o) {
		if (this.pre�o < 0) {
			System.out.println("Entrada inv�lida! Digite um valor positivo!");
		}
		else {
			this.pre�o = pre�o;
		}	
	}
	
	public String getFabricante() {
		return fabricante;
	}
	
	public void setFabricante(String fabricante) {
		if (fabricante.length() == 0 || fabricante.length() == 0) {
			System.out.println("Entrada inv�lida! Digite algo.");
		}
		else {
			this.fabricante = fabricante;
		}
	}
	
	
}
