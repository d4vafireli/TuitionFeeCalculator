import java.util.Scanner;

public class TuitionManagerFee {

    //calculator
    public static double calculateTotalFee(boolean isMathSelected, boolean isEnglishSelected, boolean isScienceSelected, boolean isHistory, boolean isGeography) {
        double totalFee = 0.0;

        // adds on total fees based on selected subjects
        if (isMathSelected) totalFee += 200.0;
        if (isEnglishSelected) totalFee += 150.0;
        if (isScienceSelected) totalFee += 250.0;
        if (isHistory) totalFee += 100.0;
        if (isGeography) totalFee += 120.0;

        // return total fee
        return totalFee;
    }

    // get user's subject
    public static boolean getSubjectSelection(Scanner scanner, String subjectName) {
        while (true) {
            System.out.print("Do you want to enroll in " + subjectName + "? (yes/no): ");
            String userResponse = scanner.nextLine().toLowerCase();
            
            if (null == userResponse) // if user did not enter any input
            System.out.println("Error: Please respond with 'yes' or 'no'.");
            
            else switch (userResponse) {
                case "yes" : { // if yes, return true value
                    return true;
                }
                case "no" : { // if no, return false value
                    return false;
                }
                default : System.out.println("Error: Please respond with 'yes' or 'no'."); // if user input other than (yes / no)
            }
        }
    }

    // receipt
    public static void printReceipt(boolean isMathSelected, boolean isEnglishSelected, boolean isScienceSelected, boolean isHistorySelected, boolean isGeographySelected, double totalFee) {
        
        // header
        System.out.println("=============================================");
        System.out.println("|                  RECEIPT                  |");
        System.out.println("=============================================");
        System.out.println("SUBJECTS ENROLLED:");
        System.out.println("=============================================");
        System.out.println("|   SUBJECT     |   FEE                     |");
        System.out.println("=============================================");

        // print each subject's line of receipt if selected
        if (isMathSelected) System.out.println("|   MATH        |   $200.00                 |");
        if (isEnglishSelected) System.out.println("|   ENGLISH     |   $150.00                 |");
        if (isScienceSelected) System.out.println("|   SCIENCE     |   $250.00                 |");
        if (isHistorySelected) System.out.println("|   HISTORY     |   $100.00                 |");
        if (isGeographySelected) System.out.println("|   GEOGRAPHY   |   $120.00                 |");

        // print's subtotal based on the calculated total fee
        System.out.println("=============================================");
        System.out.printf("|   SUBTOTAL:   |   $%-23.2f|\n", totalFee);
        System.out.println("=============================================");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // display title, subject name and their prices
        System.out.println("=============================================");
        System.out.println("|           TUITION FEE CALCULATOR          |");
        System.out.println("=============================================");
        System.out.println("AVAILABLE SUBJECTS AND FEES:");
        System.out.println("=============================================");
        System.out.println("|   MATH        |   $200.00                 |");
        System.out.println("|   ENGLISH     |   $150.00                 |");
        System.out.println("|   SCIENCE     |   $250.00                 |");
        System.out.println("|   HISTORY     |   $100.00                 |");
        System.out.println("|   GEOGRAPHY   |   $120.00                 |");
        System.out.println("=============================================\n");

        // get user's selection of subjects
        boolean isMathSelected = getSubjectSelection(scanner, "Math");
        boolean isEnglishSelected = getSubjectSelection(scanner, "English");
        boolean isScienceSelected = getSubjectSelection(scanner, "Science");
        boolean isHistorySelected = getSubjectSelection(scanner, "History");
        boolean isGeographySelected = getSubjectSelection(scanner, "Geography");

        // calculate total fee and print receipt
        double totalFee = calculateTotalFee(isMathSelected, isEnglishSelected, isScienceSelected, isHistorySelected, isGeographySelected);
        
        //prints receipt
        printReceipt(isMathSelected, isEnglishSelected, isScienceSelected, isHistorySelected, isGeographySelected, totalFee);
    }
}
