package cxf.rest.vehicles;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/car")
public class CarResource {

    String output;
    Double totalTax = 2.11;

    @GET
    public Response printTax() {
        try {
            output = "U$ " + totalTax;
            return Response.status(200).entity(output).build();
        } catch (Exception e) {
            return Response.status(400).build();
        }
    }

    @GET
    @Path("/payment/{value}")
    public Response payTax(@PathParam("value") Double payment){
        try {
            Double money = payment - totalTax;
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
