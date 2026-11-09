import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Product[] products = new Product[10];
        int count = 0;

        int choice;

        do {
            System.out.println("\n--- Campus Cafe Inventory ---");
            System.out.println("1. Add product");
            System.out.println("2. Display all products");
            System.out.println("3. Total stock value");
            System.out.println("4. Average price");
            System.out.println("5. Restock a product");
            System.out.println("6. Duplicate a product");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            // making sure use enters numbers for choice

            while (!scanner.hasNextInt()) {

                String nextIntString = scanner.next();
                System.out.println(nextIntString + " Invalid choice, please try again selecting above options");

            }
            choice = scanner.nextInt();

            scanner.nextLine();

            if (choice < 0 || choice > 6) {
                System.out.println(choice + " is invalid selection, please select between 1 to 6");

            }

            switch (choice) {
                case 1:
                    // add new product
                    if (count == 10) {
                        System.out.println("Array is full!");
                        return;
                    }
                    System.out.println("Name:");
                    String name = scanner.nextLine();
                    double price;
                    int quantity;
                    // it will run till user gives valid inputs
                    do {
                        System.out.println("Price: ");
                        price = scanner.nextDouble();
                        System.out.println("Quantity: ");
                        quantity = scanner.nextInt();
                        scanner.nextLine();

                        if (price <= 0) {
                            System.err.println("Enter valid price (greater than zero)");
                        }
                        if (quantity < 0) {
                            System.out.println("Enter valid quantity (greater than zero)");
                        }
                    } while (price <= 0 || quantity < 0);

                    products[count++] = new Product(name, price, quantity);

                    break;
                case 2:
                    // display all product
                    if (count > 0) {
                        for (int i = 0; i < count; i++) {
                            products[i].display();
                        }

                    } else {
                        System.out.println("No products added yet");
                    }
                    break;
                case 3:
                    // Total stock value
                    // sum of all products ( product quantity * price)
                    double totalStock = 0;
                    for (int i = 0; i < count; i++) {
                        totalStock += products[i].stockValue();
                    }
                    System.out.println("Total stock value of products is " + totalStock);
                    break;
                case 4:
                    double sum = 0;
                    for (int i = 0; i < count; i++) {
                        sum += products[i].stockValue();
                    }
                    double avg = sum / count;
                    System.out.println("Average price " + avg);
                    System.out.println("Rounded down " + (int) avg);
                    break;
                case 5:
                    int num = 0;
                    int extra = 0;
                    do {
                        System.out.println("Product Number: ");
                        num = scanner.nextInt();

                        System.out.println("Quantity to add: ");
                        extra = scanner.nextInt();

                        if (count == 0) {
                            System.out.println("No products added yet, please add product first");
                        }
                        if (num < 1 || num > count) {
                            System.out.println("Please verify product number,it should be between 1 and " + count);
                        }
                        if (extra <= 0) {
                            System.out.println("quantity to add should be greater than zero");
                        }
                    } while (num < 1 || num > count || extra <= 0);

                    // all good till here

                    products[num - 1].setQuantity(products[num - 1].getQuantity() + extra);

                    break;
                case 6:
                    // duplicate a product

                    System.out.println("Product Number: ");
                    int n = scanner.nextInt();

                    if (count == products.length) {
                        System.out.println("Array is full!");
                        break;
                    }
                    if (n < 1 || n > count) {
                        System.out.println("Enter Valid product number");
                        break;
                    }
                    // all validations passed
                    Product copy = new Product(products[n - 1]);
                    copy.setName(copy.getName() + " (copy)");
                    products[count++] = copy;

                    break;
                case 0:
                    System.out.println("Good bye!");
            }
        } while (choice != 0);
    }

}
