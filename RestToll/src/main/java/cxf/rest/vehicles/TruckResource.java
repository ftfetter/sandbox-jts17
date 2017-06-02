package cxf.rest.vehicles;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/truck")
public class TruckResource {

    Double totalTax = 3.95;
    String output;

    @GET
    @Path("/axis/{axis}")
    public Response printTax(@PathParam("axis") int extraAxis) {
        try {
            output = "U$ " + (totalTax + (1*extraAxis));
            return Response.status(200).entity(output).build();
        } catch (Exception e) {
            return Response.status(400).build();
        }
    }

    @GET
    @Path("/axis/{axis}/payment/{value}")
    public Response payTax(@PathParam("axis") int extraAxis, @PathParam("value") Double payment){
        try {
            Double money = payment - (totalTax + (1*extraAxis));
            if (money < 0){
                output = "Insufficient money. U$ "+money;
            } else {
                output = "Up to pass. You must repay U$ "+money;
            }
            return Response.status(200).entity(output).build();
        } catch (Exception e) {
            return Response.status(400).build();
        }
    }
}
