import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> persons = new ArrayList<>();

        System.out.println("Enter person records (leave ID blank to stop):");
        while (true) {
            System.out.print("Enter ID: ");
            String id = scanner.nextLine();
            if (id.isBlank()) break;

            System.out.print("Enter First Name: ");
            String firstName = scanner.nextLine();

            System.out.print("Enter Last Name: ");
            String lastName = scanner.nextLine();

            System.out.print("Enter Title: ");
            String title = scanner.nextLine();

            System.out.print("Enter Year of Birth: ");
            int yearOfBirth = SafeInput.getInt(scanner, "Year of Birth");

            persons.add(String.format("%s, %s, %s, %s, %d", id, firstName, lastName, title, yearOfBirth));
        }

        System.out.print("Enter file name to save: ");
        String fileName = scanner.nextLine();

        try (FileWriter writer = new FileWriter(fileName)) {
            for (String person : persons) {
                writer.write(person + "\n");
            }
            System.out.println("Data saved successfully to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
