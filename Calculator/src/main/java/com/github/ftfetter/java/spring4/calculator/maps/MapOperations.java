package com.github.ftfetter.java.spring4.calculator.maps;

import com.github.ftfetter.java.spring4.calculator.operations.Operations;

import java.util.HashMap;
import java.util.Map;

public class MapOperations {

    private Map<String,Operations> mapOperations = new HashMap<>();

    public Map<String, Operations> getMapOperations() {
        return mapOperations;
    }


}
