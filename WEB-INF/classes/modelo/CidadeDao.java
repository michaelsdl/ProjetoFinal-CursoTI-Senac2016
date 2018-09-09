/*
Autor: Michael Silva de Lima

Descrição: A tabela Cidade tem um relacimento com a tabela Bairro
para inserir um novo bairro deverá certificar-se de que a cidade já foi
cadastrada. Houve a necessidade de fazer duas formas de consulta para o 
funcinamento do sistema.
 */

package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pojo.Cidade;

public class CidadeDao extends Dao{
    public CidadeDao(){
        super();
    }
    /*Cosulta pelo nome*/
    public Cidade consultarCidade(Cidade c){
        String sql = "SELECT * from CIDADE where nome = ?";
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.setString(1,c.getNome());
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                c.setIdCidade(rs.getInt("idcidade"));
                c.setIdEstado(rs.getInt("estado_idestado"));
                c.setNome(rs.getString("nome"));
                
                rs.close();
                
                return c;
            }else{
                return null;
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /*------------*/
    
    /*Consulta pelo id*/
    public Cidade consultarCidade(int idcidade){
        String sql = "SELECT * from CIDADE where idcidade = ?";
        Cidade c = new Cidade();
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.setInt(1,idcidade);
            
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                
                c.setIdEstado(rs.getInt("estado_idestado"));
                c.setNome(rs.getString("nome"));
                
                return c;
            }else{
                return null;
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /*-----------------------*/
    
    public boolean cadastrarCidade(Cidade c){
        String sql = "INSERT into CIDADE (idcidade,estado_idestado,nome)"
                + "values(?,?,?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1,c.getIdCidade());
            ps.setInt(2,c.getIdEstado());
            ps.setString(3,c.getNome());
            ps.execute();
            
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /* deleta pelo idcidade e idestado */
    public boolean deletarCidade(Cidade c){
        String sql = "DELETE from CIDADE where idcidade = ? and estado_idestado = ?";
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1,c.getIdCidade());
            ps.setInt(2,c.getIdEstado());
            
            ps.execute();
            
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /* deleta pelo nome*/
    public boolean deletarCidade(String nome){
    	
        String sql = "DELETE from CIDADE where nome = ?";
        
        
        try {
        	
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.setString(1,nome);
            
            ps.execute();
            
            return true;
            
        } catch (Exception e) {
        	
            e.printStackTrace();
            
            return false;
            
        }
    }
    
    public boolean alterarCidade(Cidade c){
        String sql = "UPDATE CIDADE set estado_idestado = ?, idcidade = ?, nome = ?"
                + "where estado_idestado = ? and idcidade = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1,c.getIdEstado());
            ps.setInt(2,c.getIdCidade());
            ps.setString(3,c.getNome());
            
            ps.setInt(4,c.getIdEstado());
            ps.setInt(5,c.getIdCidade());
            
            ps.execute();
            
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
