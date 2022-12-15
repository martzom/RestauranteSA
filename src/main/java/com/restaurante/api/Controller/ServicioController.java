package com.restaurante.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.api.model.Servicio;
import com.restaurante.api.repositorio.ServicioRepositorio;

@RestController
@RequestMapping("/api")
public class ServicioController {

	@Autowired
	private ServicioRepositorio repositorio;
	
	@GetMapping("/servicio")
	public List<Servicio> listarTodosLosServicios(){
		validarServicio();
		return repositorio.findAll();
	}

	private void validarServicio() {
	}
}
