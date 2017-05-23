package com.github.ftfetter.java.guice.petshop.modules;

import com.github.ftfetter.java.guice.petshop.PetStoreService;
import com.github.ftfetter.java.guice.petshop.Service;
import com.google.inject.AbstractModule;

public class ServiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Service.class).to(PetStoreService.class);
    }
}
