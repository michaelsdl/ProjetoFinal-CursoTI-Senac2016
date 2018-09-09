package pojo;

public class Carrinho {
	int idUsuario;
	int idProduto;
	int quantidade;

	public Carrinho() {
		// TODO Auto-generated constructor stub
		this.idUsuario = 0;
		this.idProduto = 0;
		this.quantidade = 0;
	}
	
	public Carrinho(int idUsuario, int idProduto, int quantidade) {
		this.idUsuario = idUsuario;
		this.idProduto = idProduto;
		this.quantidade = quantidade;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
