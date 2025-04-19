
public class Minuman extends MenuItem {
    public Minuman(String name, double price, int quantity, double discountRate) {
        super(name, price, quantity, discountRate, "Minuman");
    }

    @Override
    public double calculateTotalPrice(int amount) {
        double total = getPrice() * amount;
        return total - (total * getDiscountRate());
    }
}
