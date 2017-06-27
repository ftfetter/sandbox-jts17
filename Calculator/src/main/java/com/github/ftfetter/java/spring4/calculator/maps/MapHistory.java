package com.github.ftfetter.java.spring4.calculator.maps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapHistory {

    private Map<String,List<String>> mapHistory = new HashMap<>();

    public void setHistory(String op, String result){
        mapHistory.get(op).add(result);
    }

    public Map<String, List<String>> getMapHistory() {
        return mapHistory;
    }
}
