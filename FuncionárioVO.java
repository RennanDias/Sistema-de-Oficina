package VO;

public class FuncionárioVO extends PessoaVO{
	
	private String usuario;
	private String senha;
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		if (usuario != null) {
			if (usuario.length() == 0) {
				System.out.println("Entrada inválida! Digite algo.");
			}
			else {
				this.usuario = usuario;
			}
		}
		else {
			System.out.println("Entrada inválida! Digite algo.");
		}
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		if (senha != null) {
			if (senha.length() == 0) {
				System.out.println("Entrada inválida! Digite algo.");
			}
			else {
				this.senha = senha;
			}
		}
		else {
			System.out.println("Entrada inválida! Digite algo.");
		}
	}

}
