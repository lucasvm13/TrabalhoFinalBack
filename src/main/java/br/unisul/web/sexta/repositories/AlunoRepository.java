package br.unisul.web.sexta.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.unisul.web.sexta.domain.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

	@Query("SELECT aluno FROM Aluno aluno WHERE aluno.nome LIKE %:nome%")
	List<Aluno> findLikeNome(String nome);


	
}
