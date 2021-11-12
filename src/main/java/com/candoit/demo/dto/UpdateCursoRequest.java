package com.candoit.demo.dto;

public class UpdateCursoRequest {
    private String nombreUpdate;
    private String descripcionUpdate;
    private Long idCursoToUpdate;
    
    public String getNombreUpdate() {
        return nombreUpdate;
    }
    public Long getIdCursoToUpdate() {
        return idCursoToUpdate;
    }
    public void setIdCursoToUpdate(Long idCursoToUpdate) {
        this.idCursoToUpdate = idCursoToUpdate;
    }
    public String getDescripcionUpdate() {
        return descripcionUpdate;
    }
    public void setDescripcionUpdate(String descripcionUpdate) {
        this.descripcionUpdate = descripcionUpdate;
    }
    public void setNombreUpdate(String nombreUpdate) {
        this.nombreUpdate = nombreUpdate;
    }
}
