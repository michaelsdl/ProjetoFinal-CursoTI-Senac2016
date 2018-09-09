package controle;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.CarrinhoDao;
import modelo.ProdutoDao;
import pojo.Carrinho;
import pojo.Produto;

/**
 * Servlet implementation class ListarCarrinho
 */
@WebServlet("/ListarCarrinho")
public class ListarCarrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarCarrinho() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
				
		CarrinhoDao cd = new CarrinhoDao();
		
		ProdutoDao pd = new ProdutoDao();
		
		//pega o id do usuário na sessão
		int idUsuario = (int)request.getSession().getAttribute("idUsuario");
		
		String result = "";
		
		ArrayList<Carrinho> listaCar = cd.listar(idUsuario);
		
		for(int i = 0; i < listaCar.size(); i++) {
			
			Carrinho ca = listaCar.get(i);
			
			Produto p = pd.consultarProduto(ca.getIdProduto());
			
			result = "<br />Produto: "+p.getNome()+" -- Quantidade: "+ca.getQuantidade()+" -- ID: "+
			p.getIdProduto()+"<br />";
			
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
