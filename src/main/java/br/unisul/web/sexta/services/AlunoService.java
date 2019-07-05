package br.unisul.web.sexta.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.unisul.web.sexta.domain.Aluno;
import br.unisul.web.sexta.repositories.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository rep;
	
	
	
	// BUSCA POR ID
	public Aluno find(Integer id) {
		Optional<Aluno> obj = rep.findById(id);
		return obj.orElse(null);
	}

	// FAZ INSERÇÃO
	public Aluno insert(Aluno obj) {
		obj.setId(null);
		return rep.save(obj);
	}

	// ATUALIZAR
	public Aluno update(Aluno obj) {
		find(obj.getId());
		atualizaStatus(obj);
		return rep.save(obj);
	}
	

	//MEDIA
	public void atualizaStatus(Aluno obj) {

		double media = 0;
		double n1 = obj.getN1();
		double n2 = obj.getN2();
		double n3 = obj.getN3();

		media = ((n1 + n2 + n3) / 3);

		if (media >= 7) {
			obj.setStatus("Aprovado");
		}
		if (media < 2) {
			obj.setStatus("Reprovado");
		}

		if ((media == 2) | (media < 7)) {
			obj.setStatus("Recuperação");
		}
	}

	// DELETAR
	public void delete(Integer id) {
		find(id);
		rep.deleteById(id);
	}

	// LISTAR TODAS
	public List<Aluno> findAll() {
		return rep.findAll();
	}
	
	// BUSCA POR NOME
	public List<Aluno> findByName(String nome) {
		List<Aluno> list = rep.findLikeNome(nome);
		return list;
	}

}
