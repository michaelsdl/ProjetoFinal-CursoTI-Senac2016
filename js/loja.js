/*
 * Autor: Michael Silva de Lima
 */

/*Lista as categorias no menu da página*/
function listaCategs() {

	$.ajax({
		url : "ListaCategs",
		success : function(result) {

			$("#categorias").html(result);

		}
	});

}

/* Lista os produtos das categorias no conteúdo da página */
function listaProds(cat) {

	$.ajax({
		url : "ListaProds?idcategoria=" + cat,
		success : function(result) {

			$("#conteudo").html(result);

		}
	});

}

/* Adiciona produtos ao carrinho de compras */
function adicionaCarrinho(idProd) {

	$.ajax({
		url : "Adicionar?idprod=" + idProd,
		success : function(result) {

			if (result == "deslogado") {

				alert("É necessário fazer o login");

			} else {

				$("#divAdicionado").html(
						"Efetuar Compra <img  src='img/carrinho.png' alt='Carrinho: ' width='50px' /> "
								+ result);
			}

		}
	});

}

/* Retira produtos do carrinho de compras */
function retiraCarrinho(idProd) {

	$.ajax({
		url : "Retirar?idprod=" + idProd,
		success : function(result) {

			if (result == "deslogado") {

				alert("É necessário fazer o login");

			} else {

				$("#divAdicionado").html(
						"Efetuar Compra <img  src='img/carrinho.png' alt='Carrinho: ' width='50px' /> "
								+ result);
			}

		}
	});

}

/* Lista todos os produtos adicionados ao carrinho de compras */
function listarCarrinho(idUsuario) {

	$.ajax({
		url : "ListarCarrinho?idUsuario=" + idUsuario,
		success : function(result) {

			$("#divListaCarrinho").html(
					"<h4>Lista de produtos adicionados:</h4> <br />" + result);

		}
	});

}

/* Esconde a lista de produtos */
function esconderDiv() {

	$("#divListaCarrinho").css('display', 'none');

}

/* Mostra a lista de produtos */
function mostrarDiv() {

	$("#divListaCarrinho").css('display', 'block');
}

/* Encerra sessão do usuário logado */
function logout() {

	$.ajax({
		url : "Logout",
		success : function(result) {

			$("#divLogado").html("Sessão encerrada!");

			location.reload();

		}
	});
}

/* Encerra a conta do usuário se estiver logado */
function encerrarConta() {

	resposta = confirm("Deseja encerrar sua conta?");

	if (resposta) {

		$.ajax({
			url : "EncerrarConta",
			success : function(result) {

				alert(result);
				logout();

			}
		});
	}
}

/* Efetua a compra dos produtos adicionados pelo usuário */
function efetuarCompra() {

	resposta = confirm("Deseja efetuar a compra dos produtos adicionados ao carrinho?");

	if (resposta) {

		$.ajax({
			url : "EfetuarCompra",
			success : function(result) {

				alert(result);

			}
		});
	}
}

/* Faz uma busca de acordo com o que foi digitado pelo usuário */
function buscaProds(busca) {

	if (busca == null) {
		busca = document.getElementById("txtBusca").value;

	}

	$.ajax({
		url : "BuscaProds?txtBusca=" + busca,
		success : function(result) {

			$("#conteudo").html(result);

		}
	});

}

/* Consulta os dados do usuário */
function consultarDados() {

	$.ajax({
		url : "ConsultarDados",
		success : function(result) {
			

		}
	});
}
