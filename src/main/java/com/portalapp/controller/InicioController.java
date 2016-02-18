package com.portalapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador encargado de redirigirnos a la pagina principal del
 * proyecto(dentro de WEB-INF). Esto se hace por "seguridad" ya que el
 * directorio /WEB-INF/ es invisible para el usuario y es practicamente
 * IMPOSIBLE accesar a él desde una URL.
 */

@Controller
public class InicioController {

  /**
   * @param response
   * @param request
   * @return
   */

  @RequestMapping(value = "/inicio")
  public final String inicio(final HttpServletResponse response,
      final HttpServletRequest request) {

    return "login";
  }

}
