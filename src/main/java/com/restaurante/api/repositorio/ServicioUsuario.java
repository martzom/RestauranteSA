package com.restaurante.api.repositorio;

import com.restaurante.api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface ServicioUsuario extends JpaRepository<Usuario, Long> {

    }

