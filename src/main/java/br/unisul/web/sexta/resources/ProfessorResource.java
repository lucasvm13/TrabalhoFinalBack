package br.unisul.web.sexta.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.unisul.web.sexta.config.dtos.ProfessorDto;
import br.unisul.web.sexta.domain.Professor;
import br.unisul.web.sexta.resources.utils.URL;
import br.unisul.web.sexta.services.ProfessorService;

@RestController
@RequestMapping(value = "/professores")
public class ProfessorResource {

	@Autowired
	private ProfessorService service;

	// BUSCAR POR ID
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Professor> find(@PathVariable Integer id) {
		Professor obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Professor obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Professor obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	// EXCLUIR
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	// LISTAR TODAS
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProfessorDto>> findAll() {
		List<Professor> lista = service.findAll();

		List<ProfessorDto> listDto = new ArrayList<ProfessorDto>();

		for (Professor p : lista) {
			listDto.add(new ProfessorDto(p));
		}

		return ResponseEntity.ok().body(listDto);
	}

	// BUSCAR POR NOME
	@RequestMapping(value = "/buscaProfessor", method = RequestMethod.GET)
	public ResponseEntity<List<Professor>> find(@RequestParam(value = "nome", defaultValue = "") String nome) {
		List<Professor> list = service.findByName(URL.decodeParam(nome));
		return ResponseEntity.ok().body(list);
	}
}
