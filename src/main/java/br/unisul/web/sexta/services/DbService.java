package br.unisul.web.sexta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.unisul.web.sexta.domain.Aluno;
import br.unisul.web.sexta.domain.Disciplina;
import br.unisul.web.sexta.domain.Professor;
import br.unisul.web.sexta.repositories.AlunoRepository;
import br.unisul.web.sexta.repositories.DisciplinaRepository;
import br.unisul.web.sexta.repositories.ProfessorRepository;
import java.text.ParseException;
import java.util.Arrays;



@Service
public class DbService {
	
		@Autowired
		private AlunoRepository alRep;
		
		@Autowired
		private DisciplinaRepository disRep;
		
		@Autowired
		private ProfessorRepository prRep;
		
		
		public void inicializaBancoDeDados() throws ParseException {
			
			Aluno al1 = new Aluno(null, "Lucas", 8, 9, 8);
			Aluno al2 = new Aluno(null, "Fábio", 10, 10, 8);
			Aluno al3 = new Aluno(null, "Rafael", 10, 9, 5);
			
			
			Disciplina dis1 = new Disciplina(null, "POO");
			Disciplina dis2 = new Disciplina(null, "Algebra");
			Disciplina dis3= new Disciplina(null, "Grafos");
			
			Professor pr1 = new Professor(null, "João", 35, "M", dis1);
			Professor pr2 = new Professor(null, "Roberta", 38, "F", dis2);
			Professor pr3 = new Professor(null, "Jonas", 45, "M", dis3);
			
			
			al1.getDisciplinas().addAll(Arrays.asList(dis1));
			al2.getDisciplinas().addAll(Arrays.asList(dis2));
			al3.getDisciplinas().addAll(Arrays.asList(dis3));
		
			alRep.saveAll(Arrays.asList(al1, al2, al3));
			disRep.saveAll(Arrays.asList(dis1,dis2,dis3));
			prRep.saveAll(Arrays.asList(pr1,pr2,pr3));
				
		}
}
