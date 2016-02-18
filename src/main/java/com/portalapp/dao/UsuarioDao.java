package com.portalapp.dao;

import java.util.List;

import com.portalapp.pojo.Usuario;

/**
 * Interfaz donde declarar los metodos relacionados con un usuario/s y que
 * trataremos con la BBDD.
 */

public interface UsuarioDao {

  /**
   * Metodo que comprobara que un usuario existe pasandole el email y password.
   */

  Usuario login(Usuario usuario);

  /**
   * Metodo que devuelve un listado de usuarios de la bbdd.
   */

  List<Usuario> listar(Usuario usuario);

  /**
   * Metodo que añade un usuario en bbdd.
   */

  boolean add(Usuario usuario);

  /**
   * Metodo que edita un usuario en bbdd.
   */

  void editar(Usuario usuario);

  /**
   * Metodo que elimina un usuario en bbdd.
   */

  void borrar(Usuario usuario);

}
