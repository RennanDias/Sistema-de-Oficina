package VO;

public class ClientesVO extends PessoaVO{
	private AutomovelVO[] automoveis =  new AutomovelVO[1];

	public AutomovelVO[] getAutomoveis() {
		return automoveis;
	}

	public void setAutomoveis(AutomovelVO automoveis) {
		if (automoveis != null) {
			this.automoveis[(this.automoveis.length - 1)] = automoveis;
		}
		else {
			System.out.println("Nada encontrado! Adicione um automóvel a este cliente!");
		}
	}
	
		
}