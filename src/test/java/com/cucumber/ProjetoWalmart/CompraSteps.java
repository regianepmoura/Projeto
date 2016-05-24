package com.cucumber.ProjetoWalmart;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import src.main.java.classes.Login;
import src.main.java.classes.PaginaFinalizarCompra;
import src.main.java.classes.PaginaInicial;
import src.main.java.classes.PaginaProduto;

public class CompraSteps {
	private PaginaInicial paginaInicial;
	private PaginaProduto paginaProduto;
	private PaginaFinalizarCompra paginaFinalizarCompra;
	private Login login;

	@Before
	public void setup() {
		WebDriver driver = new FirefoxDriver();
		this.paginaInicial = new PaginaInicial(driver);
		this.paginaProduto = new PaginaProduto(driver);
		this.paginaFinalizarCompra = new PaginaFinalizarCompra(driver);
		this.login = new Login(driver);

	}

	@Dado("^que acesse o site$")
	public void que_acesse_o_site() {
		paginaInicial.abre();
	}

	@Quando("^pesquiso o produto 'TV'$")
	public void pesquiso_o_produto_TV() {
		paginaInicial.pesquisaProduto();
	}

	@Quando("^seleciono o produto$")
	public void seleciono_o_produto() {
		paginaInicial.selecionaProduto();

	}

	@Quando("^adiciono no carrinho$")
	public void adiciono_no_carrinho() {
		paginaProduto.adicionarCarrinho();

	}

	@Então("^eu finalizo a compra$")
	public void eu_finalizo_a_compra() {
		paginaFinalizarCompra.finalizarCompra();

	}

	@Então("^realizo o login$")
	public void realizo_o_login() {
		login.realizarLogin();
	}

}
