package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.UsuarioDao;
import pojo.Usuario;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession();

		String txtUsuario = request.getParameter("txtUsuario");
		
		String txtSenha = request.getParameter("txtSenha");
		
		Usuario u = new Usuario();
		
		u.setUsuario(txtUsuario);
		u.setSenha(txtSenha);
		
		UsuarioDao ud = new UsuarioDao();
		
		if (ud.codErro == 0) {
			
			u = ud.consultarUsuario(u);
						
			if (u != null) {
				
				session.setAttribute("logado", "logado");
				
				session.setAttribute("msg", "<div id='divLogado'>Bem-vindo(a), "+u.getNome()+"</div>");
				
				session.setAttribute("idUsuario", u.getIdusuario());
				
				session.setAttribute("logout", "<button onClick='logout()' id='logout'>Logout</button>");
				
				response.sendRedirect("index.jsp");
				
			}else{
				
				response.getWriter().append("<script>alert('Dados inválidos!');"
						+ "window.location.href='index.jsp';"
						+ "</script>");
				
			}

		} else {
			
			response.getWriter().append("<script>alert('Erro ao conectar!');"
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
