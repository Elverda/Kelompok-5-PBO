
public class Makanan extends MenuItem {
    public Makanan(String name, double price, int quantity, double discountRate) {
        super(name, price, quantity, discountRate, "Makanan");
    }

    @Override
    public double calculateTotalPrice(int amount) {
        double total = getPrice() * amount;
        double discount = total * getDiscountRate();
        if (amount > 5) {
            discount += total * 0.05;
        }
        return total - discount;
    }
}
