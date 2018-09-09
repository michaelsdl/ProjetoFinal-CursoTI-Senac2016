package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.BairroDao;
import modelo.CidadeDao;
import modelo.EstadoDao;
import modelo.UsuarioDao;
import pojo.Bairro;
import pojo.Cidade;
import pojo.Estado;
import pojo.Usuario;

/**
 * Servlet implementation class CadastrarUsuario
 */
@WebServlet("/CadastrarUsuario")
public class CadastrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String nome = request.getParameter("txtNomeUsuario").trim();
		String nascimento = request.getParameter("txtNascimento");
		String cpf = request.getParameter("txtCpf");
		String rg = request.getParameter("txtRg");
		String sexo = request.getParameter("btnSexo");
		String email = request.getParameter("txtEmail".trim());
		String endereco = request.getParameter("txtEndereco").trim();
		String bairro = request.getParameter("txtBairro").trim();
		String cidade = request.getParameter("txtCidade").trim();
		String estado = request.getParameter("txtEstado").trim();
		String usuario = request.getParameter("txtUsuario").trim();
		String senha = request.getParameter("txtSenha").trim();
		
		
		/*Para cadastrar o novo usuário primeiro deverá ser feito o
		 * cadastro do Estado, da Cidade e do Bairro nas suas respectivas tabelas,
		 * depois pegar os IDs e finalmente cadastrar o usuário na tabela Usuario*/
		Estado e = new Estado();
		
		e.setIdEstado(0);
		e.setNome(estado);
		
		EstadoDao ed = new EstadoDao();
		
		int idEstado = 0;
		
		if(ed.consultarEstado(e) == null){
		
			ed.cadastrarEstado(e);

		}
		
		idEstado = ed.consultarEstado(e).getIdEstado();
		
		Cidade c = new Cidade();
		
		c.setIdEstado(idEstado);
		c.setNome(cidade);
		c.setIdCidade(0);
		
		CidadeDao cd = new CidadeDao();
		
		int idCidade = 0;
		
		if(cd.consultarCidade(c) == null){
			
			cd.cadastrarCidade(c);	
			
		}
		
		idCidade = cd.consultarCidade(c).getIdCidade();
		
		Bairro b = new Bairro();
		
		b.setIdBairro(0);
		b.setNome(bairro);
		b.setIdCidade(idCidade);
		
		BairroDao bd = new BairroDao();
		
		int idBairro = 0;
		
		if(bd.consultarBairro(b) == null){
			
			bd.cadastrarBairro(b);
		
		}	
		
		idBairro = bd.consultarBairro(b).getIdBairro();
		
		/* A partir daqui será feito o cadastro na tabela Usuario*/
		Usuario u = new Usuario();
		
		u.setIdusuario(0);
		u.setNome(nome);
		u.setNascimento(nascimento);
		u.setCpf(cpf);
		u.setRg(rg);
		u.setSexo(sexo.charAt(0));
		u.setEmail(email);
		u.setEndereco(endereco);
		u.setIdbairro(idBairro);
		u.setIdcidade(idCidade);
		u.setUsuario(usuario);
		u.setSenha(senha);
		
		UsuarioDao ud = new UsuarioDao();
		
		if(ud.consultarUsuario(u) == null){
			
			if(ud.cadastrarUsuario(u)){
				
				response.getWriter().append("<script>alert('Cadastro Concluído!');"
						+ "window.location.href='index.jsp';"
						+ "</script>");
				
			}else{
				
				response.getWriter().append("<script>alert('Não foi possível cadastrar!');"
						+ "window.location.href='index.jsp';"
						+ "</script>");
			}
			
			
		}else{
			
			response.getWriter().append("<script>alert('O usuário já existe!');"
					+ "window.location.href='index.jsp';"
					+ "</script>");
			
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
