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

import com.trabajoFinal.app.Model.Proyecto;
import com.trabajoFinal.app.Service.IProyectoService;

@RestController
@RequestMapping("/proyecto")
@CrossOrigin(origins="http://localhost:4200")
public class ProyectoController {
	
	@Autowired
	private IProyectoService iproyectoService;
	
	// crear uno
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Proyecto proyecto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(iproyectoService.save(proyecto));
	}

	// leer uno
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long proyectoId) {
		Optional<Proyecto> oProyecto = iproyectoService.findById(proyectoId);
		if (!oProyecto.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oProyecto);
	}

	// actualizar uno
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Proyecto userDetails, @PathVariable(value = "id") Long proyectoId) {
		Optional<Proyecto> proyecto = iproyectoService.findById(proyectoId);
		if (!proyecto.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		proyecto.get().setNombre(userDetails.getNombre());
		proyecto.get().setDescripcion(userDetails.getDescripcion());
		proyecto.get().setImagen(userDetails.getImagen());
		return ResponseEntity.status(HttpStatus.CREATED).body(iproyectoService.save(proyecto.get()));
	}
	
	//eliminar uno
			@DeleteMapping("/{id}")
			public ResponseEntity<?> delete (@PathVariable Long id){
			if(!iproyectoService.findById(id).isPresent()) {
				return ResponseEntity.notFound().build();
			}
			iproyectoService.deleteById(id);
			return ResponseEntity.ok().build();
			}
			
			//leer todos
			@GetMapping
			public List<Proyecto> readAll () {
			List<Proyecto> proyectos = StreamSupport
					.stream(iproyectoService.findAll().spliterator(), false)
					.collect(Collectors.toList());
			return proyectos;
			}
}
