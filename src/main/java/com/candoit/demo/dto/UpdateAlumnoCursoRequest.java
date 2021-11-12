package com.candoit.demo.dto;

public class UpdateAlumnoCursoRequest {
    
    private Long idAlumno;
    private Long currentIdCurso;
    private Long newIdCurso;
    
    public Long getIdAlumno() {
        return idAlumno;
    }
    public Long getNewIdCurso() {
        return newIdCurso;
    }
    public void setNewIdCurso(Long newIdCurso) {
        this.newIdCurso = newIdCurso;
    }
    public Long getCurrentIdCurso() {
        return currentIdCurso;
    }
    public void setCurrentIdCurso(Long currentIdCurso) {
        this.currentIdCurso = currentIdCurso;
    }
    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
    }

}
