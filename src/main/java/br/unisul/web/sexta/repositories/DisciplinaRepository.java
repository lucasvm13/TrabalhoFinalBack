package br.unisul.web.sexta.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.unisul.web.sexta.domain.Disciplina;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer> {

	@Query("SELECT disciplina FROM Disciplina disciplina WHERE disciplina.nome LIKE %:nome%")
	List<Disciplina> findLikeNome(String nome);
	
	
	
	
}
