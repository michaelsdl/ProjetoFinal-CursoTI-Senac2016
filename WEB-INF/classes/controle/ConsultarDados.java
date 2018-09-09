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
import pojo.Cidade;
import pojo.Usuario;

/**
 * Servlet implementation class ConsultarDados
 */
@WebServlet("/ConsultarDados")
public class ConsultarDados extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultarDados() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		int idUsuario = (Integer)session.getAttribute("idUsuario");
		
		UsuarioDao ud = new UsuarioDao();
		
		Usuario u = ud.consultarUsuario(idUsuario);
		
		int idBairro = u.getIdbairro();
		int idCidade = u.getIdcidade();
		
		BairroDao bd = new BairroDao();
		
		String bairro = bd.consultarBairro(idBairro,idCidade);
		
		CidadeDao cd = new CidadeDao();
		
		Cidade c = cd.consultarCidade(idCidade);
		
		String cidade = c.getNome();
		
		int idEstado = c.getIdEstado();
		
		EstadoDao ed = new EstadoDao();
		
		String estado = ed.consultarEstado(idEstado);
		
		if(u != null){
					
			session.setAttribute("nome", u.getNome());
			session.setAttribute("nascimento", u.getNascimento());
			session.setAttribute("cpf", u.getCpf());
			session.setAttribute("rg", u.getRg());
			session.setAttribute("sexo", u.getSexo());
			session.setAttribute("email", u.getEmail());
			session.setAttribute("endereco", u.getEndereco());
			session.setAttribute("bairro", bairro);
			session.setAttribute("cidade", cidade);
			session.setAttribute("estado", estado);
			session.setAttribute("usuario", u.getUsuario());
			session.setAttribute("senha", u.getSenha());
			
			return;
			
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
