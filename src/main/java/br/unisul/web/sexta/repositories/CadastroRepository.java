package br.unisul.web.sexta.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.unisul.web.sexta.domain.Cadastro;


@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Integer> {

}