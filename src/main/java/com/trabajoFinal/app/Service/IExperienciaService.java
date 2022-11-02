package com.trabajoFinal.app.Service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.trabajoFinal.app.Model.Experiencia;


public interface IExperienciaService {
	public Iterable<Experiencia> findAll();

	public Page<Experiencia> findAll(Pageable pageable);

	public Optional <Experiencia> findById(Long id);

	public Experiencia save (Experiencia experiencia);

	public void deleteById(Long id);

}
