/*
    Autor: Michael Silva de Lima
   
*/

package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import pojo.Admin;
import pojo.Usuario;


public class AdminDao extends Dao {
    
    public AdminDao(){
        super();
    }
    
    /*Operações realizadas em contas de Administradores*/
    public boolean cadastrarAdmin(Admin a) {
        String sql = "INSERT into ADMIN (idAdmin, nomeCompleto, email,"
                + " nascimento, usuario, senha) values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, a.getIdAdmin());
            ps.setString(2, a.getNomeCompleto());
            ps.setString(3, a.getEmail());
            ps.setString(4, a.getNascimento());
            ps.setString(5, a.getUsuario());
            ps.setString(6, a.getSenha());

            ps.execute();
            
            return true;
            
        } catch (Exception e) {

            e.printStackTrace();
            
            return false;
        }
        
    }
     
    public Admin consultarAdmin(Admin a){
        
        String sql;
        
            sql = "SELECT * from ADMIN where usuario = ?";
       
        try {
        	
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.setString(1,a.getUsuario());
                      
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                
                a.setIdAdmin(rs.getInt("idadmin"));
                a.setNomeCompleto(rs.getString("nomecompleto"));
                a.setEmail(rs.getString("email"));
                a.setNascimento(rs.getString("nascimento"));
                a.setUsuario(rs.getString("usuario"));
                a.setSenha(rs.getString("senha"));
                rs.close();
                
                return a;
                
            }else{
            	
                return null;
            }
  
        } catch (Exception e) {
        	
            e.printStackTrace();
            
            return null;
            
        }
        
    }
     
    public boolean deletarAdmin(Admin a){
    	
        String sql = "DELETE from ADMIN where usuario = ? and senha = ?";
        
        try {
        	
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.setString(1,a.getUsuario());
            ps.setString(2,a.getSenha());
            
            ps.execute();
            
            return true;
            
        } catch (Exception e) {
        	
            e.printStackTrace();
            
            return false;
            
        }
    }
       
    public boolean alterarAdmin(Admin a){
    	
        String sql = "UPDATE ADMIN set nomecompleto = ?,"
                + "email = ?, nascimento = ?,usuario = ?,"
                + "senha = ? where idadmin = ?";
        
        try {
        	
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.setString(1, a.getNomeCompleto());
            ps.setString(2,a.getEmail());
            ps.setString(3,a.getNascimento());
            ps.setString(4,a.getUsuario());
            ps.setString(5,a.getSenha());
            
            ps.setInt(6,a.getIdAdmin());
            
            ps.execute();
            
            return true;
            
        } catch (Exception e) {
        	
            e.printStackTrace();
            return false;
            
        }
    }
       
    public ArrayList<Admin> listarAdmin() {

        ArrayList<Admin> ads = new ArrayList<>();

        String sql = "Select * From Admin ";
        
        try {
        	
            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            
            Admin a;
            
            while (rs.next()) {
                a = new Admin();
                a.setIdAdmin(rs.getInt("idadmin"));
                a.setNomeCompleto(rs.getString("nomecompleto"));
                a.setNascimento(rs.getString("nascimento"));
                a.setEmail(rs.getString("email"));
                a.setUsuario(rs.getString("usuario"));
                a.setSenha(rs.getString("senha"));


                ads.add(a);
            }
            
        } catch (Exception e) {
        	
            e.printStackTrace();
            ads = null;
        }
        
        return ads;
    }
    
    
    /*Operações realizadas em contas de Usuários*/
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
    
    public Usuario consultarUsuario(Usuario u){
        
        String sql;
               
        sql = "SELECT * from USUARIO where idusuario = ?";
        
        try {
        	
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.setInt(1,u.getIdusuario());
            
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
    
    public boolean deletarUsuario(Usuario u){
    	
        String sql = "DELETE from USUARIO where idusuario = ?";
        
        try {
        	
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.setInt(1,u.getIdusuario());
            
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
