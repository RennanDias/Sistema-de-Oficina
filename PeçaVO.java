package VO;
public class PeçaVO extends ServiçoVO {
	private String fabricante;
	private AutomovelVO automoveis;
	
	public String getFabricante() {
		return fabricante;
	}
	
	public void setFabricante(String fabricante) {
		if (fabricante != null) {
			if (fabricante.length() == 0) {
				System.out.println("Entrada inválida! Digite algo.");
			}
			else {
				this.fabricante = fabricante;
			}
		}
		else {
			System.out.println("Entrada inválida! Digite algo.");
		}
	}
	
	public AutomovelVO getAutomoveis() {
		return automoveis;
	}

	public void setAutomoveis(AutomovelVO automoveis) {
		if (automoveis != null) {
			this.automoveis = automoveis;
		}
		else {
			System.out.println("Nada encontrado! Adicione um automóvel a este cliente!");
		}
	}
	
}
