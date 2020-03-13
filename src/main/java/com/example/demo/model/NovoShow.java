package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;


@Entity
public class NovoShow {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotNull
	@Size(min = 5 ,message = "O NOME DO EVENTO deve ter no mínimo 5 caracteres.")
	@Size(max =  20, message = "o NOME DO EVENTO deve contar no máximo 20 caracteres")
	private String nomeEvento;
	
	@NotNull
	@Min(value = 50 , message = "No minimo 50 ingressos disponiveis.")
	private int capacidadeEvento;
	
	@NotNull
	@DecimalMin(value = "0.01", message ="Valor minimo R$ 0,01.")
	@DecimalMax(value = "999999999.99", message ="Valor máximo é de R$ 999.999.999,99")
	@NumberFormat(pattern = "#,##0.00")
	private Double valorEvento;
	
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataEvento;
	
	@NotNull
	private StatusSelecionarGenero selecionarGenero;
	
	
	@ManyToOne
	private CasaShow selecinarCasas;

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public int getCapacidadeEvento() {
		return capacidadeEvento;
	}

	public void setCapacidadeEvento(int capacidadeEvento) {
		this.capacidadeEvento = capacidadeEvento;
	}

	public Double getValorEvento() {
		return valorEvento;
	}

	public void setValorEvento(Double valorEvento) {
		this.valorEvento = valorEvento;
	}

	public Date getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}




	public CasaShow getSelecinarCasas() {
		return selecinarCasas;
	}

	public void setSelecinarCasas(CasaShow selecinarCasas) {
		this.selecinarCasas = selecinarCasas;
	}

	public StatusSelecionarGenero getSelecionarGenero() {
		return selecionarGenero;
	}

	public void setSelecionarGenero(StatusSelecionarGenero selecionarGenero) {
		this.selecionarGenero = selecionarGenero;
	}


	
}
