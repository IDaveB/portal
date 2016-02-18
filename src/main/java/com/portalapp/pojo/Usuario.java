package com.portalapp.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Definimos Table indicando que es una tabla de la bbdd.
 */

@Entity
@Table(name = "usuarios")
public class Usuario {

  /**
   * Definimos Id indicando que es el campo clave de la bbdd y Column para
   * indicar que es una columna id.
   */

  @Id
  @Column(name = "idusuario")
  @GeneratedValue
  private int idUsuario;

  /**
   * Definimos Column para indicar que es una columna nombre.
   */

  @Column(name = "nombre")
  private String nombre;

  /**
   * Definimos Column para indicar que es una columna apellidos.
   */

  @Column(name = "apellidos")
  private String apellidos;

  /**
   * Definimos Column para indicar que es una columna telefono.
   */

  @Column(name = "telefono")
  private String telefono;

  /**
   * Definimos Column para indicar que es una columna direccion.
   */

  @Column(name = "direccion")
  private String direccion;

  /**
   * Definimos Column para indicar que es una columna email.
   */

  @Column(name = "email")
  private String email;

  /**
   * Definimos Column para indicar que es una columna password.
   */

  @Column(name = "password")
  private String password;

  /**
   * Definimos Column para indicar que es una columna rol.
   */

  @Column(name = "rol")
  private String rol;

  /**
   * Definimos un costructor vacio.
   */

  public Usuario() {

  }

  /**
   * Metodo get atributo privado nombre.
   */
  public final String getNombre() {
    return nombre;
  }

  /**
   * Metodo set atributo privado nombre.
   */
  public final void setNombre(final String nombre) {
    this.nombre = nombre;
  }

  /**
   * Metodo get atributo privado apellidos.
   */

  public final String getApellidos() {
    return apellidos;
  }

  /**
   * Metodo set atributo privado apellidos.
   */

  public final void setApellidos(final String apellidos) {
    this.apellidos = apellidos;
  }

  /**
   * Metodo get atributo privado telefono.
   */

  public final String getTelefono() {
    return telefono;
  }

  /**
   * Metodo set atributo privado telefono.
   */
  public final void setTelefono(final String telefono) {
    this.telefono = telefono;
  }

  /**
   * Metodo get atributo privado direccion.
   */

  public final String getDireccion() {
    return direccion;
  }

  /**
   * Metodo set atributo privado direccion.
   */

  public final void setDireccion(final String direccion) {
    this.direccion = direccion;
  }

  /**
   * Metodo get atributo privado email.
   */

  public final String getEmail() {
    return email;
  }

  /**
   * Metodo set atributo privado email.
   */
  public final void setEmail(final String email) {
    this.email = email;
  }

  /**
   * Metodo get atributo privado pasword.
   */

  public final String getPassword() {
    return password;
  }

  /**
   * Metodo set atributo privado password.
   */
  public final void setPassword(final String password) {
    this.password = password;
  }

  /**
   * Metodo get atributo privado id.
   */

  public final int getIdUsuario() {
    return idUsuario;
  }

  /**
   * Metodo set atributo privado id.
   */
  public final void setIdUsuario(final int idUsuario) {
    this.idUsuario = idUsuario;
  }

  /**
   * Metodo get atributo privado rol.
   */

  public final String getRol() {
    return rol;
  }

  /**
   * Metodo set atributo privado rol.
   */

  public final void setRol(final String rol) {
    this.rol = rol;
  }

}
