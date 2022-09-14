package com.eventoapp.eventoapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity // é uma entidade, ou seja, vai ser uma tabela no banco de dados
public class Convidado {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // incrementa automaticamente o 'id'
	private long idConvidado;
	
	@NotEmpty
	private String rg;
	
	@NotEmpty
	private String nomeConvidado;
	
	@ManyToOne // muitos convidados para cada Evento. Vamos relacionar essa tabela com a tabela dos eventos
	private Evento evento;
	
	public long getIdConvidado() {
		return idConvidado;
	}
	public void setIdConvidado(long idConvidado) {
		this.idConvidado = idConvidado;
	}
	
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public String getNomeConvidado() {
		return nomeConvidado;
	}
	public void setNomeConvidado(String nomeConvidado) {
		this.nomeConvidado = nomeConvidado;
	}
	
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
}
