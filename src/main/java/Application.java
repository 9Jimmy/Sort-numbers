import java.io.IOException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Sorting sorting = new Sorting();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the path of text file you want to sort (use '\\\\' instead of '\\')");
        String path = scanner.nextLine();

        try {
            sorting.sortingNumbers(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}