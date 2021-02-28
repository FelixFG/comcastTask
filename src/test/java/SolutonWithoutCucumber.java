import org.junit.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SolutonWithoutCucumber {
    public static void main(String[] args) {

        System.out.println("Enter the file path: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();

        path ="inputFile.csv";

        File inputFile = new File(path);

        Scanner fileReader = null;
        Scanner fileReader2 = null;

        try {
            fileReader = new Scanner(inputFile);
            Assert.assertTrue(inputFile.exists());
            System.out.println("SUCCESS: Input file exists\n");
            fileReader2 = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            System.out.println("File path is incorrect or file does not exist");

        }

        String header = fileReader.nextLine();
        int count = 0;
        String fruitName = "";
        Map<String, Integer> countMap = new HashMap<String, Integer>();
        int fruitCount =0;

        while (fileReader.hasNext() ) {
            String[] lineArray = fileReader.nextLine().split(",");
            //System.out.println(Arrays.toString(lineArray));
            fruitName = lineArray[0];

            while (fileReader2.hasNext()) {
                String[] lineArray2 = fileReader2.nextLine().split(",");
                //System.out.println(Arrays.toString(lineArray2));
                    if (fruitName.equals(lineArray2[0])) {
                        count++;
                        System.out.println(count +" in loop");
                    }
                    //fileReader2.nextLine();
            }
            if(!countMap.containsKey(lineArray[0])) {
                countMap.put(fruitName, count);
                fruitCount++;
            }
            count = 0;


            fileReader.reset();
            fileReader.nextLine();

        }
        System.out.println(countMap);




    }
}


