package com.candoit.demo.controller;

import com.candoit.demo.commons.TransactionResult;
import com.candoit.demo.exception.DBException;
import com.candoit.demo.service.AlumnoCursoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "api/alumnoCurso/")
public class AlumnoCursoController {

    @Autowired
    AlumnoCursoService alumnoCursoService;

    @GetMapping("asociarAlumnoCurso/{idAlumno}/{idCurso}")
    public ResponseEntity<?> asociarAlumnoCurso(@PathVariable("idAlumno") Long idAlumno, @PathVariable("idCurso") Long idCurso) throws DBException{
        return new ResponseEntity<TransactionResult>(alumnoCursoService.asociarAlumnoCurso(idAlumno,idCurso),HttpStatus.OK);
    }
    
}
