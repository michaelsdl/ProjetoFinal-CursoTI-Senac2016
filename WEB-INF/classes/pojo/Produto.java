/*
 * Autor: Michael Silva de Lima
 */

package pojo;

public class Produto {
	int idProduto;
	String nome;
	String descProd;
	float preco;
	int quantidade;
	String foto;
	int idCategoria;

	public Produto() {
		// TODO Auto-generated constructor stub
		this.idProduto = 0;
		this.nome = "";
		this.descProd = "";
		this.preco = 0;
		this.quantidade = 0;
		this.foto = "";
		this.idCategoria = 0;
	}

	public Produto(int idProduto, String nome, String descProd, float preco, int quantidade, String foto,
			int idCategoria) {

		this.idProduto = idProduto;
		this.nome = nome;
		this.descProd = descProd;
		this.preco = preco;
		this.quantidade = quantidade;
		this.foto = foto;
		this.idCategoria = idCategoria;

	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescProd() {
		return descProd;
	}

	public void setDescProd(String descProd) {
		this.descProd = descProd;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

}
