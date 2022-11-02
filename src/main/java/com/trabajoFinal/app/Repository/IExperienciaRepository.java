package com.trabajoFinal.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trabajoFinal.app.Model.Experiencia;

@Repository
public interface IExperienciaRepository extends JpaRepository<Experiencia, Long> {

}




