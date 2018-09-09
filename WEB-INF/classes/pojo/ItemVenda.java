package pojo;

public class ItemVenda {
	
	int idVenda;
	int idProduto;
	int quantidade;
	float preco;
	
	public ItemVenda(){
		
		idVenda = 0;
		idProduto = 0;
		quantidade = 0;
		preco = 0;
		
	}
	
	public ItemVenda(int idVenda, int idProduto, int quantidade, float preco) {
		
		this.idVenda = idVenda;
		this.idProduto = idProduto;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public int getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
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

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	
}
