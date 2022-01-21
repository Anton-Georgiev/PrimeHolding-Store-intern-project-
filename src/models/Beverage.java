package models;

public class Beverage extends PerishableProductImpl {
    public Beverage(String name, String brand, double price, String expirationDate) {
        super(name, brand, price, expirationDate);
    }
}
