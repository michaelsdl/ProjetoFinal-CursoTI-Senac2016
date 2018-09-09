/*
Autor: Michael Silva de Lima
*/

package pojo;

public class Categoria {
    int idCategoria;
    String nome;
    
    public Categoria(){
        idCategoria = 0;
        nome = "";
    }

    public Categoria(int idCategoria, String nome) {
        this.idCategoria = idCategoria;
        this.nome = nome;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
