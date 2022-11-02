package com.trabajoFinal.app.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trabajoFinal.app.Model.Proyecto;
import com.trabajoFinal.app.Repository.IProyectoRepository;

@Service
public class ProyectoServiceImpl implements IProyectoService{

	@Autowired
	private IProyectoRepository iproyectoRepository;

	@Override
	@Transactional(readOnly=true)
	public Iterable<Proyecto> findAll() {
		return iproyectoRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Proyecto> findAll(org.springframework.data.domain.Pageable pageable) {
		return iproyectoRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Proyecto> findById(Long id) {
		return iproyectoRepository.findById(id);
	}

	@Override
	@Transactional
	public Proyecto save(Proyecto proyecto) {
		return iproyectoRepository.save(proyecto);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		iproyectoRepository.deleteById(id);
	}

}
