package com.candoit.demo.dto;

public class AltaCursoRequest {
    
    private String nombre;
    private String descripcion;
    
    public String getNombre() {
        return nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
