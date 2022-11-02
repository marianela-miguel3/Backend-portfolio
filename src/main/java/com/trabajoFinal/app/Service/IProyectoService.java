package com.trabajoFinal.app.Service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.trabajoFinal.app.Model.Proyecto;

public interface IProyectoService {
	public Iterable<Proyecto> findAll();

	public Page<Proyecto> findAll(Pageable pageable);

	public Optional <Proyecto> findById(Long id);

	public Proyecto save (Proyecto proyecto);

	public void deleteById(Long id);

}
