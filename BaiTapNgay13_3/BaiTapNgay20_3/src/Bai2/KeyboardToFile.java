package Bai2;

import java.io.*;

public class KeyboardToFile {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             FileWriter fw = new FileWriter("keyboard_input.txt")) {

            System.out.println("Nhập nội dung (nhập 'exit' để dừng):");
            String line;
            while (!(line = br.readLine()).equalsIgnoreCase("exit")) {
                fw.write(line + "\n");
            }
            System.out.println("Ghi dữ liệu thành công!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
