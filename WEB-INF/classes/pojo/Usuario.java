/*
Autor: Michael Silva de Lima
*/

package pojo;

public class Usuario {
    int idusuario;
    String nome;
    String nascimento;
    String cpf;
    String rg;
    char sexo;
    String email;
    String endereco;
    int idbairro;
    int idcidade;
    String usuario;
    String senha;

    public Usuario() {
        this.idusuario = 0;
        this.nome = "";
        this.nascimento = "";
        this.cpf = "";
        this.rg = "";
        this.sexo = '\0';
        this.email = "";
        this.endereco = "";
        this.idbairro = 0;
        this.idcidade = 0;
        this.usuario = "";
        this.senha = "";
    }
    
        public Usuario(int idusuario, String nome, String nascimento, String cpf, String rg, char sexo, String email, String endereco, int idbairro, int idcidade, String usuario, String senha) {
        this.idusuario = idusuario;
        this.nome = nome;
        this.nascimento = nascimento;
        this.cpf = cpf;
        this.rg = rg;
        this.sexo = sexo;
        this.email = email;
        this.endereco = endereco;
        this.idbairro = idbairro;
        this.idcidade = idcidade;
        this.usuario = usuario;
        this.senha = senha;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdbairro() {
        return idbairro;
    }

    public void setIdbairro(int idbairro) {
        this.idbairro = idbairro;
    }

    public int getIdcidade() {
        return idcidade;
    }

    public void setIdcidade(int idcidade) {
        this.idcidade = idcidade;
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
