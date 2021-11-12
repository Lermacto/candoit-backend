package com.candoit.demo.dao;

import java.util.List;

import com.candoit.demo.model.Alumno;
import com.candoit.demo.model.AlumnoCurso;
import com.candoit.demo.model.Curso;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoCursoDao extends JpaRepository<AlumnoCurso,Long>{

    AlumnoCurso findByAlumnoAndCurso(Alumno alumno, Curso curso);

    List<AlumnoCurso> findByAlumno(Alumno alumno);
    
}
