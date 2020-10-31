package VO;
public class Pe�a {
	String nome;
	float pre�o;
	String fabricante;
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
		if (nome.length() == 0 || nome.length() == 0) {
			System.out.println("Entrada inv�lida! Digite algo.");
		}
	}
	
	public float getPre�o() {
		return pre�o;
	}
	
	public void setPre�o(float pre�o) {
		this.pre�o = pre�o;
		if (this.pre�o < 0) {
			System.out.println("Entrada inv�lida! Digite um valor positivo!");
		}
				
	}
	
	public String getFabricante() {
		return fabricante;
	}
	
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
		if (fabricante.length() == 0 || fabricante.length() == 0) {
			System.out.println("Entrada inv�lida! Digite algo.");
		}
	}
	
	
}
