package models;

import java.time.LocalDate;

public abstract class ProductImpl implements Product {
    private String name;
    private String brand;
    private double price;
    protected double discount;
    protected LocalDate purchaseDate;
    protected boolean hasDiscount = false;

    @Override
    public double getDiscountIndex() {
        return discount;
    }

    public ProductImpl(String name, String brand, double price) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        discount = 1.0;
    }

    @Override
    public boolean hasDiscount() {
        return hasDiscount;
    }

    @Override
    public double getPriceWithDiscount() {
        return price * discount;
    }

    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    private void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        this.price = price;
    }
}
