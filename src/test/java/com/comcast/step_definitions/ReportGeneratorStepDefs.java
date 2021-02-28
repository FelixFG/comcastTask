package com.comcast.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReportGeneratorStepDefs {
    public File inputFile = null;


    @Given("User provides the path of the file")
    public void userProvidesThePathOfTheFile() {
        System.out.println("Enter the file path: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        path = "inputFile.csv";

        inputFile = new File(path);



    }

    @And("System Asserts the file exists and file structure matches")
    public void systemAssertsTheFileExistsAndFileStructureMatches() {

        Scanner fileReader = null;

            try {
                fileReader = new Scanner(inputFile);
                Assert.assertTrue(inputFile.exists());
                System.out.println("SUCCESS: Input file exists");
            } catch (FileNotFoundException e) {
                System.out.println("File path is incorrect or file does not exist");;
            }

            String header = fileReader.nextLine();
        System.out.println(header);



    }

    @Then("User receives a system generated report")
    public void userReceivesASystemGeneratedReport() {
    }
}
