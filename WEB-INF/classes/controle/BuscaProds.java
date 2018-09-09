package controle;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ProdutoDao;
import pojo.Produto;

/**
 * Servlet implementation class BuscaProds
 */
@WebServlet("/BuscaProds")
public class BuscaProds extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscaProds() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String busca = request.getParameter("txtBusca");
		
		ArrayList<Produto> produtos;
		
		ProdutoDao pd = new ProdutoDao();
		
		produtos = pd.buscarProduto(busca);
		
		if(produtos != null){
		
			Produto p;
			
			String HTML = "";
			String DIV = "";
	
			for (int i = 1; i <= produtos.size() ; i++) {
				
				p = produtos.get(i-1);
				
				/* Trocando a ponto por vírgula*/                
	            String preco = Float.toString(p.getPreco());
	                    
	            String precoVir = "";
	
	            int tam = preco.length();
	            
	            for (int j = 0; j < tam; j++) {
	                char caracter = preco.charAt(j);
	                if (caracter != ',') {
	                    if (caracter == '.') {
	                        caracter = ',';
	                    }
	                    precoVir += caracter;
	                }
	            }
	            
	            if (precoVir.equals("")) {
	                precoVir += "0";
	            }
	            
	            if(precoVir.length() < 5){
	            	
	            	while(precoVir.length() < 5) {
	            		
	            		precoVir += "0";
	            	}
	            }
	            /*-----------------------------*/
				
				DIV = "<div id='prod' class='col-lg-6 col-md-6 col-sm-12'>";
				
						DIV += "<div class='thumbnail'>"
								
								+ "<img class='classFoto' src='img/"+p.getFoto()+"'/>"
								
								+ "<div class='caption'>"
								
									+ "<h4 class='pull-right'>R$"+precoVir+"</h4>"
									
									+ "<h4>"+p.getNome()+"</h4>"
									
									+ "<p>" +p.getDescProd()+ "</p>"
									
								+ "</div>"
								
								+ "<div class='ratings'>"
								
									+ "<button class='retirarCar' onClick='retiraCarrinho("+p.getIdProduto()+")'>"
										+ "<img  src='img/carrinhoVermelho.png' alt='Retirar do Carrinho' width='50px' />"
									+ "</button>"
										
									+ "<button class='cart' onClick='adicionaCarrinho("+p.getIdProduto()+")'>"
											+ "<img  src='img/carrinho.png' alt='Adicionar ao Carrinho' width='50px' />"
									+ "</button>"
											
								+ "</div>"
								
							+ "</div>"
							
					+ "</div>";
					
				
				HTML += DIV;
			}
			
			HTML += "<button id='divAdicionado' onClick='efetuarCompra()' onMouseOver='listarCarrinho(1);mostrarDiv()' onMouseOut='esconderDiv()'>"
					+ "</button>"
					+ "<div id='divListaCarrinho' style='display:none'>"
					+ "</div>";
			
			response.getWriter().append(HTML);
		
		}else{
			
			String HTML = "<h1 style='text-align:center'>Nenhum produto encontrado</h1>";
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
