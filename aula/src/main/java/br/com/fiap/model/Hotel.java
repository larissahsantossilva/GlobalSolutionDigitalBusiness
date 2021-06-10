package br.com.fiap.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Hotel {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cd_hotel")
	private Long id;
	
	private String nome;
	
	private String endereco;
	
	private BigDecimal valor;
	
	private String descricao;
	
	private String imagem;
	

	@OneToMany(mappedBy="hotel") //colocar o cascadeTyoe.persiste ?? 
	private List<Avaliacao> avaliacoes;
		

	@Override
	public String toString() {
		return "Hotel [nome=" + nome + ", endereco=" + endereco + ", valor=" + valor + ", descricao=" + descricao
				+ ", imagem=" + imagem + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}



	
}
