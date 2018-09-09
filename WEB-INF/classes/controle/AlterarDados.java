package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.BairroDao;
import modelo.CidadeDao;
import modelo.EstadoDao;
import modelo.UsuarioDao;
import pojo.Bairro;
import pojo.Cidade;
import pojo.Estado;
import pojo.Usuario;

/**
 * Servlet implementation class AlterarDados
 */
@WebServlet("/AlterarDados")
public class AlterarDados extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarDados() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String nome = request.getParameter("txtNomeUsuario");
		String nascimento = request.getParameter("txtNascimento");
		String cpf = request.getParameter("txtCpf");
		String rg = request.getParameter("txtRg");
		String sexo = request.getParameter("btnSexo");
		String email = request.getParameter("txtEmail");
		String endereco = request.getParameter("txtEndereco");
		String bairro = request.getParameter("txtBairro");
		String cidade = request.getParameter("txtCidade");
		String estado = request.getParameter("txtEstado");
		String usuario = request.getParameter("txtUsuario");
		String senha = request.getParameter("txtSenha");
		
		Estado e = new Estado();
		
		e.setIdEstado(0);
		e.setNome(estado);
		
		CidadeDao cd = new CidadeDao();
		
		cd.deletarCidade(cidade);
		
		BairroDao bd = new BairroDao();
		
		bd.deletarBairro(nome);
		
		EstadoDao ed = new EstadoDao();
		
		ed.deletarEstado(estado);
		
		
		
		ed.cadastrarEstado(e);
		
		int idEstado = ed.consultarEstado(e).getIdEstado();
					
		e.setIdEstado(idEstado);
		e.setNome(estado);
		
		if(!ed.alterarEstado(e)){
			
			response.getWriter().append("<script>alert('Erro ao alterar o estado!');"
					+ "window.location.href='index.jsp';"
					+ "</script>");
			
		}

		Cidade c = new Cidade();
		
		c.setIdEstado(idEstado);
		c.setNome(cidade);
		c.setIdCidade(0);
		
		
		
		cd.cadastrarCidade(c);
				
		int idCidade = cd.consultarCidade(c).getIdCidade();
				
		c.setIdCidade(idCidade);
		
		if(!cd.alterarCidade(c)){
			
			response.getWriter().append("<script>alert('Erro ao alterar Cidade!');"
					+ "window.location.href='index.jsp';"
					+ "</script>");
			
		}
			
		
		
		Bairro b = new Bairro();
		
		b.setIdBairro(0);
		b.setNome(bairro);
		b.setIdCidade(idCidade);
		
		
		
		bd.cadastrarBairro(b);
			
		int idBairro = bd.consultarBairro(b).getIdBairro();
		
		b.setIdBairro(idBairro);
		
		if(!bd.alterarBairro(b)){
			
			response.getWriter().append("<script>alert('Erro ao alterar Bairro!');"
					+ "window.location.href='index.jsp';"
					+ "</script>");
			
		}
		
		Usuario u = new Usuario();
		
		HttpSession session = request.getSession();
		
		int idUsuario = (Integer)session.getAttribute("idUsuario");
		
		u.setIdusuario(idUsuario);
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
		
		if(ud.consultarUsuario(idUsuario) != null){
			
			if(ud.alterarUsuario(u)){
				
				session.invalidate();
				response.getWriter().append("<script>alert('Alteração concluída!');"
						+ "window.location.href='index.jsp';"
						+ "</script>");
				
			}else{
				
				response.getWriter().append("<script>alert('Não foi possível alterar usuário!');"
						+ "window.location.href='index.jsp';"
						+ "</script>");
			}
			
		}else{
			
			response.getWriter().append("<script>alert('O usuário não existe!');"
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
