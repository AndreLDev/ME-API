package org.digitalse.Curso.control;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.digitalse.Curso.Form.AtualizaCursoForm;
import org.digitalse.Curso.Form.CursoForm;
import org.digitalse.Curso.dto.CursoDto;
import org.digitalse.Curso.entity.Curso;
import org.digitalse.Curso.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/curso")
public class CursoController {
	@Autowired
	private CursoRepository CursoRepository;
	// Read - Ler
	@GetMapping
	public List<CursoDto> listar(){
		List<Curso> Cursos = CursoRepository.findAll();
		return CursoDto.converter(Cursos);
				
	}
	// Create -- Cadastrar
	@PostMapping
	@Transactional
	public void salvar(@RequestBody CursoForm produtoForm) {
		Curso Curso = produtoForm.converter();
		CursoRepository.save(Curso);
		
		
	}
	// Delete -- Remover/apagar
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<CursoDto> apagar(@PathVariable int id){
		CursoRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	//Update -- Atualizar
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<CursoDto> atualizar(@PathVariable int id, @RequestBody AtualizaCursoForm apf){
		Optional<Curso> optional = CursoRepository.findById(id);
		if(optional.isPresent()) {
			Curso curso = apf.atualizar(id, CursoRepository);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
		
	}
	
}
