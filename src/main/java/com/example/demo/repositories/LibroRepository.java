package com.example.demo.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.LibroModel;




@Repository
public interface LibroRepository extends CrudRepository <LibroModel,Long>  {
	
	@Query(value = "SELECT * FROM libro WHERE nombre = ?1", nativeQuery = true)
	LibroModel buscarPorNombre(String nombre);

}
