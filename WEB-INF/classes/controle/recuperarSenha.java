package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class recuperarSenha
 */
@WebServlet("/recuperarSenha")
public class recuperarSenha extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public recuperarSenha() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String email = request.getParameter("txtEmail");
		String cpf = request.getParameter("txtCpf");
		String rg = request.getParameter("txtRg");
		
		if(email.equals("") || cpf.equals("") || rg.equals("")){
			
			response.getWriter().append("<script>alert('Por favor, preencha todos os campos!');"
					+ "window.location.href='recuperarSenha.jsp'</script>");
		}else{
			
			response.getWriter().append("<script>"
					+ "if(confirm('Deseja que sua senha seja enviada para o E-Mail cadastrado ?')){"
					+"alert('Sua senha foi enviada para seu E-Mail.');"
					+"}else{alert('a recuperação de senha foi cancelada!')}"
					+ "window.location.href='recuperarSenha.jsp'</script>");
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
