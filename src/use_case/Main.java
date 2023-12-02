
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        boolean endprogram = false;
        Scanner scanner = new Scanner(System.in);
        while (!endprogram) {
            System.out.println("Find recipe? (yes/no):");
            System.out.print("\t>> ");
            String command = scanner.nextLine();
            System.out.println();
            if (command.equalsIgnoreCase("yes")) {
                //GetInput.searchRecipes(scanner);
            } else {
                endprogram = true;
            }
        }
        System.out.println("Thank you for using this App");
        System.out.println();
        scanner.close();
    }
}
