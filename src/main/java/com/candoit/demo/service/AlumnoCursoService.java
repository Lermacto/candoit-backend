package com.candoit.demo.service;

import java.util.List;

import com.candoit.demo.commons.TransactionResult;
import com.candoit.demo.dao.AlumnoCursoDao;
import com.candoit.demo.dto.UpdateAlumnoCursoRequest;
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

    public TransactionResult bajaAlumnoCurso(Long idAlumno, Long idCurso) throws DBException {
        Alumno alumno = alumnoService.getAlumnoById(idAlumno);
        Curso curso = cursoService.getCursoById(idCurso);
        AlumnoCurso alumnoCurso = new AlumnoCurso(alumno, curso);
        try {
            alumnoCursoDaoImpl.delete(alumnoCurso);
        } catch (Exception e) {
            throw new DBException();
        }
        return new TransactionResult(String.format("Baja exitosa de Alumno %s de Curso %s", alumno.getNombre(),curso.getNombre()),Boolean.TRUE);
    }

    public TransactionResult updateAlumnoCurso(UpdateAlumnoCursoRequest updateAlumnoCursoRequest) throws DBException{
        Alumno alumno = alumnoService.getAlumnoById(updateAlumnoCursoRequest.getIdAlumno());
        Curso curso = cursoService.getCursoById(updateAlumnoCursoRequest.getCurrentIdCurso());
        AlumnoCurso alumnoCurso = alumnoCursoDaoImpl.findByAlumnoAndCurso(alumno,curso);
        Curso newCurso = cursoService.getCursoById(updateAlumnoCursoRequest.getNewIdCurso());
        alumnoCurso.setCurso(newCurso);
        try {
            alumnoCursoDaoImpl.save(alumnoCurso);
        } catch (Exception e) {
            throw new DBException();
        }
        return new TransactionResult(String.format("Update exitoso de Alumno %s en Curso %s a Curso %s", alumno.getNombre(),curso.getNombre(),newCurso.getNombre()),Boolean.TRUE);
    }

    public List<AlumnoCurso> getAllByAlumnoId(Long idAlumno) {
        Alumno alumno = alumnoService.getAlumnoById(idAlumno);
        List<AlumnoCurso> listAlumnoCurso = alumnoCursoDaoImpl.findByAlumno(alumno);
        return listAlumnoCurso;
    }
    
}
