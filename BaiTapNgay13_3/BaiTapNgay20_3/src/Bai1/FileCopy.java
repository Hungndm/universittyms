package Bai1;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("input.txt");
             FileOutputStream fos = new FileOutputStream("output.txt")) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
            System.out.println("Copy file thành công!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

