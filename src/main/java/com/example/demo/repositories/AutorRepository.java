package com.example.demo.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.LibroModel;
import com.example.demo.models.AutorModel;

@Repository
public interface AutorRepository extends CrudRepository <AutorModel, Long>{

}
