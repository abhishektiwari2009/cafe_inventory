
//Product.java
public class Product {
    String name;
    double price;
    int quantity;

    public static int totalProducts = 0;

    // default constructor
    public Product() {
        name = new String();
        price = 0;
        quantity = 0;
        totalProducts++;
    }

    // parametrized constructor
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        totalProducts++;
    }

    // copy constuctor

    public Product(Product other) {
        this.name = other.name;
        this.price = other.price;
        this.quantity = other.quantity;

        totalProducts++;
    }

    public double stockValue() {

        return this.price * this.quantity;
    }

    public void display() {
        System.out.println(this.name + " | RS " + this.price + " | qty " + this.quantity);

    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
