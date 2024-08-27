package br.com.alura.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.lance.LancesPage;

class LoginTest {

	private LoginPage paginaDeLogin;

	@BeforeEach
	void beforeEach() {
		this.paginaDeLogin = new LoginPage();
	}

	@AfterEach
	void afterEach() {
		this.paginaDeLogin.fechar();
	}

	@Test
	void deveriaEfetuarLoginComDadosValidos() {
		paginaDeLogin.efetuarLogin("fulano", "pass");

		String nomeUsuarioLogado = paginaDeLogin.getNomeUsuarioLogado();
		Assert.assertEquals("fulano", nomeUsuarioLogado);
		Assert.assertFalse(paginaDeLogin.isPaginaAtual());
	}

	@Test
	void naoDeveriaEfetuarLoginComDadosInvalidos() {
		paginaDeLogin.efetuarLogin("invalido", "1233");

		Assert.assertNull(paginaDeLogin.getNomeUsuarioLogado());
		Assert.assertTrue(paginaDeLogin.isPaginaAtual());
		Assert.assertTrue(paginaDeLogin.isMensagemDeLoginInvalidoVisivel());
	}

	@Test
	void naoDeveriaAcessarUrlRestritaSemEstarLogado() {
		LancesPage paginaDeLances = new LancesPage();

		Assert.assertFalse(paginaDeLances.isPaginaAtual());
		Assert.assertFalse(paginaDeLances.isTituloLeilaoVisivel());

		paginaDeLances.fechar();
	}

}
