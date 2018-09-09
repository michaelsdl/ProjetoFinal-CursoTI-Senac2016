package pojo;

public class Venda {
	
	int idVenda;
	int idUsuario;
	String dataVenda;
	
	public Venda(){
		
		idVenda = 0;
		idUsuario = 0;
		dataVenda = "";
		
	}

	public Venda(int idVenda, int idUsuario, String dataVenda) {
		
		this.idVenda = idVenda;
		this.idUsuario = idUsuario;
		this.dataVenda = dataVenda;
	}

	public int getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(String dataVenda) {
		this.dataVenda = dataVenda;
	}
	

}
