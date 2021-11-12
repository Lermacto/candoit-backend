package com.candoit.demo.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.candoit.demo.commons.TransactionResult;
import com.candoit.demo.dao.AlumnoDao;
import com.candoit.demo.dto.UpdateAlumnoRequest;
import com.candoit.demo.exception.DBException;
import com.candoit.demo.model.Alumno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoService {

    @Autowired
    AlumnoDao alumnoDaoImpl;

    public TransactionResult createAlumno(Alumno alumno) throws DBException {
        try {
            alumnoDaoImpl.save(alumno);
        } catch (Exception e) {
            throw new DBException();
        }
        return new TransactionResult("Alta exitosa de alumno",Boolean.TRUE);
    }

    public Alumno getAlumnoById(Long idAlumno) {
        return alumnoDaoImpl.findById(idAlumno).orElseThrow(() -> new EntityNotFoundException());
    }

    public TransactionResult deleteAlumno(Long idAlumno) {
        Alumno alumno = getAlumnoById(idAlumno);
        alumnoDaoImpl.delete(alumno);
        return new TransactionResult(String.format("Baja exitosa de alumno %s", alumno.getNombre()),Boolean.TRUE);
    }

    public List<Alumno> getAll() {
        return alumnoDaoImpl.findAll();
    }

    public TransactionResult updateAlumno(UpdateAlumnoRequest updateAlumno) {
        Alumno alumno = getAlumnoById(updateAlumno.getAlumnoIdToUpdate());
        String oldName = alumno.getNombre();
        alumno.setNombre(updateAlumno.getNombreUpdate());
        alumnoDaoImpl.save(alumno);
        return new TransactionResult(String.format("Update exitoso de Alumno %s a nombre %s", oldName,alumno.getNombre()),Boolean.TRUE);
    }
    
}
