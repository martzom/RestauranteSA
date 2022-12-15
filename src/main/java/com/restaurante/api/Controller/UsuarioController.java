package com.restaurante.api.Controller;

import com.restaurante.api.model.Usuario;
import com.restaurante.api.repositorio.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
public class UsuarioController {
    @Autowired
    private ServicioUsuario servicioUsuario;




    @GetMapping("/usuario")
    //devolver todos los usuarios
    public List<Usuario> listarTodosLosUsuarios(){
   return servicioUsuario.findAll();
    }
    //agregar un usuario
    @PostMapping("/usuario")
    public Usuario agregarUsuario(Usuario usuario){
        return servicioUsuario.save(usuario);
    }
//Recuperar valores del Body

    @PostMapping("/ingresar")
    public String ingresar(@RequestBody Usuario usuario){
          //guardar usuario
        servicioUsuario.save(usuario);
        return "usario ingresado";
    }

    }

