package org.digitalse.Curso.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Curso {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String descricao;
	private String emanta;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataCadastro;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataInicio;
	private float valor;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEmanta() {
		return emanta;
	}

	public void setEmanta(String emanta) {
		this.emanta = emanta;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Curso(String nome, String descricao, String emanta, Date dataCadastro, Date dataInicio, float valor) {
		this.setNome(nome);
		this.setDescricao(descricao);
		this.setEmanta(emanta);
		this.setDataCadastro(dataCadastro);
		this.setDataInicio(dataInicio);
		this.setValor(valor);
		
	
	}
	
	public Curso() {

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", ementa=" + emanta + ", dataCadastro=" + dataCadastro 
				+ ", dataInicio=" + dataInicio + ", valor =" + valor + "]";
	}
	
	
	

}
