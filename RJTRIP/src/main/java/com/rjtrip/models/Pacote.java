package com.rjtrip.models;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pacote")
public class Pacote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 80, unique = true)
	private String nome;
	
	@Column(nullable = false, length = 80)
	private String duracao;
	
	@Column(nullable = false, length = 80)
	private float preco;
	
	@JsonIgnore
	@OneToMany(mappedBy = "pacote", orphanRemoval=true)
	@Cascade(value= {CascadeType.ALL})
	private List<Pedido> pedidos = new ArrayList<>();
	
	public Pacote() {
		
	}

	public Pacote(Long id, String nome, String duracao, float preco, List<Pedido> pedidos) {
		super();
		this.id = id;
		this.nome = nome;
		this.duracao = duracao;
		this.preco = preco;
		this.pedidos = pedidos;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
}
