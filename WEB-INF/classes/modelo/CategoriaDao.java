/*
Autor: Michael Silva de Lima

Descrição: Para cadastrar um novo Produto deverá certifica-se de 
que a categoria do mesmo já foi cadastrada, pois a tabela Categoria
possui um relacinamento com a tabela Produto, e na tabela Produto existe
uma chave estrageira que faz referência a categoria. 
 */

package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import pojo.Categoria;

public class CategoriaDao extends Dao {

	public CategoriaDao() {
		super();
	}

	public boolean cadastrarCategoria(Categoria c) {
		String sql = "INSERT into CATEGORIA (idcategoria,nome) values" + "(?,?)";
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, c.getIdCategoria());
			ps.setString(2, c.getNome());

			ps.execute();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deletarCategoria(int idCategoria) {

		String sql = "DELETE from CATEGORIA where idcategoria = ?";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, idCategoria);
			ps.execute();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Categoria consultarCategoria(int idCategoria) {
		String sql = "SELECT * from CATEGORIA where idcategoria = ?";
		Categoria c = new Categoria();

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, idCategoria);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				c.setIdCategoria(rs.getInt("idcategoria"));
				c.setNome(rs.getString("nome"));

				rs.close();

				return c;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean alterarCategoria(Categoria c) {
		String sql = "UPDATE CATEGORIA set nome = ? where idcategoria = ?";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, c.getNome());
			ps.setInt(2, c.getIdCategoria());
			ps.execute();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public ArrayList<Categoria> listarCategoria() {

		ArrayList<Categoria> categorias = new ArrayList<>();

		String sql = "SELECT * from CATEGORIA";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			Categoria c;

			while (rs.next()) {
				c = new Categoria();
				c.setIdCategoria(rs.getInt("idcategoria"));
				c.setNome(rs.getString("nome"));

				categorias.add(c);
			}

		} catch (Exception e) {
			e.printStackTrace();
			categorias = null;
		}
		return categorias;
	}
}
