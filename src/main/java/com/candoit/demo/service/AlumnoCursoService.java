package com.candoit.demo.service;

import com.candoit.demo.commons.TransactionResult;
import com.candoit.demo.dao.AlumnoCursoDao;
import com.candoit.demo.exception.DBException;
import com.candoit.demo.model.Alumno;
import com.candoit.demo.model.AlumnoCurso;
import com.candoit.demo.model.Curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoCursoService {

    @Autowired
    AlumnoService alumnoService;

    @Autowired
    CursoService cursoService;

    @Autowired
    AlumnoCursoDao alumnoCursoDaoImpl;

    public TransactionResult asociarAlumnoCurso(Long idAlumno, Long idCurso) throws DBException {
        Alumno alumno = alumnoService.getAlumnoById(idAlumno);
        Curso curso = cursoService.getCursoById(idCurso);

        AlumnoCurso alumnoCurso = new AlumnoCurso(alumno,curso);
        try {
            alumnoCursoDaoImpl.save(alumnoCurso);
        } catch (Exception e) {
            throw new DBException();
        }
        return new TransactionResult(String.format("Alumno de nombre %s fue asociado a Curso %s exitosamente", alumno.getNombre(),curso.getNombre()),Boolean.TRUE);
    }
    
}
