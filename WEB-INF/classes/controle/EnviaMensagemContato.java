package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ContatoDao;
import pojo.Contato;

/**
 * Servlet implementation class EnviaMensagemContato
 */
@WebServlet("/EnviaMensagemContato")
public class EnviaMensagemContato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnviaMensagemContato() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		String nome = request.getParameter("txtNome");
		String email = request.getParameter("txtEmail");
		String nascimento = request.getParameter("txtNascimento");
		String mensagem = request.getParameter("txtMensagem");
		
		ContatoDao cd = new ContatoDao();
		Contato c = new Contato();
		
		c.setNome(nome);
		c.setEmail(email);
		c.setNascimento(nascimento);
		c.setMensagem(mensagem);
		
		if(cd.inserir(c)){
			
			response.getWriter().append("<script>alert('Mensagem enviada com sucesso!');"
					+ "window.location.href='contato.jsp'</script>");
			
		}else{
			
			response.getWriter().append("<script>alert('Não foi possível enviar a mensagem!');"
					+ "window.location.href='contato.jsp'</script>");
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
