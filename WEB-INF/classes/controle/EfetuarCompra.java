package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.CarrinhoDao;
import modelo.ItemVendaDao;
import modelo.ProdutoDao;
import modelo.VendaDao;
import pojo.Carrinho;
import pojo.ItemVenda;
import pojo.Produto;
import pojo.Venda;

/**
 * Servlet implementation class EfetuarCompra
 */
@WebServlet("/EfetuarCompra")
public class EfetuarCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EfetuarCompra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		int idUsuario = (Integer)session.getAttribute("idUsuario");
		
		
		String dataAtual = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)+"/"
							+Calendar.getInstance().get(Calendar.MONTH)							
							+"/"+Calendar.getInstance().get(Calendar.YEAR);
		
		Venda v = new Venda();
		
		VendaDao vd = new VendaDao();
		
		v.setIdUsuario(idUsuario);
		v.setDataVenda(dataAtual);
		v.setIdVenda(0);
		
		if(!vd.cadastrarVenda(v)){
			
			response.getWriter().append("Erro ao cadastrar venda!");
			
		}else{
			
			CarrinhoDao cd = new CarrinhoDao();
			
			ProdutoDao pd = new ProdutoDao();
			
			ItemVendaDao ivd = new ItemVendaDao();
			
			ItemVenda iv = new ItemVenda();
			
			ArrayList<Carrinho> listaCar = cd.listar(idUsuario);
			
			for(int i = 0; i < listaCar.size(); i++) {
				
				Carrinho ca = listaCar.get(i);
				
				Produto p = pd.consultarProduto(ca.getIdProduto());
				
				Venda ve = vd.consultarVenda(idUsuario);
				
				iv.setIdProduto(p.getIdProduto());
				iv.setIdVenda(ve.getIdVenda());
				iv.setPreco(p.getPreco());
				iv.setQuantidade(ca.getQuantidade());
				
				ivd.cadastrarItem(iv);
				
				
			}
			
			
				
				response.getWriter().append("A entrega dos produtos será realizada em até 7 dias úteis. Por favor,"
						+ "imprima o comprovante da compra");
				
			
			
			
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
