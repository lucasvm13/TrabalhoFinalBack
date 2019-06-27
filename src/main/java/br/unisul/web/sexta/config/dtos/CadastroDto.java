package br.unisul.web.sexta.config.dtos;

import java.io.Serializable;
import br.unisul.web.sexta.domain.Aluno;
import br.unisul.web.sexta.domain.Cadastro;
import br.unisul.web.sexta.domain.Disciplina;
import br.unisul.web.sexta.domain.Professor;

public class CadastroDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Aluno aluno;
	private Disciplina disciplina;
	private Professor professor;

	public CadastroDto(Cadastro c) {
		id = c.getId();
		aluno = c.getAluno();
		disciplina = c.getDisciplina();
		professor = c.getProfessor();
	}

	public CadastroDto() {

	}
	
	public CadastroDto(Integer id, Aluno aluno, Disciplina disciplina, Professor professor) {
		this.id = id;
		this.aluno = aluno;
		this.disciplina = disciplina;
		this.professor = professor;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
		result = prime * result + ((disciplina == null) ? 0 : disciplina.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((professor == null) ? 0 : professor.hashCode());
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
		CadastroDto other = (CadastroDto) obj;
		if (aluno == null) {
			if (other.aluno != null)
				return false;
		} else if (!aluno.equals(other.aluno))
			return false;
		if (disciplina == null) {
			if (other.disciplina != null)
				return false;
		} else if (!disciplina.equals(other.disciplina))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (professor == null) {
			if (other.professor != null)
				return false;
		} else if (!professor.equals(other.professor))
			return false;
		return true;
	}

}