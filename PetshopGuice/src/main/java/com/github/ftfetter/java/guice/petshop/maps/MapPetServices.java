package com.github.ftfetter.java.guice.petshop.maps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapPetServices implements MapPetServicesInterface {

    Map<String,List<String>> mapPetServices;

    public MapPetServices(){
        mapPetServices = new HashMap<>();
    }

    @Override
    public Map<String, List<String>> getMapPetServices() {
        return mapPetServices;
    }
}
