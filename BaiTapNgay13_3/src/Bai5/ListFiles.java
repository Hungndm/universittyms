package Bai5;

import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        String directoryPath = "."; // Đặt thư mục cần kiểm tra

        File directory = new File(directoryPath);
        if (directory.exists() && directory.isDirectory()) {
            String[] files = directory.list();
            if (files != null) {
                System.out.println("Các file trong thư mục:");
                for (String file : files) {
                    System.out.println(file);
                }
            }
        } else {
            System.out.println("Đường dẫn không hợp lệ.");
        }
    }
}
