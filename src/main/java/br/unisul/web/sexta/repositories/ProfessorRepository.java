package br.unisul.web.sexta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unisul.web.sexta.domain.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
	
}
