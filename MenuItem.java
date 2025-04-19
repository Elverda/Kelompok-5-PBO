
public class MenuItem {
    private String name;
    private double price;
    private int quantity;
    private double discountRate;
    private String category;

    public MenuItem(String name, double price, int quantity, double discountRate, String category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.discountRate = discountRate;
        this.category = category;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getDiscountRate() { return discountRate; }
    public void setDiscountRate(double discountRate) { this.discountRate = discountRate; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double calculateTotalPrice(int amount) {
        double total = price * amount;
        double discount = total * discountRate;
        return total - discount;
    }

    public boolean reduceStock(int amount) {
        if (amount > 0 && amount <= quantity) {
            quantity -= amount;
            return true;
        }
        return false;
    }
}
