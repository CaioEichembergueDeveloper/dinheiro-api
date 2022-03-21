package com.caio.dinheiro.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Despesa implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private Date primeiroPagamento;
	private Double precoTotal;
	private Integer qtdeParcelas;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	

	public Despesa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Despesa(Integer id, String descricao, Date primeiroPagamento, Double precoTotal, Integer qtdeParcelas, Categoria categoria) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.primeiroPagamento = primeiroPagamento;
		this.precoTotal = precoTotal;
		this.qtdeParcelas = qtdeParcelas;
		this.categoria = categoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getPrimeiroPagamento() {
		return primeiroPagamento;
	}

	public void setPrimeiroPagamento(Date primeiroPagamento) {
		this.primeiroPagamento = primeiroPagamento;
	}

	public Double getPrecoUnico() {
		return precoTotal;
	}

	public void setPrecoUnico(Double precoUnico) {
		this.precoTotal = precoUnico;
	}

	public Integer getQtdeParcelas() {
		return qtdeParcelas;
	}

	public void setQtdeParcelas(Integer qtdeParcelas) {
		this.qtdeParcelas = qtdeParcelas;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Despesa other = (Despesa) obj;
		return Objects.equals(id, other.id);
	}

}
