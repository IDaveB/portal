package com.portalapp.service;

import java.util.List;

import com.portalapp.pojo.Usuario;

/**
 * Interfaz donde definiremos los servicios del usuario.
 */

public interface UsuarioService {

  /**
   * Metodo que llama a la calse DAO para comprobar que un usuario existe
   * pasandole el email y password.
   */

  Usuario login(Usuario usuario);

  /**
   * Metodo que llama a la calse DAO y devuelve un listado de usuarios de la
   * bbdd.
   */

  List<Usuario> listar(Usuario usuario);

  /**
   * Metodo que llama a la calse DAO para insertar un usuario en bbdd.
   */

  boolean add(Usuario usuario);

  /**
   * Metodo que llama a la calse DAO para editar un usuario en bbdd.
   */

  void editar(Usuario usuario);

  /**
   * Metodo que llama a la calse DAO y que elimina un usuario en bbdd.
   */

  void eliminar(Usuario usuario);

}
