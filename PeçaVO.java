package VO;
public class Pe�aVO {
	private String nome;
	private float pre�o;
	private String fabricante;
	private AutomovelVO automoveis[];
	
	
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
		if (fabricante != null) {
			if (fabricante.length() == 0) {
				System.out.println("Entrada inv�lida! Digite algo.");
			}
			else {
				this.fabricante = fabricante;
			}
		}
		else {
			System.out.println("Entrada inv�lida! Digite algo.");
		}
	}
	
	public AutomovelVO[] getAutomoveis() {
		return automoveis;
	}

	public void setAutomoveis(AutomovelVO[] automoveis) {
		if (automoveis != null) {
			this.automoveis = automoveis;
		}
		else {
			System.out.println("Nada encontrado! Adicione um autom�vel a este cliente!");
		}
	}
	
}
