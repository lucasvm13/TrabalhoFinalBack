package br.unisul.web.sexta.config.dtos;

import java.io.Serializable;

import br.unisul.web.sexta.domain.Aluno;

public class AlunoDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private int n1;
	private int n2;
	private int n3;

	public AlunoDto() {

	}

	public AlunoDto(Aluno obj) {
		id = obj.getId();
		nome = obj.getNome();
		n1 = obj.getN1();
		n2 = obj.getN2();
		n3 = obj.getN3();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getN1() {
		return n1;
	}

	public void setN1(int n1) {
		this.n1 = n1;
	}

	public int getN2() {
		return n2;
	}

	public void setN2(int n2) {
		this.n2 = n2;
	}

	public int getN3() {
		return n3;
	}

	public void setN3(int n3) {
		this.n3 = n3;
	}

}
