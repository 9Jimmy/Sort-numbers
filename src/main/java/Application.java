import java.io.IOException;
import java.util.Scanner;

 class Application {
    public static void main(String[] args) {
        System.out.print("When you finish your work enter \'exit\'\n");

        Sorting sorting = new Sorting();
        Scanner scanner = new Scanner(System.in);

        boolean session = true;

        while (session) {
            System.out.print("============================================");
            System.out.print("\nEnter the path of text file you want to sort\n");
            String input = scanner.nextLine().replace("\\", "\\\\");

            try {
                sorting.sortingNumbers(input);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(input.equals("exit")){
                session = false;
            }
        }
    }
}