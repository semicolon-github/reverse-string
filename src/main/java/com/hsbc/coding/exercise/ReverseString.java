package com.hsbc.coding.exercise;

import java.io.*;

public class ReverseString {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Please enter input and output file location");
            return;
        }

        ReverseString reverseString = new ReverseString();
        reverseString.reverseStringAndWriteToFile(args[0], args[1]);
    }

    public void reverseStringAndWriteToFile(String inputFilePath, String outputFilePath) {
        File inputFile = new File(inputFilePath);
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {
            String inputStr;
            while ((inputStr = br.readLine()) != null) {
                System.out.println("String to be reversed = " + inputStr);
                String reversedStr = reverseString(inputStr);
                bw.write(reversedStr);
            }
        } catch (IOException e) {
            System.err.println("Error in reading file");
            throw new RuntimeException(e);
        }
        System.out.println("Output written to output.txt successfully.");
    }

    public String reverseString(String input) {
        StringBuilder sb = new StringBuilder(input);
        String reversedStr = sb.reverse().toString();
        System.out.println("Reversed string = " + reversedStr);
        return reversedStr;
    }
}
