/*
 * Autor: Michael Silva de Lima
 */

package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {

	private final String USUARIO = "root";
	private final String SENHA = "1234";
	private final String BD = "lojavirtual";
	private final String SERVIDOR = "localhost";
	private final String DRIVER = "com.mysql.jdbc.Driver";
	public String msgErro;
	public int codErro;
	Connection conexao;

	public Dao() {

		codErro = 0;
		msgErro = "";

		String url = "jdbc:mysql://" + SERVIDOR + "/" + BD+"?useUnicode=true&characterEncoding=utf-8";

		try {

			Class.forName(DRIVER);
			conexao = DriverManager.getConnection(url, USUARIO, SENHA);

		} catch (SQLException ex) {

			codErro = 2;
			msgErro = ex.getMessage();

		} catch (ClassNotFoundException ex) {

			codErro = 1;
			msgErro = "Driver n�o encontrado";

		}
	}
}
