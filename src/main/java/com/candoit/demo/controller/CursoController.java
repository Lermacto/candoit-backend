package com.candoit.demo.controller;

import com.candoit.demo.commons.TransactionResult;
import com.candoit.demo.dto.AltaCursoRequest;
import com.candoit.demo.dto.UpdateCursoRequest;
import com.candoit.demo.exception.DBException;
import com.candoit.demo.model.Curso;
import com.candoit.demo.service.CursoService;

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
@RequestMapping(value = "api/curso")
public class CursoController {
    
    @Autowired
    CursoService cursoService;

    @PostMapping("new")
    public ResponseEntity<?> altaCurso(@RequestBody AltaCursoRequest altaCursoRequest) throws DBException{
        Curso curso = new Curso();
        curso.setNombre(altaCursoRequest.getNombre());
        curso.setDescripcion(altaCursoRequest.getDescripcion());
        return new ResponseEntity<TransactionResult>(cursoService.createCurso(curso),HttpStatus.OK);
    }

    @GetMapping("get/byId/{idCurso}")
    public ResponseEntity<?> getCursoById(@PathVariable("idCurso") Long idCurso){
        return new ResponseEntity<Curso>(cursoService.getCursoById(idCurso), HttpStatus.OK);
    }

    @GetMapping("update")
    public ResponseEntity<?> updateCurso(@RequestBody UpdateCursoRequest updateCurso){
        return new ResponseEntity<TransactionResult>(cursoService.updateCurso(updateCurso),HttpStatus.OK);
    }

    @DeleteMapping("delete/{idCurso}")
    public ResponseEntity<?> deleteCurso(@PathVariable("idCurso") Long idCurso){
        return new ResponseEntity<TransactionResult>(cursoService.deleteCurso(idCurso),HttpStatus.OK);
    }
}
