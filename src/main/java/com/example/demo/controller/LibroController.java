package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.LibroModel;
import com.example.demo.services.LibroService;


@RestController
@RequestMapping ("/libro")

public class LibroController {
	@Autowired
	LibroService libroService;
	
	@GetMapping()
	public ArrayList<LibroModel> obtenerLibros(){
		ArrayList<LibroModel> listado = libroService.obtenerLibros();
		listado.removeIf(u -> u.isActivo() == false);
		return listado;
	}
	
	@GetMapping(path="/{id}")
	public Optional<LibroModel> obtenerLibro(@PathVariable("id") Long id) {
		return libroService.obtenerLibro(id);
	}
	
	@PostMapping()
	public String guardarLibro(@RequestBody LibroModel l) {
		libroService.guardarLibro(l);
		return "Libro Creado";
	}
	@DeleteMapping(path="/{id}")
	public String borrarLibro(@PathVariable("id") Long id) {
		boolean response = libroService.borrarLibro(id);
		if(response) {
			return "Libro Borrado";
		}else {
			return "Error al borrar libro";
		}
	}
	
	@DeleteMapping (path="/{id}")
	public String borrarLibroDefinitivo(@PathVariable("id") Long id) {
		boolean response = libroService.borrarLibroDefinitivo(id);
		if(response) {
			return "Libro Borrado";
		}else {
			return "Error al borrar libro";
		
	

}
	}
}

