package com.trabajoFinal.app.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabajoFinal.app.Model.Usuario;
import com.trabajoFinal.app.Service.IUserService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins="http://localhost:4200")


public class UsuarioController {

	@Autowired
	 private IUserService iUserService;

	//crear un usuario
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(iUserService.save(usuario));
	}

	//leer un usuario
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value="id") Long userId){
		Optional<Usuario> oUsuario = iUserService.findById(userId);
		if(!oUsuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oUsuario);
	}
	//actualizar un usuario
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Usuario userDetails, @PathVariable (value="id") Long userId) {
		Optional<Usuario> usuario=iUserService.findById(userId);
		if(!usuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}
	  usuario.get().setNombre(userDetails.getNombre());
	  usuario.get().setApellido(userDetails.getApellido());
	  usuario.get().setTitulo(userDetails.getTitulo());
	  usuario.get().setImagen(userDetails.getImagen());
	  usuario.get().setDescripcion(userDetails.getDescripcion());
	  return ResponseEntity.status(HttpStatus.CREATED).body(iUserService.save(usuario.get()));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable Long id){
	if(!iUserService.findById(id).isPresent()) {
		return ResponseEntity.notFound().build();
	}
	iUserService.deleteById(id);
	return ResponseEntity.ok().build();
	}

	@GetMapping
	public List<Usuario> readAll () {
	List<Usuario> usuarios = StreamSupport
			.stream(iUserService.findAll().spliterator(), false)
			.collect(Collectors.toList());
	return usuarios;
	}
}
