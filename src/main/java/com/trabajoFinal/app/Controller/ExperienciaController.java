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

import com.trabajoFinal.app.Model.Experiencia;
import com.trabajoFinal.app.Service.IExperienciaService;

@RestController
@RequestMapping("/experiencia")
@CrossOrigin(origins="http://localhost:4200")
public class ExperienciaController {
 @Autowired
 private IExperienciaService iexperienciaService;

 @PostMapping
	public ResponseEntity<?> create(@RequestBody Experiencia experiencia) {
		return ResponseEntity.status(HttpStatus.CREATED).body(iexperienciaService.save(experiencia));
	}

 @GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value="id") Long experienciaId){
		Optional<Experiencia> oExperiencia = iexperienciaService.findById(experienciaId);
		if(!oExperiencia.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oExperiencia);
	}

 @PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Experiencia userDetails, @PathVariable (value="id") Long experienciaId) {
		Optional<Experiencia> experiencia=iexperienciaService.findById(experienciaId);
		if(!experiencia.isPresent()) {
			return ResponseEntity.notFound().build();
		}
	  experiencia.get().setTitulo(userDetails.getTitulo());
	  experiencia.get().setAnio(userDetails.getAnio());
	  experiencia.get().setDescripcion(userDetails.getDescripcion());
	  return ResponseEntity.status(HttpStatus.CREATED).body(iexperienciaService.save(experiencia.get()));
	}

 @DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable Long id){
	if(!iexperienciaService.findById(id).isPresent()) {
		return ResponseEntity.notFound().build();
	}
	iexperienciaService.deleteById(id);
	return ResponseEntity.ok().build();
	}

 @GetMapping
	public List<Experiencia> readAll () {
	List<Experiencia> experiencias = StreamSupport
			.stream(iexperienciaService.findAll().spliterator(), false)
			.collect(Collectors.toList());
	return experiencias;
	}
}
