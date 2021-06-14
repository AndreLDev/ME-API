package com.me.crm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.me.crm.Form.AttCursoForm;
import com.me.crm.Form.CursoForm;
import com.me.crm.dto.CursoDto;
import com.me.crm.entity.Curso;
import com.me.crm.repository.CursoRepository;

@RestController
@RequestMapping("/curso")
public class CursoController {
	
	@Autowired
	private CursoRepository CursoRepository;
	
	@GetMapping
	public List<CursoDto> listar(){
		List<Curso> Cursos = CursoRepository.findAll();
		return CursoDto.converter(Cursos);
				
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void salvar(@RequestBody CursoForm produtoForm) {
		Curso Curso = produtoForm.converter();
		CursoRepository.save(Curso);
		
		
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<CursoDto> apagar(@PathVariable int id){
		CursoRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}


	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.UPGRADE_REQUIRED)
	public ResponseEntity<CursoDto> atualizar(@PathVariable int id, @RequestBody AttCursoForm apf){
		Optional<Curso> optional = CursoRepository.findById(id);
		if(optional.isPresent()) {
			Curso curso = apf.atualizar(id, CursoRepository);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
		
	}
	
}
