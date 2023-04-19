import java.util.Scanner;
import java.util.regex.Pattern;

public class StringComparison {
    // Function to count vowels and consonants in a string
    public static int[] countVowelsAndConsonants(String string) {
        int[] counts = { 0, 0 }; // index 0 for vowels, index 1 for consonants
        for (char c : string.toCharArray()) 
        {
            if (Pattern.matches("[aeiouAEIOU]", String.valueOf(c))) {
                counts[0]++;
            } else if (Pattern.matches("[a-zA-Z]", String.valueOf(c))) {
                counts[1]++;
            }
        }

        return counts;
    }

    // Main function to get user inputs and compare strings
    public static void compareStrings() {
        Scanner input = new Scanner(System.in);
        int numStrings = 0;
        while (true) {
            System.out.print("Enter the number of strings to compare (maximum 5): ");
            try {
                numStrings = Integer.parseInt(input.nextLine());
                if (numStrings < 2) {
                    System.out.println("Error: Please enter at least 2 strings to compare.");
                } else if (numStrings > 5) {
                    System.out.println("Error: Maximum number of strings to compare is 5.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter a number.");
            }

            input.close();
        }

        String[] strings = new String[numStrings];
        for (int i = 0; i < numStrings; i++) {
            System.out.print("Enter string " + (i + 1) + ": ");
            strings[i] = input.nextLine();
            if (!Pattern.matches("[a-zA-Z]+", strings[i])) {
                System.out.println("Error: Input must be a string.");
                return;
            }
        }

        System.out.print("Compare by 'Vowels' or 'Consonants'? ");
        String comparisonType = input.nextLine();
        if (comparisonType.equalsIgnoreCase("Vowels")) {
            for (int i = 0; i < numStrings; i++) {
                int[] counts = countVowelsAndConsonants(strings[i]);
                System.out.printf("String %s has : %d vowels\n", strings[i], counts[0]);
            }
        } else if (comparisonType.equalsIgnoreCase("Consonants")) {
            for (int i = 0; i < numStrings; i++) {
                int[] counts = countVowelsAndConsonants(strings[i]);
                System.out.printf("String %s has : %d consonants\n", strings[i], counts[1]);
            }
        } else {
            System.out.println("Error: Invalid comparison type. Please enter 'Vowels' or 'Consonants'.");
            return;
        }
    }

    public static void main(String[] args) {
        compareStrings(); //functions
    }
}
