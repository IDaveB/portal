package com.portalapp.log;

import java.util.Properties;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Clase log.
 */
public class Log {

  /**
   * Creamos variable globar log.
   */

  static final Logger LOG = Logger.getLogger(Log.class);

  /**
   * Metodo de configuracion del log.
   * 
   * @param config
   * @throws ServletException
   */

  private void log() {
    try {
      Properties prop = new Properties();
      prop.load(this.getClass().getResourceAsStream("/log4j.properties"));
      PropertyConfigurator.configure(prop);
      LOG.trace("Contexto Servlet arrancado");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Metodo set.
   * 
   * @return
   */

  public Logger getLOG() {
    return LOG;
  }

}
