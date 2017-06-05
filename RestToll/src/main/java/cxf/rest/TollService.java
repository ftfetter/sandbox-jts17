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

    @GET
    @Path("/car")
    @Produces("text/plain")
    Response getCarTax();

    @GET
    @Path("/car/payment/{value}")
    @Produces("text/plain")
    Response payCarTax(@PathParam("value") Double payment);

    @GET
    @Path("/motorcycle")
    @Produces("text/plain")
    Response getMotorcycleTax();

    @GET
    @Path("/motorcycle/payment/{value}")
    @Produces("text/plain")
    Response payMotorcycleTax(@PathParam("value") Double payment);

    @GET
    @Path("/truck/axis/{axis}")
    @Produces("text/plain")
    Response getTruckTax(@PathParam("axis") int axis);

    @GET
    @Path("/truck/axis/{axis}/payment/{value}")
    @Produces("text/plain")
    Response payTruckTax(@PathParam("axis") int axis, @PathParam("value") Double payment);
}
