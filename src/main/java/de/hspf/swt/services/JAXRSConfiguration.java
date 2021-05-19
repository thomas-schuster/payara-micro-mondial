package de.hspf.swt.services;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Configures JAX-RS for the application.
 * 
 */
@ApplicationPath("/resources")
@ApplicationScoped
public class JAXRSConfiguration extends Application {
    
}
