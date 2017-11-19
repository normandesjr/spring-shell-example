package com.hibicode.springshell.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Filmes {

	private Integer count;
	private String next;
	private String previous;
	private List<Filme> results;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public List<Filme> getResults() {
		return results;
	}

	public void setResults(List<Filme> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return results.toString();
	}

	public static class Filme {

		@JsonProperty("title")
		private String titulo;

		@JsonProperty("episode_id")
		private Integer episodio;

		@JsonProperty("director")
		private String diretor;

		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public Integer getEpisodio() {
			return episodio;
		}

		public void setEpisodio(Integer episodio) {
			this.episodio = episodio;
		}

		public String getDiretor() {
			return diretor;
		}

		public void setDiretor(String diretor) {
			this.diretor = diretor;
		}

		@Override
		public String toString() {
			return "Filme [titulo=" + titulo + ", episodio=" + episodio + ", diretor=" + diretor + "]\n";
		}

	}

}
