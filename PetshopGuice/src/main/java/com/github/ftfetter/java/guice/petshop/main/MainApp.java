package com.github.ftfetter.java.guice.petshop.main;

import com.github.ftfetter.java.guice.petshop.PetStoreService;
import com.github.ftfetter.java.guice.petshop.modules.ServiceModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class MainApp {

    public static void main (String[] args){
        Injector injector = Guice.createInjector(new ServiceModule());
        PetStoreService petStoreService = injector.getInstance(PetStoreService.class);

        if(petStoreService.addPet(1,"Dogge","Shiba", 3)){
            System.out.println(petStoreService.searchByAge(3).get(0).getName());
        }
    }
}
