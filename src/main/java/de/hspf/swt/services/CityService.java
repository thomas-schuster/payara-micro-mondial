package de.hspf.swt.services;

import de.hspf.swt.beans.CityFacade;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ThomasSchuster
 */
@Path("/city")
@ApplicationScoped
public class CityService {
 
    @EJB
    CityFacade cityManager;
           
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/cities")
    public Response getAllCities() {
        return Response.status(Response.Status.OK)
                .entity(cityManager.findAll())
                .build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/name/{cityName}")
    public Response getCityByPath(@PathParam("cityName") String cityName) {
        return Response.status(Response.Status.OK)
                .entity(cityManager.findCityByName(cityName))
                .build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/name")
    public Response getCityByQuery(@QueryParam("name") String cityName) {
        return Response.status(Response.Status.OK)
                .entity(cityManager.findCityByName(cityName))
                .build();
    }
    
    
}
