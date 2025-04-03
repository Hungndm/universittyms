import java.io.*;

public class MergeDownloadedFiles {
    private static final String INPUT_DIR = "downloaded_files";
    private static final String OUTPUT_FILE = "merged_output.txt";

    public static void main(String[] args) {
        File folder = new File(INPUT_DIR);
        File[] files = folder.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("Không có file nào để gộp.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
            for (File file : files) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        writer.write(line);
                        writer.newLine();
                    }
                }
                writer.write("\n---\n");
            }
            System.out.println("Gộp file hoàn tất: " + OUTPUT_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
