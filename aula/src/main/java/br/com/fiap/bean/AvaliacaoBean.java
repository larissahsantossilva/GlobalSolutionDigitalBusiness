package br.com.fiap.bean;


import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.fiap.dao.AvaliacaoDAO;
import br.com.fiap.dao.HotelDAO;
import br.com.fiap.model.Avaliacao;
import br.com.fiap.model.Hotel;

@Named
@RequestScoped 
public class AvaliacaoBean{

	private Avaliacao avaliacao = new Avaliacao();
	
	public void cadastrar() {
		new AvaliacaoDAO().create(this.avaliacao);
		System.out.println(this.avaliacao);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Avaliação concluida"));
	}

	
	public List<Avaliacao> getAvaliacoes(){
		return new AvaliacaoDAO().getAll();
	}

	
	public List<Hotel> getHoteis(){
		return new HotelDAO().getAll();
	}
	
	
	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	
}
