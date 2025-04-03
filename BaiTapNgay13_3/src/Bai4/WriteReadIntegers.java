package Bai4;

import java.io.*;

public class WriteReadIntegers {
    public static void main(String[] args) {
        String fileName = "number.dat";


        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            int[] numbers = {10, 20, 30, 40, 50};
            for (int num : numbers) {
                dos.writeInt(num);
            }
            System.out.println("Dữ liệu đã được ghi vào file.");
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            System.out.println("Các số nguyên đọc từ file:");
            while (dis.available() > 0) {
                System.out.print(dis.readInt() + " ");
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
