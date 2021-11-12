package com.candoit.demo.service;

import javax.persistence.EntityNotFoundException;

import com.candoit.demo.commons.TransactionResult;
import com.candoit.demo.dao.CursoDao;
import com.candoit.demo.dto.UpdateCursoRequest;
import com.candoit.demo.exception.DBException;
import com.candoit.demo.model.Curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {
    
    @Autowired
    CursoDao cursoDaoImpl;

    public TransactionResult createCurso(Curso curso) throws DBException {
        try {
            cursoDaoImpl.save(curso);
        } catch (Exception e) {
            throw new DBException();
        }
        return new TransactionResult("Alta exitosa de curso",Boolean.TRUE);
    }

    public Curso getCursoById(Long idCurso) {
        return cursoDaoImpl.findById(idCurso).orElseThrow(() -> new EntityNotFoundException());
    }

    public TransactionResult updateCurso(UpdateCursoRequest updateCurso) {
        Curso curso = getCursoById(updateCurso.getIdCursoToUpdate());
        curso.setDescripcion(updateCurso.getDescripcionUpdate()!=null? updateCurso.getDescripcionUpdate(): curso.getDescripcion());
        curso.setNombre(updateCurso.getNombreUpdate()!=null? updateCurso.getNombreUpdate(): curso.getNombre());
        cursoDaoImpl.save(curso);
        return new TransactionResult("Update exitoso de Curso",Boolean.TRUE);
    }

    public TransactionResult deleteCurso(Long idCurso) {
        Curso curso = getCursoById(idCurso);
        cursoDaoImpl.delete(curso);
        return new TransactionResult(String.format("Baja exitosa de Curso %s",curso.getNombre()),Boolean.TRUE);
    }

}
