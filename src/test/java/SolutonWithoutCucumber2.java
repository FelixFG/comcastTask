import org.junit.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.nio.file.Files.lines;
import static java.util.stream.Collectors.toList;

public class SolutonWithoutCucumber2 {
    public static void main(String[] args) {

        System.out.println("Enter the file path: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();

       // path ="inputFile.csv";
        Path path2 = Paths.get(path);

        File inputFile = new File(path);

        Scanner fileReader = null;



        Set fruitset = new HashSet();

        Map<String, Integer> fruitMap = new HashMap<>();
        Map<String, Integer> fruitAgeMap = new HashMap<>();
        ArrayList<String> variousCharsList = new ArrayList<>() ;

        try {
            fileReader = new Scanner(inputFile);
            Assert.assertTrue(inputFile.exists());
            System.out.println("SUCCESS: Input file exists\n");

        } catch (FileNotFoundException e) {
            System.out.println("File path is incorrect or file does not exist");

        }
        String oldestFruit="";
        int oldestAge=0;
        try {
            List<String[]> lines = lines(path2).map(l -> l.split(","))
                    .collect(toList());
            for (int i =1 ; i<lines.size() ; i++    ) {
                fruitset.add(lines.get(i)[0]);
                fruitMap.put(lines.get(i)[0],0);
                if(Integer.parseInt(lines.get(i)[1])>oldestAge ){
                    oldestAge=Integer.parseInt(lines.get(i)[1]);
                }
                if(oldestAge!=1 && Integer.parseInt(lines.get(i)[1])==oldestAge){
                    fruitAgeMap.put(lines.get(i)[0],oldestAge);
                }

                     variousCharsList.add(lines.get(i)[0] +": "+lines.get(i)[2]+", " +lines.get(i)[3]);


            }
            List<String> fruitList = new ArrayList<>(fruitset);

            for (String each: fruitList  ) {
                //System.out.println(each);
                for (int i = 1; i < lines.size(); i++) {
                    if(each.equals(lines.get(i)[0])){
                        fruitMap.put(each,fruitMap.get(each)+1 );
                    }

                }
                //System.out.println(fruitMap);
            }

//            System.out.println(fruitset);
//            System.out.println(fruitMap);

        } catch (IOException e) {
            e.printStackTrace();
        }

        String output="";
        int totalFruit=0;
        for (Integer ints:fruitMap.values()  ) {
            totalFruit+=ints;
        }

String oldestFruitsAndAges="";
        for (String each  :fruitAgeMap.keySet()    ) {
            oldestFruitsAndAges+=""+each+": "+ fruitAgeMap.get(each)+"\n";
        }




        output = "Total number of fruit:\n"+
                totalFruit +"\n" +
                "\nTotal types of fruit:\n" + fruitMap.size() +"\n"+
                "\nOldest fruit & age:\n" + oldestFruitsAndAges
                + "\nThe number of each type of fruit in descending order:";
        System.out.println(output);
        for (String each:fruitMap.keySet()       ) {
            System.out.println(each + ": " + fruitMap.get(each));
        }


        Map<String, Integer> varCharMap = new HashMap<>();
        for (String each : variousCharsList            ) {
            int freq = Collections.frequency(variousCharsList,each);
            varCharMap.put(each,freq);
        }
        System.out.println("\nThe various characteristics (count, color, shape, etc.) of each fruit by type:");
        for (String each: varCharMap.keySet()        ) {

            System.out.println(varCharMap.get(each)+" "+each);
        }

        fileReader.close();

    }
}


