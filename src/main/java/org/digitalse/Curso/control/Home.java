package org.digitalse.Curso.control;



import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Home {
	@RequestMapping("/")
	@ResponseBody
	public String hello() {
		return "Cursos";
	}
	/*
	 * @GetMapping
	public ResponseEntity<FolhaDto> calcular(@RequestParam float salario){
		return ResponseEntity.ok(new FolhaDto(salario));
	}
	
	 */

}
