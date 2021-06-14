package org.digitalse.Curso.repository;
import org.digitalse.Curso.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Integer>{	
	
}
