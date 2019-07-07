
package web.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import web.Bar;

/**
 *
 * @author nadine fakih
 */
@Stateless
@Path("web.bar")
public class BarFacadeREST extends AbstractFacade<Bar> {

    @PersistenceContext(unitName = "barServicesPU")
    private EntityManager em;

    public BarFacadeREST() {
        super(Bar.class);
    }
/*  GET Abfrage  mit der Umwandlung in entweder XML oder JSON*/
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Bar find(@PathParam("id") Integer id) {
        return super.find(id);
    }
/*  GET Abfrage  mit der Umwandlung in entweder XML oder JSON*/
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Bar> findAll() {
        return super.findAll();
    }



    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
