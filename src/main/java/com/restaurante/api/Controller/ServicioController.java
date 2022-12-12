package com.restaurante.api.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.api.excepciones.ResourceNotFoundException;
import com.restaurante.api.model.Servicio;
import com.restaurante.api.repositorio.ServicioRepositorio;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")
public class ServicioController {

	@Autowired
	private ServicioRepositorio repositorio;
	
	@GetMapping("/servicio")
	public List<Servicio> listarTodosLosServicios(){
		return repositorio.findAll();
	}
	//este metodo sirve para buscar un empleado
		@GetMapping("/servicio/{id}")
		public ResponseEntity<Servicio> obtenerServicioPorId(@PathVariable Long id){
				Servicio servicio = repositorio.findById(id)
						            .orElseThrow(() -> new ResourceNotFoundException("No existe el servicio con el ID : " + id));
				return ResponseEntity.ok(servicio);
		}
		
		//este metodo sirve para actualizar empleado
		@PutMapping("/servicio/{id}")
		public ResponseEntity<Servicio> actualizarServicio(@PathVariable Long id,@RequestBody Servicio detallesServicio){
			Servicio servicio = repositorio.findById(id)
					            .orElseThrow(() -> new ResourceNotFoundException("No existe el servicio con el ID : " + id));
			
			servicio.setNombre(detallesServicio.getNombre());
			servicio.setDetalle(detallesServicio.getDetalle());
			servicio.setImagen(detallesServicio.getImagen());
			
			Servicio empleadoActualizado = repositorio.save(servicio);
			return ResponseEntity.ok(empleadoActualizado);
	    }
		
		//este metodo sirve para eliminar un empleado
		@DeleteMapping("/servicio/{id}")
		public ResponseEntity<Map<String,Boolean>> eliminarEmpleado(@PathVariable Long id){
			Servicio servicio = repositorio.findById(id)
					            .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID : " + id));
			
			repositorio.delete(servicio);
			Map<String, Boolean> respuesta = new HashMap<>();
			respuesta.put("eliminar",Boolean.TRUE);
			return ResponseEntity.ok(respuesta);
	    }
}
