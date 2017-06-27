package com.github.ftfetter.java.spring4.calculator.operations;

import com.github.ftfetter.java.spring4.calculator.maps.MapHistory;
import com.github.ftfetter.java.spring4.calculator.maps.MapOperations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Calculator {

    private MapOperations mapOperations;
    private MapHistory mapHistory;

    @Autowired
    public Calculator (MapOperations mapOperations, MapHistory mapHistory){
        this.mapOperations = mapOperations;
        this.mapHistory = mapHistory;
    }

    public String calculate(double value1, double value2, String op) {
        String result;

        if (!validateOperantion(op)){
            result = value1 +" "+ op +" "+ value2 +" ERROR: Invalid operation";
            mapHistory.setHistory("error",result);
        } else {
            if (op == "/" && value2 == 0){
                result = value1 +" "+ op +" "+ value2 +" ERROR: Division by Zero";
            } else {
                result = mapOperations.getMapOperations().get(op).calculate(value1,value2);
            }
            mapHistory.setHistory(op,result);
        }

        return result;
    }

    public String printHistory(){
        String history;
        history = getOperationHistory("+").toString() +"\n"+
                getOperationHistory("-").toString() +"\n"+
                getOperationHistory("*").toString() +"\n"+
                getOperationHistory("/").toString() +"\n"+
                getOperationHistory("^").toString() +"\n"+
                getOperationHistory("error").toString();

        return history;
    }

    public List<String> getOperationHistory(String op){
        List<String> operationHistory = new ArrayList<>();

        for(String aux: mapHistory.getMapHistory().keySet())
            if (aux.contains(op))
                operationHistory = mapHistory.getMapHistory().get(aux);

        return operationHistory;
    }

    public boolean validateOperantion(String op){
        String operations = "+-*/^";
        return operations.contains(op);
    }

}
