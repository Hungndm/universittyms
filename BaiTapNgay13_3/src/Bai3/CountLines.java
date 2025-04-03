package Bai3;

import java.io.*;

public class CountLines {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("keyboard_input.txt"))) {
            int lineCount = 0;
            while (reader.readLine() != null) {
                lineCount++;
            }
            System.out.println("Số dòng trong file: " + lineCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

