package models;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Appliances extends ProductImpl {
    private String model;
    private String productionDate;
    private double weight;

    public Appliances(String name, String brand, double price, String model, String productionDate, double weight) {
        super(name, brand, price);
        setModel(model);
        setProductionDate(productionDate);
        setWeight(weight);
    }

    @Override
    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
        setDiscount();
    }

    protected void setDiscount() {
        DayOfWeek day = purchaseDate.getDayOfWeek();
        if (day.getValue() >= 6 && day.getValue() < 8 && getPrice() > 999) {
            super.discount = 0.95;
            super.hasDiscount = true;
        } else discount = 0.0;
    }

    public String getModel() {
        return model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    public String getProductionDate() {
        return productionDate;
    }

    private void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public double getWeight() {
        return weight;
    }

    private void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", getName(), getBrand(), getModel());
    }
}
