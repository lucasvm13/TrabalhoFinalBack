package br.unisul.web.sexta.config.dtos;

import java.io.Serializable;
import java.util.ArrayList;

import br.unisul.web.sexta.domain.Aluno;
import br.unisul.web.sexta.domain.Disciplina;

public class DisciplinaDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String professor;
	private ArrayList<Aluno> alunos = new ArrayList<>();

	public DisciplinaDto() {

	}

	public DisciplinaDto(Disciplina obj) {
		id = obj.getId();
		nome = obj.getNome();
		professor = obj.getProfessor();
		
		
	}

}