package com.candoit.demo.dto;

public class UpdateAlumnoRequest {
    private Long alumnoIdToUpdate;
    private String nombreUpdate;
    
    public Long getAlumnoIdToUpdate() {
        return alumnoIdToUpdate;
    }
    public String getNombreUpdate() {
        return nombreUpdate;
    }
    public void setNombreUpdate(String nombreUpdate) {
        this.nombreUpdate = nombreUpdate;
    }
    public void setAlumnoIdToUpdate(Long alumnoIdToUpdate) {
        this.alumnoIdToUpdate = alumnoIdToUpdate;
    }
}
