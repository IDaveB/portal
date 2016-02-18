package com.portalapp.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portalapp.dao.UsuarioDao;
import com.portalapp.pojo.Usuario;
import com.portalapp.service.UsuarioService;

/**
 * Clase que implementa los metodos CRUD de una interfaz usuario.
 */

@Service
public class UsuarioServiceImpl implements UsuarioService {

  /**
   * fdhh.
   */
  @Inject
  UsuarioDao usuarioDao;

  /**
   * Metodo implementado de la interfaz service para comprobar que un usuario
   * existe llamando a la clase dao.
   */

  @Transactional
  public final Usuario login(final Usuario usuario) {
    return usuarioDao.login(usuario);

  }

  /**
   * Metodo implementado de la interfaz service para listar los usuarios
   * llamando a la clase dao.
   */

  @Transactional
  public List<Usuario> listar(final Usuario usuario) {
    return usuarioDao.listar(usuario);
  }

  /**
   * Metodo implementado de la interfaz service para editar un usuario llamando
   * a la clase dao.
   */

  @Transactional
  public final void editar(final Usuario usuario) {

    usuarioDao.editar(usuario);
  }

  /**
   * Metodo implementado de la interfaz service para eliminar un usuario
   * llamando a la clase dao.
   */

  @Transactional
  public final void eliminar(final Usuario usuario) {

    usuarioDao.borrar(usuario);

  }

  /**
   * Metodo implementado de la interfaz service para eliminar un usuario
   * llamando a la clase dao.
   */

  @Transactional
  public boolean add(final Usuario usuario) {

    return usuarioDao.add(usuario);

  }

}
