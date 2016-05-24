#language: pt

Funcionalidade: Relizar compra de Produto

 Cenario: Comprar Produto
	Dado que acesse o site
	Quando pesquiso o produto 'TV'
	E seleciono o produto
	E adiciono no carrinho
	Então eu finalizo a compra
	E realizo o login
