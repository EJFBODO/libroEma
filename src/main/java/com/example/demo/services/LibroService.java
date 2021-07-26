package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.LibroModel;
import com.example.demo.repositories.LibroRepository;



@Service
public class LibroService {
	@Autowired
	LibroRepository libroRepository;
	
	public ArrayList <LibroModel> obtenerLibros(){
		
		return (ArrayList<LibroModel>) libroRepository.findAll();
	}
	
	public Optional<LibroModel> obtenerLibro(Long id) {
		return libroRepository.findById(id);
	}
	
	public LibroModel guardarLibro(LibroModel l) {
		
		return libroRepository.save(l);
	}
	
	public boolean borrarLibro(Long id) {
		Optional<LibroModel> l = libroRepository.findById(id);
	
		if(l.isPresent()) {
			l.get().setActivo(false);
			libroRepository.save(l.get());
			return true;
		}
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
