package com.trabajoFinal.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trabajoFinal.app.Model.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository <Usuario, Long>{
	

}
