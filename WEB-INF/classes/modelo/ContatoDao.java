package modelo;

import java.sql.PreparedStatement;

import pojo.Contato;

public class ContatoDao extends Dao{
	
	public boolean inserir(Contato c){
		
		String sql = "INSERT into CONTATO (nome,email,nascimento,mensagem) "
				+ "values(?, ?, ?, ?)";
		
		try{
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, c.getNome());
			ps.setString(2, c.getEmail());
			ps.setString(3, c.getNascimento());
			ps.setString(4, c.getMensagem());
			
			ps.execute();
			
			return true;
		
		}catch(Exception e){
			
			e.printStackTrace();
			
			return false;
		}
	}
}
