package models;

import java.time.LocalDate;

public interface Product {
    String getName();

    String getBrand();

    double getPrice();

    double getPriceWithDiscount();

    void setPurchaseDate(LocalDate date);

    boolean hasDiscount();

    double getDiscountIndex();

}
