package com.trabajoFinal.app.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trabajoFinal.app.Model.Experiencia;
import com.trabajoFinal.app.Repository.IExperienciaRepository;


@Service
public class ExperienciaServiceImpl implements IExperienciaService{

	@Autowired
	private IExperienciaRepository iexperienciaRepository;

	@Override
	@Transactional(readOnly=true)
	public Iterable<Experiencia> findAll() {
		return iexperienciaRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Experiencia> findAll(Pageable pageable) {
		return iexperienciaRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Experiencia> findById(Long id) {
		return iexperienciaRepository.findById(id);
	}

	@Override
	@Transactional
	public Experiencia save(Experiencia experiencia) {
		return iexperienciaRepository.save(experiencia);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		iexperienciaRepository.deleteById(id);

	}

}
