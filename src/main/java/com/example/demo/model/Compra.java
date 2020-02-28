package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;

@Entity
public class Compra {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long codigo;
	
		
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCompra = new Date();
	
	private String formaPagamento; 
	
	@NumberFormat(pattern = "#,##0.00")
	private Double valorTotal=0. ;
	
	@NotNull
	private String nomeComprador;
	
	@ManyToOne
	private ItensCompras itensComprado;
	
	private Integer quantidade =0;
	

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public ItensCompras getItensComprado() {
		return itensComprado;
	}

	public void setItensComprado(ItensCompras itensComprado) {
		this.itensComprado = itensComprado;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	
	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getNomeComprador() {
		return nomeComprador;
	}

	public void setNomeComprador(String nomeComprador) {
		this.nomeComprador = nomeComprador;
	}
	
	
	
}
