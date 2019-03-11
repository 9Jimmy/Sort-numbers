import java.io.*;
import java.util.Set;
import java.util.TreeSet;

class Sorting implements Serializable {

    int sortingNumbers(String path) throws IOException {
        Set<Integer> set = new TreeSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();

            boolean process = true;

            for (String x : everything.split("\\s")) {
                if (x.equals("-")) {
                    System.out.print("\nFile already sorted!\n");
                    process = false;
                }
                try {
                    set.add(Integer.parseInt(x));
                } catch (NumberFormatException e) {
                    continue;
                }
            }

            if(process==false){
                return 0;
            }

            System.out.print("\nNot sorted: ");
            System.out.println(everything);
            System.out.print("Sorted: ");
            System.out.println(set);

            try (FileWriter writer = new FileWriter(path, false)) {
                writer.write("-\nBefore: " + everything + "\n");
                writer.write("After: " + set);
            }
        }
        catch(FileNotFoundException e) {
            if (!path.equals("exit"))
                System.out.printf("\nFile at \'%s\' not found.\n", path);
        }
        return 0;
    }
}