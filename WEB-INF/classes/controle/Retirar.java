package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.CarrinhoDao;
import pojo.Carrinho;

/**
 * Servlet implementation class Retirar
 */
@WebServlet("/Retirar")
public class Retirar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Retirar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Carrinho c = new Carrinho();
		
		CarrinhoDao cd = new CarrinhoDao();
		
		//pega o id do usuário na sessão	
		HttpSession session = request.getSession();
		
		Object objIdUsuario = session.getAttribute("idUsuario");
			
		Object logado = session.getAttribute("logado");
		
		if(logado != null){
		
			int idUsuario = (Integer)objIdUsuario;
			
			c.setIdUsuario(idUsuario);
			c.setIdProduto(Integer.parseInt(request.getParameter("idprod")));
			c.setQuantidade(-1);
			
			cd.retirar(c);
			
			int total = cd.total(idUsuario);
			
			response.getWriter().append("" + total);
			
		}else{
			
			String result = "deslogado";
			response.getWriter().append(result);
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
