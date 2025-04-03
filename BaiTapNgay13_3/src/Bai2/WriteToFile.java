package Bai2;

import java.io.*;

public class WriteToFile {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter("keyboard_input.txt")) {

            System.out.println("Nhập nội dung vào file (gõ 'exit' để dừng):");
            String line;
            while (!(line = reader.readLine()).equalsIgnoreCase("exit")) {
                writer.write(line + "\n");
            }
            System.out.println("Dữ liệu đã được lưu vào file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

