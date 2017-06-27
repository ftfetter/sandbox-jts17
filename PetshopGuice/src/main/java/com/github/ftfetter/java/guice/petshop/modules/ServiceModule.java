package com.github.ftfetter.java.guice.petshop.modules;

import com.github.ftfetter.java.guice.petshop.PetStoreService;
import com.github.ftfetter.java.guice.petshop.Services;
import com.github.ftfetter.java.guice.petshop.maps.*;
import com.google.inject.AbstractModule;

public class ServiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(MapPetInterface.class).to(MapPet.class);
        bind(MapPetServicesInterface.class).to(MapPetServices.class);
        bind(MapTopPetsInterface.class).to(MapTopPets.class);
        bind(Services.class).to(PetStoreService.class);
    }
}
