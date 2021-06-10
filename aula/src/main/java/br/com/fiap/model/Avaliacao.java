package br.com.fiap.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Avaliacao {
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cd_avaliacao")
	private Long id;
	
	private String nome;
	
	private String descricao;
	
	private BigDecimal nota;

	//muitos para um
	@ManyToOne
	@JoinColumn(name="cd_hotel", nullable= false)
	private Hotel hotel;
	
	public Avaliacao() {
		hotel = new Hotel();
	}
	
	@Override
	public String toString() {
		return "Avaliacao [nome=" + nome + ", descricao=" + descricao + ", nota=" + nota + " + hotel=" + hotel +"]";
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public BigDecimal getNota() {
		return nota;
	}


	public void setNota(BigDecimal nota) {
		this.nota = nota;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Hotel getHotel() {
		return hotel;
	}


	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}







	

	
	
	
}
