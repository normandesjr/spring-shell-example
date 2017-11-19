package com.hibicode.springshell.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Personagens {

	private Integer count;
	private String next;
	private String previous;
	private List<Personagem> results;

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

	public List<Personagem> getResults() {
		return results;
	}

	public void setResults(List<Personagem> results) {
		this.results = results;
	}
	
	@Override
	public String toString() {
		return results.toString();
	}

	public static class Personagem {

		@JsonProperty("name")
		private String nome;

		@JsonProperty("gender")
		private String sexo;

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getSexo() {
			return sexo;
		}

		public void setSexo(String sexo) {
			this.sexo = sexo;
		}

		@Override
		public String toString() {
			return "Personagem [nome=" + nome + ", sexo=" + sexo + "]\n";
		}
	}

}
