package models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public abstract class PerishableProductImpl extends ProductImpl {
    private final LocalDate expirationDate;

    public PerishableProductImpl(String name, String brand, double price, String expirationDate) {
        super(name, brand, price);
        this.expirationDate = LocalDate.parse(expirationDate);
    }

    //discount to be multiplied for discountPrice.

    @Override
    public void setPurchaseDate(LocalDate date) {
        this.purchaseDate = date;
        setDiscount(findDifferenceInTime(this.expirationDate, purchaseDate));
    }

    protected void setDiscount(long daysToExpiration) {
        if (daysToExpiration > 0 && daysToExpiration <= 5) {
            super.discount = 0.95;
            super.hasDiscount = true;
        } else if (daysToExpiration == 0) {
            super.discount = 0.5;
            super.hasDiscount = true;
        }
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    private long findDifferenceInTime(LocalDate date, LocalDate purchaseDate) {
        return ChronoUnit.DAYS.between(date, purchaseDate);
    }

    @Override
    public String toString() {
        return String.format("%s %s", getName(), getBrand());
    }
}
