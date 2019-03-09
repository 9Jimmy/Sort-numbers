import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class Sorting implements Serializable {
    public void sortingNumbers(String path) throws IOException {
        Set<Integer> set = new TreeSet<>();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while(line!=null){
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            for(String x : everything.split("\\s")){
                try{
                    set.add(Integer.parseInt(x));
                } catch (NumberFormatException e){
                    continue;
                }
            }
            System.out.print("Not sorted: ");
            System.out.println(everything);
            System.out.print("Sorted: ");
            System.out.println(set);

            try(FileWriter writer = new FileWriter(path, false)){
                writer.write("Before: " + everything + "\n");
                writer.write("After: " + set);
            }
        }
    }
}