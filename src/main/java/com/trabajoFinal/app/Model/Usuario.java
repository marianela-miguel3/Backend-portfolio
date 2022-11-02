package com.trabajoFinal.app.Model;

import javax.persistence.*;



@Entity
@Table(name="usuario")
public class Usuario {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name="id")
   private Long id;
   
   @Column(name="nombre")
   private String nombre;
   
   @Column(name="apellido")
   private String apellido;
   
   @Column(name="titulo")
   private String titulo;
   
   @Column(name="imagen")
   private String imagen;
   
   @Column(name="descripcion")
   private String descripcion;
   
  /* @OneToMany(mappedBy="usuario")
   @JoinColumn(name="id")
   (mappedBy="usuario", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
   private List<Experiencia> experiencias;
   */
   
   /*@OneToMany(fetch=FetchType.LAZY, mappedBy="usuario", cascade= CascadeType.ALL)
   private List <Experiencia> experiencias;
   */
   
   

public Usuario(String nombre, String apellido, String titulo, String imagen, String descripcion) {
	this.nombre = nombre;
	this.apellido = apellido;
	this.titulo = titulo;
	this.imagen = imagen;
	this.descripcion = descripcion;
}

public Usuario() {
}


/*public List<Experiencia> getExperiencias() {
	return experiencias;
}

public void setExperiencias(List<Experiencia> experiencias) {
	this.experiencias = experiencias;
}
*/



public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getApellido() {
	return apellido;
}

public void setApellido(String apellido) {
	this.apellido = apellido;
}

public String getTitulo() {
	return titulo;
}

public void setTitulo(String titulo) {
	this.titulo = titulo;
}

public String getImagen() {
	return imagen;
}

public void setImagen(String imagen) {
	this.imagen = imagen;
}

public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}


  
   /*@OneToMany(mappedBy="usuario", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
   private List<Experiencia> experiencias;
   
   @OneToMany(mappedBy="usuario", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
   private List<Educacion> educaciones;
   
   @OneToMany(mappedBy="usuario", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
   private List <Proyecto> proyectos;
   	   */
   
}
