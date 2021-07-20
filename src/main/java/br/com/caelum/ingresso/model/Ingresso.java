package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

import br.com.caelum.ingresso.model.descontos.Desconto;

public class Ingresso {
	private Sessao sessao;
	private BigDecimal preco = BigDecimal.ZERO;
	
	public Ingresso(Sessao sessao, Desconto tipoDeDesconto) {
		this.setSessao(sessao);
		this.preco = tipoDeDesconto.aplicarDescontoSobre(sessao.getPreco());
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	public Sessao getSessao() {
		return sessao;
	}
	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}
	
	
}
