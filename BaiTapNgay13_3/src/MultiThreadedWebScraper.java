import org.jsoup.Jsoup;
import java.io.*;
import java.net.URL;
import java.nio.file.*;
import java.util.List;
import java.util.concurrent.*;

public class MultiThreadedWebScraper {
    private static final List<String> URL_LIST = List.of(
            "https://example.com/article1",
            "https://example.com/article2",
            "https://example.com/article3",
            "https://example.com/article4",
            "https://example.com/article5"
    );
    private static final String OUTPUT_DIR = "downloaded_files";
    private static final String MERGED_FILE = "merged_output.txt";

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Files.createDirectories(Paths.get(OUTPUT_DIR));

        for (int i = 0; i < URL_LIST.size(); i++) {
            String url = URL_LIST.get(i);
            String fileName = OUTPUT_DIR + "/file" + (i + 1) + ".txt";
            executor.submit(() -> downloadContent(url, fileName));
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.MINUTES); // Đợi tất cả task hoàn thành

        processAndMergeFiles();

        System.out.println("Hoàn thành! Nội dung hợp nhất lưu tại: " + MERGED_FILE);
    }

    private static void downloadContent(String url, String fileName) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
             BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println(" Tải xong: " + url);
        } catch (IOException e) {
            System.err.println("Lỗi tải file từ URL: " + url);
        }
    }

    private static void processAndMergeFiles() throws IOException {
        File mergedFile = new File(MERGED_FILE);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(mergedFile))) {
            File folder = new File(OUTPUT_DIR);
            File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));

            if (files != null) {
                for (File file : files) {
                    String cleanedContent = cleanHtmlContent(file);
                    writer.write(cleanedContent);
                    writer.newLine();
                }
            }
        }
    }

    private static String cleanHtmlContent(File file) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return Jsoup.parse(content.toString()).text(); 
    }
}
