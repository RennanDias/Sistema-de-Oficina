package VO;
public class Servi�o {
	String nome;
	float valor;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
		if (nome.length() == 0 || nome.length() == 0) {
			System.out.println("Entrada inv�lida! Digite algo.");
		}
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
		if (valor < 0) {
			System.out.println("Entrada inv�lida! Digite um valor positivo!");
		}
	}
	
	
}
