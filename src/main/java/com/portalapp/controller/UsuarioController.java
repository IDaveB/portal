package com.portalapp.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.portalapp.log.Log;
import com.portalapp.pojo.Usuario;
import com.portalapp.service.UsuarioService;

/**
 * Controlador encargado de escuchar las peticiones los usuarios.
 */

@Controller
public class UsuarioController {

  /**
   * Definimos inject.
   */
  @Inject
  UsuarioService usuarioService;

  /**
   * Definimos una variable global para la sesion.
   */

  HttpSession session;

  /**
   * Instanciamos log.
   */
  Log log = new Log();

  /**
   * Metodo que al logearse un usuario, comprobara que dicho usuario existe
   * mediante un email y una password. En caso de no existir nos redirigira a la
   * pagina del login, en caso de existir nos mandara al menu principal.
   */

  @RequestMapping(value = "/registro")
  public String entrar(final Usuario usuarioSession, final Model model,
      final HttpServletRequest request) throws Throwable {

    String result = "";

    try {

      /**
       * Comprobamos que el usuario exista en la bbdd con los parametros que nos
       * ha dado.
       */

      Usuario user = usuarioService.login(usuarioSession);

      if (user != null) {

        /**
         * Si existe lo metemos en una sesion.
         */

        session = request.getSession();
        session.setAttribute("userLoged", user);
        log.getLOG().info(
            "El usuario " + user.getNombre() + " " + user.getApellidos()
                + " ha iniciado sesion");

        /**
         * Recogemos todos los usuarios de bbdd y los metemos en una lista.
         */
        List<Usuario> listaUsuarios = usuarioService.listar((Usuario) session
            .getAttribute("userLoged"));

        /**
         * Metemos los usuarios en un model para mostrarlos enla jsp.
         */

        model.addAttribute("usuarios", listaUsuarios);

        /**
         * Comprobamos que sea administrador o usuario para mandarle a un lado o
         * a otro.
         */

        if (user.getRol().equalsIgnoreCase("administrador")) {

          result = "usuariosAdmin";
        } else {

          result = "usuarios";
        }

      } else {

        model.addAttribute("mensaje", "Email y password incorrectos");
        result = "login";

      }
    } catch (Exception e) {

      e.printStackTrace();
    }
    return result;
  }

  /**
   * Metodo al que llamamos cuando el usuario quiera registrarse.
   */

  @RequestMapping(value = "/registroUsuario")
  public final String registroUsuario() throws Throwable {

    return "registroUsuario";

  }

  /**
   * Metodo al que llamamos cuando el usuario quiera mandar los parametros de
   * registro.
   */

  @RequestMapping(value = "/registroUsuarioDatos")
  public final String registroUsuarioDatos(final Usuario usuario,
      final Model model, final HttpServletRequest request) throws Throwable {

    String res = "";

    /**
     * Creamos al usuario, lo metemos en sesion y lo mandamos al menu principal.
     */
    try {

      usuario.setRol("usuario");
      boolean comprobacion = usuarioService.add(usuario);

      if (comprobacion) {
        Usuario user = usuario;
        log.getLOG().info(
            "El usuario " + user.getNombre() + " " + user.getApellidos()
                + " se ha registrado e iniciado sesion");
        /**
         * Metemos al usuario en sesion.
         */

        session = request.getSession();
        session.setAttribute("userLoged", user);

        /**
         * Metemos el usuario en un model para mostrarlo enla jsp.
         */

        List<Usuario> listaUsuarios = usuarioService.listar((Usuario) session
            .getAttribute("userLoged"));

        model.addAttribute("usuarios", listaUsuarios);

        res = "usuarios";

      }

    } catch (Exception e) {
      model.addAttribute("mensaje", "El email introducido ya esta en uso");
      res = "registroUsuario";

    }

    return res;

  }

  /**
   * Metodo que lista todos los usuarios registrados.
   */

  @RequestMapping(value = "/menuUsuarios")
  public final String listarUsuarios(final Model model) throws Throwable {

    /**
     * Cogemos al usuario que se encuentra en sesion.
     */

    Usuario user = (Usuario) session.getAttribute("userLoged");

    /**
     * A continuacion cogemos a todos los usaurios menos al usuario en sesion.
     */
    List<Usuario> listaUsuarios = usuarioService.listar((Usuario) session
        .getAttribute("userLoged"));

    /**
     * Metemos los usuarios en un model para mostrarlos en la jsp.
     */

    model.addAttribute("usuarios", listaUsuarios);

    /**
     * Comprobamos que sea administrador o usuario para mandarle a un lado o a
     * otro.
     */

    if (user.getRol().equalsIgnoreCase("administrador")) {

      return "usuariosAdmin";

    } else {

      return "usuarios";

    }

  }

