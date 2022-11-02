package com.trabajoFinal.app.Service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trabajoFinal.app.Model.Usuario;
import com.trabajoFinal.app.Repository.IUsuarioRepository;

@Service
public class UsuarioServiceImpl implements IUserService{

	@Autowired
	private IUsuarioRepository iusuarioRepository;

	@Override
	@Transactional(readOnly=true)
	public Iterable<Usuario> findAll() {
		return iusuarioRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Usuario> findAll(org.springframework.data.domain.Pageable pageable) {
		return iusuarioRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Usuario> findById(Long id) {
		return iusuarioRepository.findById(id);
	}

	@Override
	@Transactional
	public Usuario save(Usuario usuario) {
		return iusuarioRepository.save(usuario);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		iusuarioRepository.deleteById(id);
	}

}
