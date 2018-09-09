package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pojo.ItemVenda;

public class ItemVendaDao extends Dao{

	public ItemVendaDao() {
		
		super();
		
	}

	public ItemVenda consultarItem(int idVenda, int idProduto) {

		String sql = "SELECT * from ITEMVENDA where venda_idvenda = ? and produto_idproduto = ?";

		ItemVenda iv = new ItemVenda();

		try {

			PreparedStatement ps = conexao.prepareStatement(sql);

			ps.setInt(1, idVenda);
			ps.setInt(2, idProduto);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				iv.setIdVenda(rs.getInt("venda_idvenda"));
				iv.setIdProduto(rs.getInt("produto_idproduto"));
				iv.setQuantidade(rs.getInt("quantidade"));
				iv.setPreco(rs.getFloat("preco"));

				return iv;

			} else {

				return null;
			}

		} catch (Exception e) {

			e.printStackTrace();

			return null;
		}

	}

	public boolean cadastrarItem(ItemVenda iv) {

		String sql = "INSERT into ITEMVENDA (venda_idvenda, produto_idproduto, preco, quantidade)"
		+ "values(?, ?, ?, ?)";
		
		try{
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setInt(1, iv.getIdVenda());
			ps.setInt(2, iv.getIdProduto());
			ps.setFloat(3, iv.getPreco());
			ps.setInt(4, iv.getQuantidade());
			
			ps.execute();
			
			return true;
			
		}catch(Exception e){
			
			e.printStackTrace();
			
			return false;
		}
	}
	
	public boolean deletarItem(int idProduto, int idVenda) {

		String sql = "DELETE from VENDA where produto_idproduto = "+idProduto+""
				+ "and venda_idvenda = "+idVenda+"";
		
		try{
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.execute();
			
			return true;
			
		}catch(Exception e){
			
			e.printStackTrace();
			
			return false;
		}
	}
	
	public boolean alterarItem(ItemVenda iv) {

		String sql = "UPDATE ITEMVENDA set venda_idvenda = ?, produto_idproduto = ?, preco = ?,"
				+ "quantidade = ? where venda_idvenda = ? and produto_idproduto = ?";
		
		try{
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setInt(1, iv.getIdVenda());
			ps.setInt(2, iv.getIdProduto());
			ps.setFloat(3, iv.getPreco());
			ps.setInt(4, iv.getQuantidade());
			
			ps.setInt(5, iv.getIdVenda());
			ps.setInt(6, iv.getIdProduto());
			
			ps.execute();
			
			return true;
			
		}catch(Exception e){
			
			e.printStackTrace();
			
			return false;
		}
	}
	
	
}
