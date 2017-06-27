package com.ilegra.jts.spring.calculator.maps;

import com.ilegra.jts.spring.calculator.operations.Operations;

import java.util.HashMap;
import java.util.Map;

public class MapOperations {

    private Map<String,Operations> mapOperations = new HashMap<>();

    public Map<String, Operations> getMapOperations() {
        return mapOperations;
    }


}
