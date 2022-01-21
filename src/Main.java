import models.*;
import repositories.Cart;

public class Main {

    public static void main(String[] args) {
        //creating cashier and cart objects:
        Cashier cashier = new Cashier();
        Cart cart = new Cart();

        //creating products:
        Product apple = new Food("apple", "Brand A", 1.50, "2021-06-14");
        Product milk = new Beverage("milk", "BrandM", 0.99, "2022-02-02");
        Product tShirt = new Clothes("T-shirt", "BrandT", 15.99, 'M', "violet");
        Product laptop = new Appliances("laptop", "BrandL", 2345, "ModelL", "2021-03-03", 1.125);

        //adding products to cart:
        cart.add(apple, 2.45);
        cart.add(milk, 3.0);
        cart.add(tShirt, 2.0);
        cart.add(laptop, 1.0);

        //printing output:
        cashier.print(cart, "2021-06-14 12:34:56");

    }

}

