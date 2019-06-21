package br.unisul.web.sexta.config.dtos;

import java.io.Serializable;
import br.unisul.web.sexta.domain.Disciplina;

public class DisciplinaDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;

	public DisciplinaDto() {

	}

	public DisciplinaDto(Disciplina obj) {
		id = obj.getId();
		nome = obj.getNome();

	}

}