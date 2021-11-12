package com.candoit.demo.dao;

import com.candoit.demo.model.Curso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoDao extends JpaRepository<Curso,Long>{
    
}
