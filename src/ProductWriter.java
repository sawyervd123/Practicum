import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductWriter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> products = new ArrayList<>();

        System.out.println("Enter product records (leave ID blank to stop):");
        while (true) {
            System.out.print("Enter Product ID: ");
            String id = scanner.nextLine();
            if (id.isBlank()) break;

            System.out.print("Enter Product Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Product Description: ");
            String description = scanner.nextLine();

            System.out.print("Enter Product Cost: ");
            double cost = SafeInput.getDouble(scanner, "Product Cost");

            products.add(String.format("%s, %s, %s, %.2f", id, name, description, cost));
        }

        System.out.print("Enter file name to save: ");
        String fileName = scanner.nextLine();

        try (FileWriter writer = new FileWriter(fileName)) {
            for (String product : products) {
                writer.write(product + "\n");
            }
            System.out.println("Data saved successfully to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
