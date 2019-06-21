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

	public AlunoDto(Aluno a) {
		id = a.getId();
		nome = a.getNome();
		n1 = a.getN1();
		n2 = a.getN2();
		n3 = a.getN3();
	}

	public AlunoDto() {

	}

	public AlunoDto(Integer id, String nome, int n1, int n2, int n3) {
		this.id = id;
		this.nome = nome;
		this.n1 = n1;
		this.n2 = n2;
		this.n3 = n3;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + n1;
		result = prime * result + n2;
		result = prime * result + n3;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlunoDto other = (AlunoDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (n1 != other.n1)
			return false;
		if (n2 != other.n2)
			return false;
		if (n3 != other.n3)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
