package cxf.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

public interface TollService {

    @GET
    @Path("/bicycle")
    @Produces("text/plain")
    Response getBicycleTax();

    @GET
    @Path("/bicycle/payment/{value}")
    @Produces("text/plain")
    Response payBicycleTax(@PathParam("value") Double payment);

    @GET
    @Path("/bus")
    @Produces("text/plain")
    Response getBusTax();

    @GET
    @Path("/bus/payment/{value}")
    @Produces("text/plain")
    Response payBusTax(@PathParam("value") Double payment);


}