  /**
   * Metodo que visualizara el perfil del usuario con sus datos.
   */

  @RequestMapping(value = "/menuPerfil")
  public final String perfil(final Model model) throws Throwable {

    /**
     * Metemos el usuario en sesion para mostrarlo enla jsp.
     */

    model.addAttribute("usuario", session.getAttribute("userLoged"));

    return "perfilUsuario";

  }

  /**
   * Metodo para borrar al usuario elegido.
   */

  @RequestMapping(value = "/deleteUsuario")
  public final String delete(@RequestParam final int id, final Model model)
      throws Throwable {

    /**
     * Recupera el id del usuario que el administrador quiera borrar.
     */

    Usuario u = new Usuario();
    u.setIdUsuario(id);

    /**
     * Elimima el usuario.
     */

    Usuario user = (Usuario) session.getAttribute("userLoged");
    usuarioService.eliminar(u);

    log.getLOG().info(
        "El usuario " + user.getNombre() + " " + user.getApellidos()
            + " ha borrado a un registro");

    /**
     * Volvemos a recuperar los usuarios actualizados.
     */

    List<Usuario> listaUsuarios = usuarioService.listar((Usuario) session
        .getAttribute("userLoged"));

    /**
     * Metemos el usuario en un model para mostrarlo enla jsp.
     */

    model.addAttribute("usuarios", listaUsuarios);
    model.addAttribute("mensaje", "Registro borrado con exito");

    return "usuariosAdmin";

  }

  /**
   * Metodo que recupera los parametros mandados por el usuario cuando desee
   * actualizar los datos de su perfil.
   */

  @RequestMapping(value = "/updateUsuario")
  public final String update(final Usuario usuario, final Model model)
      throws Throwable {

    /**
     * Recuperamos al usaurio en sesion.
     */

    Usuario user = (Usuario) session.getAttribute("userLoged");

    /**
     * Creamos un objeto usuario y por un lado metemos los parametro mandados
     * desde la jsp y los atributos que no puede modificar por su cuenta ej: id,
     * dni, rol...
     */

    usuario.setIdUsuario(user.getIdUsuario());
    usuario.setPassword(user.getPassword());
    usuario.setRol(user.getRol());
    /**
     * Actualizamos al usuarios mediante el dao.
     */
    try {
      usuarioService.editar(usuario);
      session.setAttribute("userLoged", usuario);
      log.getLOG().info(
          "El usuario " + user.getNombre() + " " + user.getApellidos()
              + "ha modificado su perfil ");
    } catch (Exception e) {

      List<Usuario> listaUsuarios = usuarioService.listar((Usuario) session
          .getAttribute("userLoged"));
      model.addAttribute("usuarios", listaUsuarios);

      model.addAttribute("mensaje",
          "Imposible modificar sus datos, introduzca un email sin utilizar");

      if (user.getRol().equalsIgnoreCase("administrador")) {

        return "usuariosAdmin";

      } else {

        return "usuarios";
      }

    }

    /**
     * A continuacion cogemos a todos los usaurios menos al usuario en sesion.
     */
    List<Usuario> listaUsuarios = usuarioService.listar((Usuario) session
        .getAttribute("userLoged"));

    /**
     * Metemos los usuarios en un model para mostrarlos en la jsp.
     */

    model.addAttribute("usuarios", listaUsuarios);

    model.addAttribute("mensaje", "Registro modificado con exito");

    /**
     * Comprobamos que sea administrador o usuario para mandarle a un lado o a
     * otro.
     */

    if (user.getRol().equalsIgnoreCase("administrador")) {

      return "usuariosAdmin";

    } else {

      return "usuarios";
    }

  }

  /**
   * Metodo que al salir de la aplicacion, cierre la sesion y te mande al login.
   */

  @RequestMapping(value = "/menuSalir")
  public final String salir(final Model model) throws Throwable {

    Usuario user = (Usuario) session.getAttribute("userLoged");

    log.getLOG().info(
        "El usuario " + user.getNombre() + " " + user.getApellidos()
            + " ha cerrado sesion ");

    session.invalidate();

    return "redirect:/inicio";

  }

}
