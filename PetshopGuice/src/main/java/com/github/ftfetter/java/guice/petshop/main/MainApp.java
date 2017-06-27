package com.github.ftfetter.java.guice.petshop.main;

import com.github.ftfetter.java.guice.petshop.PetStoreService;
import com.github.ftfetter.java.guice.petshop.Services;
import com.github.ftfetter.java.guice.petshop.modules.ServiceModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.List;

public class MainApp {

    public static void main (String[] args){
        Injector injector = Guice.createInjector(new ServiceModule());
        Services petStoreService = injector.getInstance(Services.class);

        petStoreService.addPet(1,"Dogge","Shiba", 3);
        petStoreService.addPet(2,"Catiorro","Akita", 3);
        petStoreService.addPet(3,"Pluto","Unknown",5);
        petStoreService.addPet(4,"Garibaldo","Yellow Bird",10);

        //Dogge Services
        petStoreService.doBath(1, 2);
        petStoreService.doHairCut(1, 1);
        //Pluto Services
        petStoreService.doBath(3,3);
        petStoreService.doHairCut(3,0);
        petStoreService.doBath(3,1);
        //Garibaldo Services
        petStoreService.doBath(4,2);
        petStoreService.doBath(4,0);

        System.out.println("");
        petStoreService.printServiceHistory();
        System.out.println("");
        petStoreService.printTopPets();
    }
}
