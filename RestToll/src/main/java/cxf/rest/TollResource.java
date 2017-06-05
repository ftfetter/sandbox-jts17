package cxf.rest;

import cxf.rest.vehicles.*;
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
    private CarResource carRestService;
    private MotorcycleResource motorcycleRestService;
    private TruckResource truckRestService;
    private Response.ResponseBuilder response;

    @Autowired
    public TollResource(BicycleResource bicycleResource, BusResource busResource, CarResource carResource, MotorcycleResource motorcycleResource, TruckResource truckResource){
        bicycleRestService = bicycleResource;
        busRestService = busResource;
        carRestService = carResource;
        motorcycleRestService = motorcycleResource;
        truckRestService = truckResource;
    }

    @Override
    public Response getBicycleTax() {
        try {
            response = Response.ok(bicycleRestService.printTax());
        } catch(Exception e) {
            response = Response.serverError();
        }
        return response.build();
    }

    @Override
    public Response payBicycleTax(Double payment) {
        try {
            response = Response.ok(bicycleRestService.payTax(payment));
        } catch(Exception e) {
            response = Response.serverError();
        }
        return response.build();
    }

    @Override
    public Response getBusTax() {
        try {
            response = Response.ok(busRestService.printTax());
        } catch(Exception e) {
            response = Response.serverError();
        }
        return response.build();
    }

    @Override
    public Response payBusTax(Double payment) {
        try {
            response = Response.ok(busRestService.payTax(payment));
        } catch(Exception e) {
            response = Response.serverError();
        }
        return response.build();
    }

    @Override
    public Response getCarTax() {
        try {
            response = Response.ok(carRestService.printTax());
        } catch(Exception e) {
            response = Response.serverError();
        }
        return response.build();
    }

    @Override
    public Response payCarTax(Double payment) {
        try {
            response = Response.ok(carRestService.payTax(payment));
        } catch(Exception e) {
            response = Response.serverError();
        }
        return response.build();
    }

    @Override
    public Response getMotorcycleTax() {
        try {
            response = Response.ok(motorcycleRestService.printTax());
        } catch(Exception e) {
            response = Response.serverError();
        }
        return response.build();
    }

    @Override
    public Response payMotorcycleTax(Double payment) {
        try {
            response = Response.ok(motorcycleRestService.payTax(payment));
        } catch(Exception e) {
            response = Response.serverError();
        }
        return response.build();
    }

    @Override
    public Response getTruckTax(int axis) {
        try {
            response = Response.ok(truckRestService.printTax(axis));
        } catch(Exception e) {
            response = Response.serverError();
        }
        return response.build();
    }

    @Override
    public Response payTruckTax(int axis, Double payment) {
        try {
            response = Response.ok(truckRestService.payTax(axis, payment));
        } catch(Exception e) {
            response = Response.serverError();
        }
        return response.build();
    }
}
