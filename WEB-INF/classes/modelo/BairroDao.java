/*
    Autor: Michael Silva de Lima

    Descrição: Esta classe só será acessada internamente,
    servirá para pegar os dados da tabela Bairro que possui um 
    relacionamento com a tabela Usuario.
 */

package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pojo.Bairro;

public class BairroDao extends Dao {

    public BairroDao() {
        super();
    }
    
    /*Consulta pelo nome*/
    public Bairro consultarBairro(Bairro b) {
        String sql = "SELECT * from BAIRRO where nome = ?";

        try {
            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.setString(1, b.getNome());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                b.setIdCidade(rs.getInt("cidade_idcidade"));
                b.setIdBairro(rs.getInt("idbairro"));
                b.setNome(rs.getString("nome"));

                rs.close();

                return b;
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /*-----------*/

    /*Consulta pelo id*/
    public String consultarBairro(int idbairro,int idcidade) {
        
        String sql = "SELECT * from BAIRRO where idbairro = ? and cidade_idcidade = ?";

        try {
            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.setInt(1, idbairro);
            ps.setInt(2, idcidade);

            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getString("nome");
            } else {
                return "";
            }
            

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
    /*--------*/

    public boolean cadastrarBairro(Bairro b) {
        String sql = "INSERT into BAIRRO (cidade_idcidade,idbairro,nome)"
                + "values(?,?,?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, b.getIdCidade());
            ps.setInt(2, b.getIdBairro());
            ps.setString(3, b.getNome());
            ps.execute();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    
    /* deleta pelo idcidade e idbairro*/
    public boolean deletarBairro(Bairro b) {
    	
        String sql = "DELETE from BAIRRO where cidade_idcidade = ? and idbairro = ?";

        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, b.getIdCidade());
            ps.setInt(2, b.getIdBairro());

            ps.execute();

            return true;

        } catch (Exception e) {
        	
            e.printStackTrace();
            
            return false;
            
        }
    }
    
    /* deleta pelo nome do bairro */
    public boolean deletarBairro(String nome) {
    	
        String sql = "DELETE from BAIRRO where nome = ?";

        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, nome);

            ps.execute();

            return true;

        } catch (Exception e) {
        	
            e.printStackTrace();
            
            return false;
            
        }
    }

    public boolean alterarBairro(Bairro b) {
        String sql = "UPDATE BAIRRO set idbairro = ?, cidade_idcidade = ?, nome = ?"
                + "where idbairro = ? and cidade_idcidade = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, b.getIdBairro());
            ps.setInt(2, b.getIdCidade());
            ps.setString(3, b.getNome());

            ps.setInt(4, b.getIdBairro());
            ps.setInt(5, b.getIdCidade());

            ps.execute();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
