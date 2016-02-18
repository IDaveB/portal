package com.portalapp.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.portalapp.dao.UsuarioDao;
import com.portalapp.pojo.Usuario;

/**
 * Clase encargada de recoger e insertar usuario en la BBDD mediante el
 * framework hibernate.
 */

@Repository
public class UsuarioDaoImpl implements UsuarioDao {

  /**
   * Definimos inject.
   */
  @Inject
  private SessionFactory sessionFactory;

  /**
   * Metodo que se pasa un usuario y hibernate mediante una sesionfactory se
   * encarga de comprobar que un usuario existe mediante su email y password
   * Retornando un usuario en caso de existir y null en caso contrario.
   */

  @Transactional(readOnly = true)
  public final Usuario login(final Usuario usuario) {
    try {

      return (Usuario) sessionFactory.getCurrentSession()
          .createCriteria(Usuario.class)
          .add(Restrictions.eq("email", usuario.getEmail()))
          .add(Restrictions.eq("password", usuario.getPassword()))
          .uniqueResult();

    } finally {

      sessionFactory.close();

    }
  }

  /**
   * Metodo que se pasa un usuario y hibernate mediante una sesionfactory se
   * encarga de listar los usuarios. Retornando un usuario en caso de existir y
   * null en caso contrario.
   */

  @Transactional(readOnly = true)
  @SuppressWarnings("unchecked")
  public final List<Usuario> listar(final Usuario usuario) {
    try {

      return sessionFactory.getCurrentSession().createCriteria(Usuario.class)
          .add(Restrictions.not(Restrictions.eq("email", usuario.getEmail())))
          .list();

    } finally {

      sessionFactory.close();

    }
  }

  /**
   * Metodo que se pasa un usuario y hibernate mediante una sesionfactory se
   * encarga de editar un usuario en bbdd.
   */

  @Transactional(readOnly = true)
  public final void editar(final Usuario usuario) {
    try {
      sessionFactory.getCurrentSession().update(usuario);

    } finally {

      sessionFactory.close();
    }
  }

  /**
   * Metodo que se pasa un usuario y hibernate mediante una sesionfactory se
   * encarga de borrar un usuario en bbdd.
   */

  @Transactional(readOnly = true)
  public final void borrar(final Usuario usuario) {
    try {

      sessionFactory.getCurrentSession().delete(usuario);

    } finally {

      sessionFactory.close();
    }

  }

  /**
   * Metodo que se pasa un usuario y hibernate mediante una sesionfactory se
   * encarga de añadir un usuario en bbdd.
   */

  @Transactional(readOnly = true)
  public boolean add(final Usuario usuario) {

    try {

      sessionFactory.getCurrentSession().save(usuario);

      return true;

    } catch (Exception e) {

      return false;

    } finally {

      sessionFactory.close();
    }

  }

}
