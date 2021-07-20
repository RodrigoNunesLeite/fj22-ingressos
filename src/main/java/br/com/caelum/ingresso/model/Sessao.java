package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Sessao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	// muitas sessoes para 1 filmes
	@ManyToOne
	private Filme filme;
	
	// muitas sessoes para 1 sala
	@ManyToOne
	private Sala sala;
	
	private LocalTime horario;
	
	private BigDecimal preco = BigDecimal.ZERO;
	

	/**
	*	@deprecated	hibernate	only
	*/
	public	Sessao() {
	}

	
	public Sessao(Filme filme, Sala sala, LocalTime horario) {
		super();
		this.filme = filme;
		this.sala = sala;
		this.horario = horario;
		this.preco = sala.getPreco().add(filme.getPreco());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}
	
	
	public BigDecimal getPreco() {
		return preco.setScale(2, RoundingMode.HALF_UP);
	}


	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
}
