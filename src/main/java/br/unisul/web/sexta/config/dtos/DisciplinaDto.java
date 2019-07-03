package br.unisul.web.sexta.config.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.unisul.web.sexta.domain.Aluno;
import br.unisul.web.sexta.domain.Disciplina;

public class DisciplinaDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private List<Aluno> alunos = new ArrayList<>();

	public DisciplinaDto(Disciplina d) {
		id = d.getId();
		nome = d.getNome();
		alunos = d.getAlunos();
	}

	public DisciplinaDto() {

	}

	public DisciplinaDto(Integer id, String nome, List<Aluno> Aluno) {
		this.id = id;
		this.nome = nome;
		this.alunos = Aluno;
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

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alunos == null) ? 0 : alunos.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		DisciplinaDto other = (DisciplinaDto) obj;
		if (alunos == null) {
			if (other.alunos != null)
				return false;
		} else if (!alunos.equals(other.alunos))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}