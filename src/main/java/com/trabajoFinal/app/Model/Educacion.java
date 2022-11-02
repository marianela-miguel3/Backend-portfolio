package com.trabajoFinal.app.Model;

import javax.persistence.*;


@Entity
@Table(name="educacion")
public class Educacion {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
     private Long id;
	@Column(name="institucion")
	 private String institucion;
	@Column(name="anio")
	 private String anio;
	@Column(name="nombre")
	 private String nombre;
	@Column(name="lugar")
	 private String lugar;
	public Educacion(String institucion, String anio, String nombre, String lugar) {
		super();
		this.institucion = institucion;
		this.anio = anio;
		this.nombre = nombre;
		this.lugar = lugar;
	}
	public Educacion() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getInstitucion() {
		return institucion;
	}
	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}
	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	
	/*@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="usuario_id")
	private Usuario usuario;*/
	
	 
	}


