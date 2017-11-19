package com.hibicode.springshell.commandline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.hibicode.springshell.model.Personagens;

@ShellComponent
@ShellCommandGroup("Personagens")
public class PersonagemCommandLine {

	private static final String BASE_URL = "https://swapi.co/api/people/";

	@Autowired
	private RestTemplate restClient;

	@ShellMethod("Listar personagens de 10 em 10")
	public String personagens(
			@ShellOption(help = "numero da página para mostrar personagem", defaultValue = "1") Integer pagina) {
		try {
			return buscarPersonagensNaPagina(pagina);
		} catch (HttpClientErrorException e) {
			return tratarErro(e);
		}
	}

	@ShellMethod("Pesquisar personagens por nome")
	public String pesquisarPersonagensPorNome(
			@ShellOption(help = "nome do personagem que deseja pesquisar") String nome) {
		final String url = BASE_URL + "?search={nome}";
		return restClient.getForObject(url, Personagens.class, nome).toString();
	}

	private String buscarPersonagensNaPagina(Integer pagina) {
		final String url = BASE_URL + "?page={pagina}";
		return restClient.getForObject(url, Personagens.class, pagina).toString();
	}

	private String tratarErro(HttpClientErrorException e) {
		if (e.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
			return "Não encontrado";
		}

		return "Erro desconhecido";
	}

}
