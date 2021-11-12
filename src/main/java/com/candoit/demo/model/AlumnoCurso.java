package com.candoit.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AlumnoCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersonaCurso;

    @ManyToOne
    @JoinColumn(name="id_alumno")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name="id_curso")
    private Curso curso;
    
    public AlumnoCurso(){}

    public AlumnoCurso(Alumno alumno,Curso curso){
        this.alumno = alumno;
        this.curso = curso;
    }

    public Long getIdPersonaCurso(){
        return idPersonaCurso;
    }

    public void setIdPersonaCurso(Long idPersonaCurso){
        this.idPersonaCurso = idPersonaCurso;
    }

    public Alumno getAlumno(){
        return alumno;
    }

    public void setAlumno(Alumno alumno){
        this.alumno = alumno;
    }

    public Curso getCurso(){
        return curso;
    }

    public void setCurso(Curso curso){
        this.curso = curso;
    }

}
