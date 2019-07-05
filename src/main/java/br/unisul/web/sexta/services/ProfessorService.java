package br.unisul.web.sexta.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.unisul.web.sexta.domain.Professor;
import br.unisul.web.sexta.repositories.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository rep;

	// BUSCA POR ID
	public Professor find(Integer id) {
		Optional<Professor> obj = rep.findById(id);
		return obj.orElse(null);
	}

	// FAZ INSERÇÃO
	public Professor insert(Professor obj) {
		obj.setId(null);
		return rep.save(obj);
	}

	// ATUALIZAR
	public Professor update(Professor obj) {
		find(obj.getId());
		return rep.save(obj);
	}

	// DELETAR
	public void delete(Integer id) {
		find(id);
		rep.deleteById(id);
	}

	// LISTAR TODAS
	public List<Professor> findAll() {
		return rep.findAll();
	}
	
	// BUSCA POR NOME
	public List<Professor> findByName(String nome) {
		List<Professor> list = rep.findLikeNome(nome);
		return list;
	}
}
