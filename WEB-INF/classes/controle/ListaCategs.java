package controle;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.CategoriaDao;
import pojo.Categoria;

/**
 * Servlet implementation class ListaCategs
 */
@WebServlet("/ListaCategs")
public class ListaCategs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaCategs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		ArrayList<Categoria> categs;
		
		CategoriaDao cd = new CategoriaDao();
		
		categs = cd.listarCategoria();
		
		if(categs != null) {
		
			Categoria c;
			
			String HTML = "";
			String DIV = "";
			
			for (int i = 1; i <= categs.size(); i++) {
				
				c = categs.get(i-1);
				
				DIV = "<li><a href='#conteudo' onClick='listaProds("+c.getIdCategoria()+")'>"+c.getNome()+"</a>"
						+ "</li>";
				
				HTML += DIV;
				
			}
			
			response.getWriter().append(HTML);
		}else{
			
			String HTML = "<h1 style='text-align:center'>Nenhuma categoria cadastrada</h1>";
			response.getWriter().append(HTML);
			
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
