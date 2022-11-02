package com.trabajoFinal.app.Service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.trabajoFinal.app.Model.Educacion;

public interface IEducacionService {
		public Iterable<Educacion> findAll();

		public Page<Educacion> findAll(Pageable pageable);

		public Optional <Educacion> findById(Long id);

		public Educacion save (Educacion educacion);

		public void deleteById(Long id);
}
