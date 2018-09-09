/*
Autor: Michael Silva de Lima
*/

package pojo;

public class Cidade {
    int idCidade;
    int idEstado;
    String nome;
    
    public Cidade(){
        idCidade = 0;
        idEstado = 0;
        nome = "";
        
    }

    public Cidade(int idCidade, int idEstado, String nome) {
        this.idCidade = idCidade;
        this.idEstado = idEstado;
        this.nome = nome;
    }

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
