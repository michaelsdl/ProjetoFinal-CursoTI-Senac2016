/*
Autor: Michael Silva de Lima

Descrição: Foi necessário a criação de duas formas de consulta
para o funcinamento do sistema. No MER a tabela estado possui um 
relacionamento com a tabela cidade, na tabela cidade existe uma 
chave estrangeira que faz referência a tabela Estado, não poderão ser
feitas inserções de cidade que ainda não possuem estados cadastrados.
*/

package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pojo.Estado;

/**
 *
 * @author usuario
 */
public class EstadoDao extends Dao {

    public EstadoDao() {
        super();
    }
    
    /*Consulta pelo nome*/
    public Estado consultarEstado(Estado e) {
        String sql = "SELECT * from ESTADO where nome = ?";

        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, e.getNome());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e.setIdEstado(rs.getInt("idestado"));
                e.setNome(rs.getString("nome"));

                rs.close();

                return e;
            } else {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }
    /*------------*/
    
    /*Consulta pelo id*/
    public String consultarEstado(int idestado) {
        String sql = "SELECT * from ESTADO where idestado = ?";

        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, idestado);

            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {

                return rs.getString("nome");
                
            } else {
                
                return null;
            }
        } catch (Exception ex) {
            
            ex.printStackTrace();
            
            return null;
        }

    }
    /*------------*/

    public boolean cadastrarEstado(Estado e) {
        String sql = "INSERT into ESTADO (idestado,nome)"
                + "values(?,?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, e.getIdEstado());
            ps.setString(2, e.getNome());
            ps.execute();

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

    /* deleta pelo idestado*/
    public boolean deletarEstado(Estado e) {
        String sql = "DELETE from ESTADO where idestado = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, e.getIdEstado());

            ps.execute();

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }
    
    /* deleta pelo nome do estado*/
    public boolean deletarEstado(String nome) {
    	
        String sql = "DELETE from ESTADO where nome = ?";
        
        try {
        	
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, nome);

            ps.execute();

            return true;
            
        } catch (Exception ex) {
        	
            ex.printStackTrace();
            
            return false;
            
        }

    }
    
    
    public boolean alterarEstado(Estado e) {
        String sql = "UPDATE ESTADO set idestado = ?,"
                + " nome = ? where idestado = ?";

        try {
            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.setInt(1, e.getIdEstado());
            ps.setString(2, e.getNome());

            ps.setInt(3, e.getIdEstado());

            ps.execute();

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }
}
