package models;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Clothes extends ProductImpl {
    private char size;
    private String color;

    public Clothes(String name, String brand, double price, char size, String color) {
        super(name, brand, price);
        setSize(size);
        setColor(color);

    }

    protected void setDiscount() {
        DayOfWeek day = super.purchaseDate.getDayOfWeek();
        if (day.getValue() < 6) {
            super.discount = 0.9;
            super.hasDiscount = true;
        } else super.discount = 0.0;
    }

    @Override
    public void setPurchaseDate(LocalDate PurchaseDate) {
        this.purchaseDate = PurchaseDate;
        setDiscount();
    }

    public char getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    private void setColor(String color) {
        this.color = color;
    }

    private void setSize(char size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", getName(), getBrand(), getSize(), getColor());
    }
}
