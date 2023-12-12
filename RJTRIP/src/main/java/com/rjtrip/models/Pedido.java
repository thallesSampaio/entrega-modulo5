package com.rjtrip.models;

import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 80)
	private String duracao;
	
	@Column(nullable = false, length = 255)
	private String dataViagem;
	
	@Column(nullable = false, length = 255)
	private String destinos;
	
	@Column(name = "data_pedido")
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDateTime dataPedido;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "pacote_id")
	private Pacote pacote;
	
	public Pedido() {
		
	}
	
	public Pacote getPacote() {
		return pacote;
	}

	public void setPacote(Pacote pacote) {
		this.pacote = pacote;
	}

	public Pedido(Long id, String duracao, String dataViagem, String destinos, LocalDateTime dataPedido,
			Cliente cliente, Pacote pacote) {
		this.id = id;
		this.duracao = duracao;
		this.dataViagem = dataViagem;
		this.destinos = destinos;
		this.dataPedido = dataPedido;
		this.cliente = cliente;
		this.pacote = pacote;
	}

	public LocalDateTime getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public String getDataViagem() {
		return dataViagem;
	}

	public void setDataViagem(String dataViagem) {
		this.dataViagem = dataViagem;
	}

	public String getDestinos() {
		return destinos;
	}

	public void setDestinos(String destinos) {
		this.destinos = destinos;
	}
}
