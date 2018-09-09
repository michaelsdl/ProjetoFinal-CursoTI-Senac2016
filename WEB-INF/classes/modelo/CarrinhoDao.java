package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Carrinho;

public class CarrinhoDao extends Dao {

	public CarrinhoDao() {
		// TODO Auto-generated constructor stub
		super();
	}

	public boolean deletar(int idUsuario){
		
		String sql = "DELETE from CARRINHO where usuario_idusuario = ?";
		
		PreparedStatement ps;
		
		try{
			 ps = conexao.prepareStatement(sql);
			 
			 ps.setInt(1, idUsuario);
			 
			 ps.execute();
			 
			 return true;
			 
		}catch(Exception e ) {
			
			e.printStackTrace();
			
			return false;
		}
	}
	
	public Carrinho consultar(Carrinho car) {
		
		String sql = "SELECT * from CARRINHO where produto_idproduto = ? and usuario_idusuario = ?";
		
		Carrinho c = new Carrinho();
		
		PreparedStatement ps;
		
		try {
			
			ps = conexao.prepareStatement(sql);
			
			ps.setInt(1, car.getIdProduto());
			ps.setInt(2, car.getIdUsuario());
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				c.setIdUsuario(c.getIdUsuario());
				c.setIdProduto(c.getIdProduto());
				c.setQuantidade(rs.getInt("quantidade"));
				
			} else {
				
				c = null;
				
			}
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			codErro = 101;
			msgErro = ex.getMessage();
			c = null;
		}
		
		return c;
		
	}

	public boolean inserir(Carrinho c) {
		
		String sql = "INSERT into CARRINHO (usuario_idusuario, produto_idproduto, quantidade) " 
				+ "values (?,?,?)";
		
		PreparedStatement ps;
		
		boolean ret = false;
		
		try {
			
			ps = conexao.prepareStatement(sql);
			
			ps.setInt(1, c.getIdUsuario());
			ps.setInt(2, c.getIdProduto());
			ps.setInt(3, c.getQuantidade());
			
			ps.execute();
			
			ret = true;
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			codErro = 102;
			msgErro = ex.getMessage();
			
		}
		
		return ret;
		
	}

	public boolean atualizar(Carrinho c) {
		
		String sql = "UPDATE CARRINHO set quantidade = quantidade + ?"
				+ " where usuario_idusuario = ? and produto_idproduto = ?";
		
		PreparedStatement ps;
		
		boolean ret = false;
		
		try {
			
			ps = conexao.prepareStatement(sql);
			
			ps.setInt(1, c.getQuantidade());
			ps.setInt(2, c.getIdUsuario());
			ps.setInt(3, c.getIdProduto());
			
			ps.execute();
			
			ret = true;
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			codErro = 103;
			msgErro = ex.getMessage();
		}
		
		return ret;
		
	}

	public int adicionar(Carrinho c) {

		Carrinho cx = consultar(c);
		
		int novaQtd = 0;

		if (cx == null) {
			
			if (inserir(c)) {
				
				novaQtd = c.getQuantidade();
				
			}
			
		} else {
			
			if (atualizar(c)) {
				novaQtd = c.getQuantidade() + cx.getQuantidade();
					
			}
			
		}
		
		return novaQtd;
	}
	
	public int retirar(Carrinho c) {
		
		Carrinho ca = consultar(c);
		
		int novaQtd = 0;
		
		if(ca != null) {
			
			int qtd = ca.getQuantidade();
			
			if(qtd > 0) {
			
				if(atualizar(c)) {
					
					novaQtd = c.getQuantidade() + ca.getQuantidade();
							
				}
			}
			
		}
		
		return novaQtd;
	}
	
	/*Retornará a soma da quantidade de itens adicionados ao carrinho*/
	public int total(int idUsuario){
		
		String sql = "SELECT sum(quantidade) from CARRINHO "
				+ "where usuario_idusuario = ?";
		
		int total = 0;
		
		try {
		
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setInt(1, idUsuario);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
			
				total = rs.getInt("sum(quantidade)");
				
			}else{
				
				return 0;
				
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}

		return total;
	}
	
	/*Retornará a contagem de produtos diferentes adicionados ao carrinho*/
	public int contar(int idUsuario){
		
		String sql = "SELECT count(produto_idproduto) from CARRINHO "
				+ "where usuario_idusuario = ?";
		
		int contagem = 0;
		
		try {
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setInt(1, idUsuario);
			
			ResultSet rs = ps.executeQuery();
			
			contagem = rs.getInt("count(produto_idproduto)");
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
		return contagem;
	}

	public ArrayList<Carrinho> listar(int idUsuario) {

		ArrayList<Carrinho> itensCarrinho = new ArrayList<>();

		String sql = "SELECT * from CARRINHO Where usuario_idusuario = ? and quantidade != 0"
				+ " Order By produto_idproduto";

		try {
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setInt(1, idUsuario);
						
			ResultSet rs = ps.executeQuery();
			
			Carrinho c;
			
			while (rs.next()) {
				
				c = new Carrinho();
				c.setIdUsuario(rs.getInt("usuario_idusuario"));
				c.setIdProduto(rs.getInt("produto_idproduto"));
				c.setQuantidade(rs.getInt("quantidade"));

				itensCarrinho.add(c);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			// TODO Auto-generated catch block
			itensCarrinho = null;
			
		}
		
		return itensCarrinho;
		
	}

}
