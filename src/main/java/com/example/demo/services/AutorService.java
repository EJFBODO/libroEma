package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.AutorModel;
import com.example.demo.repositories.AutorRepository;


@Service
public class AutorService {
	@Autowired
	AutorRepository autorRepository;
	
	public ArrayList <AutorModel> obtenerAutores() {

		return (ArrayList<AutorModel>) autorRepository.findAll();
	}
	
	public Optional<AutorModel> obtenerAutor(Long id) {
		return autorRepository.findById(id);}
	
	public AutorModel guardarAutor(AutorModel a) {

		return autorRepository.save(a);
	}
	
	public boolean borrarAutor(Long id) {
		Optional<AutorModel> a = autorRepository.findById(id);

		if (a.isPresent()) {
			a.get().setActivo(false);
			autorRepository.save(a.get());
			return true;
		}

		return false;
	}
	
	public boolean borrarAutorDefinitivo(Long id) {
		Optional<AutorModel> a = autorRepository.findById(id);

		if (a.isPresent()) {
			autorRepository.deleteById(id);
			return true;
		}

		return false;
	}
	
	
	}
