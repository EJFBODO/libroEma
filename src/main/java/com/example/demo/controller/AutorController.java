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

import com.example.demo.models.AutorModel;
import com.example.demo.models.LibroModel;
import com.example.demo.services.AutorService;
import com.example.demo.services.LibroService;

@RestController
@RequestMapping("/autor")

public class AutorController {
	@Autowired
	AutorService autorService;

	@GetMapping()
	public ArrayList<AutorModel> obtenerAutores() {
		ArrayList<AutorModel> listado = autorService.obtenerAutores();
		listado.removeIf(u -> u.isActivo() == false);
		return listado;
	}

	@GetMapping(path = "/{id}")
	public Optional<AutorModel> obtenerAutor(@PathVariable("id") Long id) {
		return autorService.obtenerAutor(id);
	}

	@PostMapping()
	public String guardarAutor(@RequestBody AutorModel a) {
		autorService.guardarAutor(a);
		return "Autor Creado";
	}

	@DeleteMapping(path = "/{id}")
	public String borrarAutor(@PathVariable("id") Long id) {
		boolean response = autorService.borrarAutor(id);
		if (response) {
			return "Autor Borrado";
		} else {
			return "Error al borrar autor";
		}
	}

	@DeleteMapping(path = "/delete/{id}")
	public String borrarAutorDefinitivo(@PathVariable("id") Long id) {
		boolean response = autorService.borrarAutorDefinitivo(id);
		if (response) {
			return "Autor Borrado";
		} else {
			return "Error al borrar autor";

		}
	}

}
