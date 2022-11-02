package com.trabajoFinal.app.Service;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.trabajoFinal.app.Model.Usuario;

public interface IUserService {
	public Iterable<Usuario> findAll();

	public Page<Usuario> findAll(Pageable pageable);

	public Optional <Usuario> findById(Long id);

	public Usuario save (Usuario usuario);

	public void deleteById(Long id);

}
