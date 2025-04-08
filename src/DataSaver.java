import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataSaver {
    public static void main(String[] args) {
        ArrayList<String> records = new ArrayList<>();
        boolean moreRecords = true;
        int idCounter = 1;

        while (moreRecords) {
            String firstName = SafeInput.getString("Enter first name:");
            String lastName = SafeInput.getString("Enter last name:");
            String idNumber = String.format("%06d", idCounter++);
            String email = SafeInput.getString("Enter email:");
            int birthYear = SafeInput.getInt("Enter year of birth:");

            String record = String.join(", ", firstName, lastName, idNumber, email, String.valueOf(birthYear));
            records.add(record);

            moreRecords = SafeInput.getBoolean("Do you want to add another record? (true/false):");
        }

        String fileName = SafeInput.getString("Enter the file name (with .csv extension):");

        try (FileWriter writer = new FileWriter("src/" + fileName)) {
            for (String record : records) {
                writer.write(record + "\n");
            }
            System.out.println("Data saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}