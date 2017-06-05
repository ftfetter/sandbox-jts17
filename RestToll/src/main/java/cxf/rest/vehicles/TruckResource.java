package cxf.rest.vehicles;

public class TruckResource {

    Double totalTax = 3.95;
    String output;

    public String printTax(int extraAxis) {
        output = "U$ " + (totalTax + (1*extraAxis));
        return output;
    }

    public String payTax(int extraAxis, Double payment){
        Double money = payment - (totalTax + (1*extraAxis));
        if (money < 0){
            output = "Insufficient money. U$ "+money;
        } else {
            output = "Up to pass. You must repay U$ "+money;
        }
        return output;
    }
}
