package com.cucumber.ProjetoWalmart;

import java.io.IOException;

import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import src.main.java.classes.Posts;

public class PostsSteps {
	private Posts posts;
	private boolean retorno = false;
	int ID = 1;

	@Before
	public void setup() {
		this.posts = new Posts();
	}

	@Dado("^que busque os posts$")
	public void que_busque_os_posts() throws IOException {
		posts.ListarTodos();

	}

	@Dado("^que eu informe o ID um post$")
	public void que_eu_informe_o_ID_um_post() {
		ID = 1;

	}

	@Dado("^o post seja existente$")
	public void o_post_seja_existente() throws Exception {
		retorno = false;
		if (posts.ValidaPosts(ID)) {
			retorno = true;
		}
	}

	@Então("^apresenta os detalhes do posts$")
	public void apresenta_os_detalhes_do_posts() throws IOException {
		if (retorno) {
			posts.DetalhesPost(ID);
		}
		retorno = false;
	}

	@Quando("^informado ID inexistente$")
	public void informado_ID_inexistente() throws Exception {
		if (!retorno) {
			throw new Exception("404. ID Inexistente");
		}

	}

	@Dado("^seleciona para cadastrar$")
	public void seleciona_para_cadastrar() throws IOException {
		String Titulo, Body, ID;
		Titulo = "Novo";
		Body = "Novo Post";
		ID = "1";
		posts.CriarNovoPost(Titulo, Body, ID);
	}

	@Dado("^deleta o post$")
	public void deleta_o_post() throws Exception {
		retorno = false;
		if (posts.ValidaPosts(ID)) {
			posts.DeletarPosts(ID);
		}
	}

}
