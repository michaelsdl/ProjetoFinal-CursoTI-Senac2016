/*
Autor: Michael Silva de Lima
*/

package pojo;

public class Estado {
    int idEstado;
    String nome;
    
    public Estado(){
        idEstado = 0;
        nome = "";
    }

    public Estado(int idEstado, String nome) {
        this.idEstado = idEstado;
        this.nome = nome;
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
