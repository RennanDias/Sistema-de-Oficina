package VO;
public class Servi�o {
	private String nome;
	private float valor;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		if (nome != null) {
			if (nome.length() == 0) {
				System.out.println("Entrada inv�lida! Digite algo.");
			}
			else {
				this.nome = nome;
			}
		}
		else {
			System.out.println("Entrada inv�lida! Digite algo.");
		}
	}
	
	public float getValor() {
		return valor;
	}
	
	public void setValor(float valor) {
		if (valor < 0) {
			System.out.println("Entrada inv�lida! Digite um valor positivo!");
		}
		else {
			this.valor = valor;
		}
	}
	
	
}
