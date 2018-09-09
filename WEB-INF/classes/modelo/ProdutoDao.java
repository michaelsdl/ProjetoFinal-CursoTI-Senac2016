/*
 * Autor: Michael Silva de Lima
 */

package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Produto;

public class ProdutoDao extends Dao {

	
    public boolean cadastrarProduto(Produto p){
        String sql = "INSERT into PRODUTO (idproduto,nome,quantidade,"
                + "preco,foto,categoria_idcategoria,descprod) values"
                + "(?,?,?,?,?,?,?)";
       
        try {
             PreparedStatement ps = conexao.prepareStatement(sql);
             
             ps.setInt(1, p.getIdProduto());
             ps.setString(2, p.getNome());
             ps.setInt(3, p.getQuantidade());
             ps.setFloat(4,p.getPreco());
             ps.setString(5,p.getFoto());
             ps.setInt(6,p.getIdCategoria());
             ps.setString(7,p.getDescProd());
             
             ps.execute();
             
             return true;
             
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean deletarProduto(int idProduto){
        String sql = "DELETE from PRODUTO where idproduto = ?";
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1,idProduto);
            ps.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean alterarProduto(Produto p){
        String sql = "UPDATE PRODUTO set idproduto = ?, nome = ?, quantidade = ?,"
                + "preco = ?, foto = ?, categoria_idcategoria = ? where idproduto = ?";
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1,p.getIdProduto());
            ps.setString(2,p.getNome());
            ps.setInt(3,p.getQuantidade());
            ps.setFloat(4, p.getPreco());
            ps.setString(5, p.getFoto());
            ps.setInt(6,p.getIdCategoria());
            
            ps.setInt(7,p.getIdProduto());
            
            ps.execute();
            
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public Produto consultarProduto(int idProduto){
        String sql = "SELECT * from PRODUTO where idproduto = ?";
        Produto p = new Produto();
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, idProduto);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                p.setIdProduto(rs.getInt("idproduto"));
                p.setNome(rs.getString("nome"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setPreco(rs.getFloat("preco"));
                p.setFoto(rs.getString("foto"));
                p.setIdCategoria(rs.getInt("categoria_idcategoria"));
                p.setDescProd(rs.getString("descprod"));
                
                rs.close();
                
                return p;
                
            }else{
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Produto> listar(int idCategoria) {

		ArrayList<Produto> produtos = new ArrayList<Produto>();

		String sql = "Select * From Produto ";

		if (idCategoria != 0) {

			sql += "Where categoria_idcategoria = ? ";
		}

		sql += "Order By nome";

		try {

			PreparedStatement ps = conexao.prepareStatement(sql);

			if (idCategoria != 0) {

				ps.setInt(1, idCategoria);

			}

			ResultSet rs = ps.executeQuery();

			Produto p;

			if(rs.next()){

				while (rs.next()) {
	
					p = new Produto();
					p.setIdProduto(rs.getInt("idproduto"));
					p.setNome(rs.getString("nome"));
					p.setDescProd(rs.getString("descprod"));
					p.setPreco(rs.getFloat("preco"));
					p.setQuantidade(rs.getInt("quantidade"));
					p.setFoto(rs.getString("foto"));
					p.setIdCategoria(rs.getInt("categoria_idcategoria"));
	
					produtos.add(p);
	
				}
				
	    	}else{
	    		
	    		produtos = null;
	    	}

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			produtos = null;

		}

		return produtos;

	}
	
    
    public ArrayList<Produto> buscarProduto(String busca){
    	
    	String sql = "SELECT * from PRODUTO where nome like '%"+busca+"%' or descprod like '%"+busca+"%' order by nome";
    	
    	ArrayList<Produto> produtos = new ArrayList<Produto>();
    	
    	try{
	    	PreparedStatement ps = conexao.prepareStatement(sql);
	    	
	    	ResultSet rs = ps.executeQuery();
	    	
	    	Produto p;
	    	
	    	if(rs.next()){

				while (rs.next()) {
	
					p = new Produto();
					p.setIdProduto(rs.getInt("idproduto"));
					p.setNome(rs.getString("nome"));
					p.setDescProd(rs.getString("descprod"));
					p.setPreco(rs.getFloat("preco"));
					p.setQuantidade(rs.getInt("quantidade"));
					p.setFoto(rs.getString("foto"));
					p.setIdCategoria(rs.getInt("categoria_idcategoria"));
	
					produtos.add(p);
	
				}
				
	    	}else{
	    		
	    		produtos = null;
	    	}
	    	
        } catch (Exception e) {
        	
            e.printStackTrace();
            
            produtos = null;
    	
        }
    	return produtos;
    }
}
