package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import pojo.Venda;

public class VendaDao extends Dao {

	public VendaDao() {
		super();
	}

	public Venda consultarVenda(int idUsuario) {

		String sql = "SELECT * from VENDA where usuario_idusuario = ?";

		Venda v = new Venda();

		try {

			PreparedStatement ps = conexao.prepareStatement(sql);

			ps.setInt(1, idUsuario);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				v.setIdVenda(rs.getInt("idvenda"));
				v.setIdUsuario(rs.getInt("usuario_idusuario"));
				v.setDataVenda(rs.getString("datavenda"));

				return v;

			} else {

				return null;
			}

		} catch (Exception e) {

			e.printStackTrace();

			return null;
		}

	}

	public boolean cadastrarVenda(Venda v) {

		String sql = "INSERT into VENDA (idvenda, usuario_idusuario, datavenda)" + "values(?, ?, ?)";
		
		try{
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setInt(1, v.getIdVenda());
			ps.setInt(2, v.getIdUsuario());
			ps.setString(3, v.getDataVenda());
			
			ps.execute();
			
			return true;
			
		}catch(Exception e){
			
			e.printStackTrace();
			
			return false;
		}
	}
	
	public boolean deletarVenda(int idUsuario, int idVenda) {

		String sql = "DELETE from VENDA where usuario_idusuario = "+idUsuario+""
				+ " and idvenda = "+idVenda+"";
		
		try{
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.execute();
			
			return true;
			
		}catch(Exception e){
			
			e.printStackTrace();
			
			return false;
		}
	}
	
	public boolean alterarVenda(Venda v) {

		String sql = "UPDATE VENDA set idvenda = ?, usuario_idusuario = ?, datavenda = ?"
				+ "where idvenda = ? and usuario_idusuario = ?";
		
		try{
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setInt(1, v.getIdVenda());
			ps.setInt(2, v.getIdUsuario());
			ps.setString(3, v.getDataVenda());
			
			ps.setInt(4, v.getIdVenda());
			ps.setInt(5, v.getIdUsuario());
			
			ps.execute();
			
			return true;
			
		}catch(Exception e){
			
			e.printStackTrace();
			
			return false;
		}
	}
	
}
