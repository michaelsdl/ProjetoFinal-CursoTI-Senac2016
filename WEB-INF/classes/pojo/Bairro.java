/*
Autor: Michael Silva de Lima
*/

package pojo;

public class Bairro {
    int idCidade;
    int idBairro;
    String nome;
    
    public Bairro(){
        idCidade = 0;
        idBairro = 0;
        nome = "";
    }

    public Bairro(int idCidade, int idBairro, String nome) {
        this.idCidade = idCidade;
        this.idBairro = idBairro;
        this.nome = nome;
    }

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public int getIdBairro() {
        return idBairro;
    }

    public void setIdBairro(int idBairro) {
        this.idBairro = idBairro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
