package pojo;

public class Contato {
	String nome;
	String email;
	String nascimento;
	String mensagem;
	
	public Contato(){
		nome = "";
		email = "";
		nascimento = "";
		mensagem = "";
	}
	
	

	public Contato(String nome, String email, String nascimento, String mensagem) {

		this.nome = nome;
		this.email = email;
		this.nascimento = nascimento;
		this.mensagem = mensagem;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
}
