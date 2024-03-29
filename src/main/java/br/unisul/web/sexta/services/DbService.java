package br.unisul.web.sexta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.unisul.web.sexta.domain.Aluno;
import br.unisul.web.sexta.domain.Cadastro;
import br.unisul.web.sexta.domain.Disciplina;
import br.unisul.web.sexta.domain.Professor;
import br.unisul.web.sexta.repositories.AlunoRepository;
import br.unisul.web.sexta.repositories.CadastroRepository;
import br.unisul.web.sexta.repositories.DisciplinaRepository;
import br.unisul.web.sexta.repositories.ProfessorRepository;
import java.text.ParseException;
import java.util.Arrays;



@Service
public class DbService {

	@Autowired
	private AlunoRepository ARep;

	@Autowired
	private DisciplinaRepository DRep;

	@Autowired
	private ProfessorRepository PRep;
	
	@Autowired
	private CadastroRepository CRep;

	public void inicializaBancoDeDados() throws ParseException {
		

				
		Aluno a1 = new Aluno(null, "Lucas", 10, 9, 8, " ");
		
		Aluno a2 = new Aluno(null, "Pedro", 10, 3, 5, " ");
		
		Aluno a3 = new Aluno(null, "José", 10, 8, 5, " ");
		
		Disciplina d1 = new Disciplina(null, "POO");

		Disciplina d2 = new Disciplina(null, "INTEGRAIS");
		

		Professor p1 = new Professor(null, "João", 25, "M", d1);

		Professor p2 = new Professor(null, "Pedro", 30, "M", d2);
		
		
		Cadastro c1 = new Cadastro(null, a1, d1, p1);
		
		Cadastro c2 = new Cadastro(null, a2, d2, p2);
		
				
		a1.getDisciplinas().addAll(Arrays.asList(d1, d2));
		a2.getDisciplinas().add(d1);
		a3.getDisciplinas().addAll(Arrays.asList(d1, d2));
		
		d1.getAlunos().addAll(Arrays.asList(a1, a3));
		d2.getAlunos().addAll(Arrays.asList(a1, a2, a3));
		
	
		DRep.saveAll(Arrays.asList(d1, d2));
		ARep.saveAll(Arrays.asList(a1, a2, a3));
		PRep.saveAll(Arrays.asList(p1, p2));
		CRep.saveAll(Arrays.asList(c1, c2));
	}
}
