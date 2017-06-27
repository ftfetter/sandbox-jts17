package com.github.ftfetter.java.guice.petshop.maps;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapTopPets implements MapTopPetsInterface {

    private Map<Integer, List<String>> mapTopPets = new TreeMap<>(Collections.reverseOrder());

    @Override
    public Map<Integer, List<String>> getMapTopPets() {
        return mapTopPets;
    }
}
