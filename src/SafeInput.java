import java.util.Scanner;

public class SafeInput {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static int getInt(String prompt) {
        int result = 0;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print(prompt);
                result = Integer.parseInt(scanner.nextLine());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
        return result;
    }

    public static boolean getBoolean(String prompt) {
        boolean result = false;
        boolean valid = false;
        while (!valid) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("true") || input.equals("false")) {
                result = Boolean.parseBoolean(input);
                valid = true;
            } else {
                System.out.println("Invalid input. Please enter true or false.");
            }
        }
        return result;
    }
}