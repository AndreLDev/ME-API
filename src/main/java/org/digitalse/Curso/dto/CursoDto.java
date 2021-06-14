package org.digitalse.Curso.dto;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.digitalse.Curso.entity.Curso;
import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CursoDto {
	private int id;
	private String nome;
	private String descricao;
	private String emanta;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataCadastro;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataInicio;
	private float valor;
	
	public CursoDto(Curso produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.emanta = produto.getEmanta();
		this.dataCadastro = produto.getDataCadastro();
		this.dataInicio = produto.getDataInicio();
		this.valor = produto.getValor();
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setEmanta(String emanta) {
		this.emanta = emanta;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public String getEmanta() {
		return emanta;
	}
	
	public Date getDataCadastro() {
		return dataCadastro;
	}
	
	public Date getDataInicio() {
		return dataInicio;
	}
	
	public float getValor() {
		return valor;
	}
	
	
	public static List<CursoDto> converter(List<Curso> produtos){
		return produtos.stream().map(CursoDto::new).collect(Collectors.toList());
		//return produtos.map(ProdutoDto::new);
	}


}
