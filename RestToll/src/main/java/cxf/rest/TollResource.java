package cxf.rest;

import cxf.rest.vehicles.BicycleResource;
import cxf.rest.vehicles.BusResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

@Service
@ApplicationPath("toll")
public class TollResource extends Application implements TollService{

    private BicycleResource bicycleRestService;
    private BusResource busRestService;

    @Autowired
    public TollResource(BicycleResource bicycleResource, BusResource busResource){
        bicycleRestService = bicycleResource;
        busRestService = busResource;
    }

    @Override
    public Response getBicycleTax() {
        Response.ResponseBuilder response = Response.ok(bicycleRestService.printTax());
        return response.build();
    }

    @Override
    public Response payBicycleTax(Double payment) {
        Response.ResponseBuilder response = Response.ok(bicycleRestService.payTax(payment));
        return response.build();
    }

    @Override
    public Response getBusTax() {
        Response.ResponseBuilder response = Response.ok(busRestService.printTax());
        return response.build();
    }

    @Override
    public Response payBusTax(Double payment) {
        Response.ResponseBuilder response = Response.ok(busRestService.payTax(payment));
        return response.build();
    }
}
