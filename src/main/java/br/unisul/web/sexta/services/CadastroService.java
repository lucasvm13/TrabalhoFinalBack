package br.unisul.web.sexta.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.unisul.web.sexta.domain.Cadastro;
import br.unisul.web.sexta.repositories.CadastroRepository;

@Service
public class CadastroService {

		@Autowired
		private CadastroRepository rep;

		// BUSCA POR ID
		public Cadastro find(Integer id) {
			Optional<Cadastro> obj = rep.findById(id);
			return obj.orElse(null);
		}

		// FAZ INSERÇÃO
		public Cadastro insert(Cadastro obj) {
			obj.setId(null);
			return rep.save(obj);
		}

		// ATUALIZAR
		public Cadastro update(Cadastro obj) {
			find(obj.getId());
			return rep.save(obj);
		}

		// DELETAR
		public void delete(Integer id) {
			find(id);
			rep.deleteById(id);
		}

		// LISTAR TODAS
		public List<Cadastro> findAll() {
			return rep.findAll();
		}
}
