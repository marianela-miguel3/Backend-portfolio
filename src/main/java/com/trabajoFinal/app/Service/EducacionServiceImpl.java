package com.trabajoFinal.app.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trabajoFinal.app.Model.Educacion;
import com.trabajoFinal.app.Repository.IEducacionRepository;

@Service
public class EducacionServiceImpl implements IEducacionService{

	@Autowired
	private IEducacionRepository ieducacionRepository;

	@Override
	@Transactional(readOnly=true)
	public Iterable<Educacion> findAll() {
		return ieducacionRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Educacion> findAll(org.springframework.data.domain.Pageable pageable) {
		return ieducacionRepository.findAll(pageable);
	}
	@Override
	@Transactional(readOnly=true)
	public Optional<Educacion> findById(Long id) {
		return ieducacionRepository.findById(id);
	}

	@Override
	@Transactional
	public Educacion save(Educacion educacion) {
		return ieducacionRepository.save(educacion);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
	     ieducacionRepository.deleteById(id);

	}

}
