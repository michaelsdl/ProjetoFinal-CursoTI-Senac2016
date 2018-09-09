package modelo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;

import pojo.Usuario;

public class UsuarioDao extends Dao{
	
	public UsuarioDao(){
		
		super();
		
	}
	
    public boolean cadastrarUsuario(Usuario u) {
    	
        String sql = "INSERT into USUARIO (idusuario, nome, nascimento,"
                + " cpf, rg, sexo, email, endereco, bairro_idbairro,"
                + "bairro_cidade_idcidade, usuario, senha)"
                + " values(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
        	
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, u.getIdusuario());
            ps.setString(2, u.getNome());
            ps.setString(3, u.getNascimento());
            ps.setString(4, u.getCpf());
            ps.setString(5, u.getRg());
            ps.setString(6, u.getSexo()+"");
            ps.setString(7,u.getEmail());
            ps.setString(8,u.getEndereco());
            ps.setInt(9,u.getIdbairro());
            ps.setInt(10,u.getIdcidade());
            ps.setString(11,u.getUsuario());
            ps.setString(12,u.getSenha());

            ps.execute();
            
            return true;
            
        } catch (Exception e) {

            e.printStackTrace();
            
            return false;
        }
        
    }
    
    /*Consultando pelo id do usuário*/
    public Usuario consultarUsuario(int idUsuario){
    	
    	Usuario u = new Usuario();
        
        String sql;
               
        sql = "SELECT * from USUARIO where idusuario = ?";
        
        try {
        	
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.setInt(1, idUsuario);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                
                u.setIdusuario(rs.getInt("idusuario"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setNascimento(rs.getString("nascimento"));
                u.setCpf(rs.getString("cpf"));
                u.setRg(rs.getString("rg"));
                u.setEndereco(rs.getString("endereco"));
                u.setSexo(rs.getString("sexo").charAt(0));
                u.setIdbairro(rs.getInt("bairro_idbairro"));
                u.setIdcidade(rs.getInt("bairro_cidade_idcidade"));
                u.setUsuario(rs.getString("usuario"));
                u.setSenha(rs.getString("senha"));
                rs.close();
                
                return u;
                
            }else{
            	
                return null;
            }
  
        } catch (Exception e) {
        	
            e.printStackTrace();
            
            return null;
            
        }
        
    }
    
    /*Consultando pelo usuário e a senha*/
    public Usuario consultarUsuario(Usuario u){
    	
		String sql = "SELECT * from USUARIO where usuario = ? and senha = ?";
        
        try {
        	
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.setString(1, u.getUsuario());
            ps.setString(2, u.getSenha());
            
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                
                u.setIdusuario(rs.getInt("idusuario"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setNascimento(rs.getString("nascimento"));
                u.setCpf(rs.getString("cpf"));
                u.setRg(rs.getString("rg"));
                u.setEndereco(rs.getString("endereco"));
                u.setSexo(rs.getString("sexo").charAt(0));
                u.setIdbairro(rs.getInt("bairro_idbairro"));
                u.setIdcidade(rs.getInt("bairro_cidade_idcidade"));
                u.setUsuario(rs.getString("usuario"));
                u.setSenha(rs.getString("senha"));
                
                rs.close();
                
                return u;
                
            }else{
            	
                return null;
            }
  
        } catch (Exception e) {
        	
            e.printStackTrace();
            
            return null;
            
        }
    	
    }
    
    public boolean deletarUsuario(int idUsuario){
    	
        String sql = "DELETE from USUARIO where idusuario = ?";
        
        try {
        	
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.setInt(1, idUsuario);
            
            ps.execute();
            
            return true;
            
        } catch (Exception e) {
        	
            e.printStackTrace();
            
            return false;
            
        }
    }
    
    public boolean alterarUsuario(Usuario u){
    	
        String sql = "UPDATE USUARIO set idusuario = ?,"
                + "nome = ?, nascimento = ?,cpf = ?,"
                + "rg = ?, sexo = ?, email = ?, endereco = ?,"
                + "bairro_idbairro = ?, bairro_cidade_idcidade = ?,"
                + "usuario = ?, senha = ?  where idusuario = ?";
        
        try {
        	
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.setInt(1, u.getIdusuario());
            ps.setString(2,u.getNome());
            ps.setString(3,u.getNascimento());
            ps.setString(4,u.getCpf());
            ps.setString(5,u.getRg());
            ps.setString(6,u.getSexo()+"");
            ps.setString(7,u.getEmail());
            ps.setString(8,u.getEndereco());
            ps.setInt(9,u.getIdbairro());
            ps.setInt(10,u.getIdcidade());
            ps.setString(11,u.getUsuario());
            ps.setString(12,u.getSenha());
            
            ps.setInt(13,u.getIdusuario());
            
            ps.execute();
            
            return true;
            
        } catch (Exception e) {
        	
            e.printStackTrace();
            
            return false;
            
        }
    }
    
    public ArrayList<Usuario> listarUsuario() {

        ArrayList<Usuario> us = new ArrayList<>();

        String sql = "SELECT * From USUARIO ";
        
        try {
        	
            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            
            Usuario u;
            
            while (rs.next()) {
            	
                u = new Usuario();
                u.setIdusuario(rs.getInt("idusuario"));
                u.setNome(rs.getString("nome"));
                u.setNascimento(rs.getString("nascimento"));
                u.setCpf(rs.getString("cpf"));
                u.setRg(rs.getString("rg"));
                u.setSexo(rs.getString("sexo").charAt(0));
                u.setEmail(rs.getString("email"));
                u.setEndereco(rs.getString("endereco"));
                u.setIdbairro(rs.getInt("bairro_idbairro"));
                u.setIdcidade(rs.getInt("bairro_cidade_idcidade"));
                u.setUsuario(rs.getString("usuario"));
                u.setSenha(rs.getString("senha"));

                us.add(u);
            }
            
        } catch (Exception e) {
        	
            e.printStackTrace();
            
            us = null;
            
        }
        
        return us;
        
    }
}


