import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* This reader helper have three attribute:
    1. Title: for javafx stage title
    2. label: for the root (source) node
    3. a map that contains items and their values(double)
 */


public class SankeyReader {

    public String title;
    public String label;
    public Map<String, Double> data;
    // String + DOUBLE


    public SankeyReader(String fileName) {
        // Default Constructor
        data = new HashMap<>();
        readerHelper(fileName, false);
    }

    public SankeyReader(String fileName, boolean bool) {
        if (bool) {
            // Additional feature: ordered Map
            data = new LinkedHashMap<>();
        } else {
            // Unordered Map
            data = new HashMap<>();
        }
        readerHelper(fileName, bool);
    }


    public static void test() {
        SankeyReader myTable = new SankeyReader("D:\\Zhu22\\SynologyDrive\\1.2022_Year2\\4.JAVA\\CourseWork3\\data2.txt", true);
//        Table myTable = new Table("test.txt");
        System.out.println(myTable.title);
        System.out.println(myTable.label);
        for (String key : myTable.data.keySet()) {
            System.out.println(key + " " + myTable.data.get(key).toString());
        }
        System.out.println(myTable.returnSum());
    }

    public static void main(String[] args) {
        SankeyReader.test();
    }



    private void readerHelper(String fileName, boolean bool) {
        // when bool is true, put the data in an ordered Map. Vice versa

        File file = new File(fileName);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bf = new BufferedReader(fileReader);

            this.title = bf.readLine();
            this.label = bf.readLine();

            String line;
            while ((line = bf.readLine()) != null) {
                if (line.isEmpty()) {
                    System.out.println("Error: Empty line");
                    System.exit(1);
                }
                String key = returnKey(line);
                double val = returnVal(line);
                this.data.put(key, val);
            }

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            System.out.println("Error: no given file find");
            System.exit(1);
        }
    }





    public String returnKey(String str) {
        // A helper function for reader that extract the preferred key(string) in string line
        int n;
        for (n = 0; n < str.length(); n++) {
            if (str.charAt(n) >= 48 && str.charAt(n) <= 57) {
                if (str.substring(0, n).trim().isEmpty()) {
                    break;
                }
                return str.substring(0, n);
            }
        }
        System.out.println("Error: cannot find key from configuration");
        System.exit(1);
        return null;
    }

    public double returnVal(String str) {
        // A helper function for reader to return the value(double)

        try {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                    return Double.parseDouble(str.substring(i));
                }
            }
            System.out.println("Error: cannot find val from configuration");
            System.exit(1);
            return 0;
        } catch (NumberFormatException e) {
            System.out.println("Error: invalid input, invalid value");
            System.exit(1);
            return 0;
        }

    }

    public double returnSum() {
        // Return the sum of the values of each key
        double sum = 0;
        for (double size : this.data.values()) {
            sum += size;
        }
        return sum;
    }

}
