package VO;
public class Pe�a {
	private String nome;
	private float pre�o;
	private String fabricante;
	private Automovel automoveis[];
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		if (nome.length() == 0 || nome == null) {
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
		if (fabricante.length() == 0 || fabricante == null) {
			System.out.println("Entrada inv�lida! Digite algo.");
		}
		else {
			this.fabricante = fabricante;
		}
	}
	
	public Automovel[] getAutomoveis() {
		return automoveis;
	}

	public void setAutomoveis(Automovel[] automoveis) {
		if (automoveis == null) {
			System.out.println("Nada encontrado! Adicione um autom�vel a este cliente!");
		}
		else {
			this.automoveis = automoveis;
		}
	}
	
	
}
