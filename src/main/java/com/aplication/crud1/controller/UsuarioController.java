package com.aplication.crud1.controller;

import com.aplication.crud1.model.UsuarioModel;
import com.aplication.crud1.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> obteberUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }
    @GetMapping("/query")
    public ArrayList<UsuarioModel> obteberUsuarioPorPrioridad (@RequestParam("prioridad")Integer prioridad){
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id")Long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok){
            return "Se eliminó Usuario Por ID"+id;
        }else{
            return "No puedo eliminar el usuario con id"+id;
        }
    }








}
