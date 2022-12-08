package com.restaurante.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurante.api.model.Servicio;

@Repository
public interface ServicioRepositorio extends JpaRepository <Servicio,Long> {

}
