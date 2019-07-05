package br.unisul.web.sexta.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.unisul.web.sexta.domain.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

	@Query("SELECT professor FROM Professor professor WHERE professor.nome LIKE %:nome%")
	List<Professor> findLikeNome(String nome);
}
