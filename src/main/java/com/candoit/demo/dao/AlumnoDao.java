package com.candoit.demo.dao;

import com.candoit.demo.model.Alumno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoDao extends JpaRepository<Alumno,Long> {
    
}
