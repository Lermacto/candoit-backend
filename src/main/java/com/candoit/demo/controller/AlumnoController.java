package com.candoit.demo.controller;

import java.util.List;

import com.candoit.demo.commons.TransactionResult;
import com.candoit.demo.dto.AltaAlumnoRequest;
import com.candoit.demo.dto.UpdateAlumnoRequest;
import com.candoit.demo.exception.DBException;
import com.candoit.demo.model.Alumno;
import com.candoit.demo.service.AlumnoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/alumno")
public class AlumnoController {
    
    @Autowired
    AlumnoService alumnoService;

    @PostMapping("new")
    public ResponseEntity<?> altaAlumno(@RequestBody AltaAlumnoRequest altaAlumnoRequest) throws DBException{
        Alumno alumno = new Alumno();
        alumno.setNombre(altaAlumnoRequest.getNombre());
        return new ResponseEntity<TransactionResult>(alumnoService.createAlumno(alumno),HttpStatus.OK);
    }

    @GetMapping("get/byId/{alumnoId}")
    public ResponseEntity<?> getAlumnoById(@PathVariable("alumnoId") Long idAlumno){
        return new ResponseEntity<Alumno>(alumnoService.getAlumnoById(idAlumno),HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<List<Alumno>>(alumnoService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("delete/{alumnoId}")
    public ResponseEntity<?> deleteAlumno(@PathVariable("alumnoId") Long idAlumno){
        return new ResponseEntity<TransactionResult>(alumnoService.deleteAlumno(idAlumno), HttpStatus.OK);
    }

    @PostMapping("update")
    public ResponseEntity<?> updateAlumno(@RequestBody UpdateAlumnoRequest updateAlumno){
        return new ResponseEntity<TransactionResult>(alumnoService.updateAlumno(updateAlumno),HttpStatus.OK);
    }

}
