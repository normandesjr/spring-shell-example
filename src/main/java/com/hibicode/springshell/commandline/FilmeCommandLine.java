package com.hibicode.springshell.commandline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.hibicode.springshell.model.Filmes;

@ShellComponent
@ShellCommandGroup("Filmes")
public class FilmeCommandLine {

	private static final String BASE_URL = "https://swapi.co/api/films/";

	@Autowired
	private RestTemplate restClient;

	@ShellMethod("Listar filmes")
	public String filmes() {
		try {
			return buscarFilmes();
		} catch (HttpClientErrorException e) {
			return tratarErro(e);
		}
	}

	@ShellMethod("Pesquisar filme por título")
	public String pesquisarFilmePorTitulo(
			@ShellOption(help = "título do filme que deseja pesquisar") String titulo) {
		final String url = BASE_URL + "?search={titulo}";
		return restClient.getForObject(url, Filmes.class, titulo).toString();
	}

	private String buscarFilmes() {
		final String url = BASE_URL;
		return restClient.getForObject(url, Filmes.class).toString();
	}

	private String tratarErro(HttpClientErrorException e) {
		if (e.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
			return "Não encontrado";
		}

		return "Erro desconhecido";
	}
	
}
