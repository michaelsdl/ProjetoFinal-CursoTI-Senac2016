/*
Autor: Michael Silva de Lima
*/

package pojo;

public class Admin {
    
    int idAdmin;
    String nomeCompleto;
    String email;
    String nascimento;
    String usuario;
    String senha;
    
    public Admin(){
        idAdmin = 0;
        nomeCompleto = "";
        email = "";
        nascimento = "";
        usuario = "";
        senha = "";
    }
    
    public Admin(int idAdmin,String nomeCompleto, String email, String nascimento, String usuario, String senha){
        this.idAdmin = idAdmin;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.nascimento = nascimento;
        this.usuario = usuario;
        this.senha = senha;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
    
}
