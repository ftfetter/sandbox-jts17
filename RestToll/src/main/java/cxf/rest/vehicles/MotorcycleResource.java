package cxf.rest.vehicles;

public class MotorcycleResource {

    String output;
    Double totalTax = 1d;

    public String printTax() {
        output = "U$ " + totalTax;
        return output;
    }

    public String payTax(Double payment){
        Double money = payment - totalTax;
        if (money < 0){
            output = "Insufficient money. U$ "+money;
        } else {
            output = "Up to pass. You must repay U$ "+money;
        }
        return output;
    }
}
