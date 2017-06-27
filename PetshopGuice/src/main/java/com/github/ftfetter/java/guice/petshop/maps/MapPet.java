package com.github.ftfetter.java.guice.petshop.maps;

import com.github.ftfetter.java.guice.petshop.Pet;

import java.util.HashMap;
import java.util.Map;

public class MapPet implements MapPetInterface{

    Map<Integer, Pet> mapPet = new HashMap<>();

    @Override
    public Map<Integer, Pet> getMapPet() {
        return mapPet;
    }
}
