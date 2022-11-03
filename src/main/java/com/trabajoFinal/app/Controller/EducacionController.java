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

import com.trabajoFinal.app.Model.Educacion;
import com.trabajoFinal.app.Service.IEducacionService;

@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins="https://frontendportfolio-5c98e.web.app")
/*@CrossOrigin(origins="**")*/

public class EducacionController {

	@Autowired
	 private IEducacionService ieducacionService;

	//crear uno
		@PostMapping
		public ResponseEntity<?> create(@RequestBody Educacion educacion) {
			return ResponseEntity.status(HttpStatus.CREATED).body(ieducacionService.save(educacion));
		}

		//leer uno
		@GetMapping("/{id}")
		public ResponseEntity<?> read(@PathVariable(value="id") Long educacionId){
			Optional<Educacion> oEducacion = ieducacionService.findById(educacionId);
			if(!oEducacion.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(oEducacion);
		}

		//actualizar uno
		@PutMapping("/{id}")
		public ResponseEntity<?> update (@RequestBody Educacion userDetails, @PathVariable (value="id") Long educacionId) {
			Optional<Educacion> educacion=ieducacionService.findById(educacionId);
			if(!educacion.isPresent()) {
				return ResponseEntity.notFound().build();
			}
		educacion.get().setInstitucion(userDetails.getInstitucion());
		educacion.get().setAnio(userDetails.getAnio());
		educacion.get().setNombre(userDetails.getNombre());
		educacion.get().setLugar(userDetails.getLugar());
		  return ResponseEntity.status(HttpStatus.CREATED).body(ieducacionService.save(educacion.get()));
		}

		//eliminar uno
		@DeleteMapping("/{id}")
		public ResponseEntity<?> delete (@PathVariable Long id){
		if(!ieducacionService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		ieducacionService.deleteById(id);
		return ResponseEntity.ok().build();
		}

		//leer todos
		@GetMapping
		public List<Educacion> readAll () {
		List<Educacion> educaciones = StreamSupport
				.stream(ieducacionService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return educaciones;
		}
}
