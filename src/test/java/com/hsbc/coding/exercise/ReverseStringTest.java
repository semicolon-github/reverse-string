package com.hsbc.coding.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class ReverseStringTest {

    ReverseString reverseString;

    @BeforeEach
    void init() {
        reverseString = new ReverseString();
    }

    @Test
    void reverseStringAndWriteToFile() {
        String inputFilePath = "D:\\Jayesh\\Learning_Workspace\\reverse-string\\src\\test\\resources\\input.txt";
        String outputFilePath = "D:\\Jayesh\\Learning_Workspace\\reverse-string\\src\\test\\resources\\output.txt";
        reverseString.reverseStringAndWriteToFile(inputFilePath, outputFilePath);
        File outputFile = new File(outputFilePath);
        assertNotNull(outputFile);
    }


    @ParameterizedTest
    @ValueSource(strings = {"D:\\Jayesh\\Learning_Workspace\\reverse-string\\src\\test\\resources\\absent_input.txt"})
    void test_errorInputFile(String inputFile) {
        assertThrows(RuntimeException.class, () -> reverseString.reverseStringAndWriteToFile(inputFile, null));
    }

    @Test
    void reverseString_Success() {
        String expected = "CBA";
        String actual = reverseString.reverseString("ABC");
        assertEquals(actual, expected, "String should be reversed");
    }

    @Test
    void reverseString_Failure() {
        String expected = "CAA";
        String inputStr = "ABC";
        String actual = reverseString.reverseString(inputStr);
        assertNotEquals(actual, expected, "String should be reversed");
    }
}