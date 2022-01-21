package models;

public class Food extends PerishableProductImpl {
    public Food(String name, String brand, double price, String expirationDate) {
        super(name, brand, price, expirationDate);
    }
}
