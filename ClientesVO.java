package VO;

public class ClientesVO extends PessoaVO{
	private AutomovelVO automoveis[];

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