package de.hspf.swt.beans;

import de.hspf.swt.dao.City;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ThomasSchuster
 */
@Stateless
public class CityFacade extends AbstractFacade<City> {

    @PersistenceContext(unitName = "mondial")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CityFacade() {
        super(City.class);
    }
    
    public List findCityByName(String name){
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("name", name);
        return findByNamedQuery("City.findByName", map);
        
    }
}
