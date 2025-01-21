import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ProductReader {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        System.out.println("Please select a product file to read.");

        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                System.out.printf("%-10s %-15s %-30s %-10s%n", "ID", "Name", "Description", "Cost");
                System.out.println("==============================================================");

                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(", ");
                    System.out.printf("%-10s %-15s %-30s %-10s%n", parts[0], parts[1], parts[2], parts[3]);
                }
            } catch (IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
            }
        } else {
            System.out.println("No file selected.");
        }
    }
}
