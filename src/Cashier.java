import models.Product;
import repositories.Cart;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Map;

public class Cashier {
    double subtotal;
    double discount;
    double total;

    public Cashier() {
        this.subtotal = 0;
        this.discount = 0;
        this.total = 0;
    }

    public void print(Cart cart, String purchaseDate) {
        StringBuilder sb = new StringBuilder();
        LocalDate date = LocalDate.parse(purchaseDate.split(" ")[0]);

        sb.append("Date: ").append(purchaseDate).append(System.lineSeparator());
        sb.append("---Products---").append(System.lineSeparator()).append(System.lineSeparator());

        Map<Product, Double> allProducts = cart.getCollection();

        for (Map.Entry<Product, Double> entry : allProducts.entrySet()) {
            Product product = entry.getKey();
            double quantity = entry.getValue();
            product.setPurchaseDate(date);

            double allProductPrice = product.getPrice() * quantity;
            subtotal += allProductPrice;

            sb.append(product).append(System.lineSeparator());
            sb.append(new DecimalFormat("####.##")
                    .format(quantity))
                    .append(" x $")
                    .append(new DecimalFormat("######.##").format(product.getPrice()))
                    .append(" = ")
                    .append("$")
                    .append(new DecimalFormat("######.##").format(allProductPrice))
                    .append(System.lineSeparator());

            if (product.hasDiscount()) {
                discount += allProductPrice - product.getPriceWithDiscount() * quantity;

                sb.append("#discount ")
                        .append(new DecimalFormat("####.##").format((1 - product.getDiscountIndex()) * 100))
                        .append("% ").append("-").append("$")
                        .append(new DecimalFormat("####.##").format(((product.getPrice() - product.getPriceWithDiscount()) * quantity)))
                        .append(System.lineSeparator());

            }
            sb.append(System.lineSeparator());
        }

        sb.append("-----------------------------------------------------------------------------------\n")
                .append("SUBTOTAL: $").append(new DecimalFormat("########.##").format(subtotal))
                .append(System.lineSeparator())
                .append("DISCOUNT: $-").append(new DecimalFormat("########.##").format(discount))
                .append(System.lineSeparator())
                .append(System.lineSeparator())
                .append("TOTAL: $").append(new DecimalFormat("#######.##").format(subtotal - discount));

        System.out.println(sb);
    }
}
