import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MultiThreadedKeywordSearch {
    public static void main(String[] args) throws Exception {
        String directoryPath = "files";
        String keyword = "Java";

        File folder = new File(directoryPath);
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));

        if (files == null || files.length == 0) {
            System.out.println("Không tìm thấy file nào trong thư mục.");
            return;
        }

        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<Future<Integer>> results = new ArrayList<>();

        for (File file : files) {
            KeywordSearchTask task = new KeywordSearchTask(file.getAbsolutePath(), keyword);
            results.add(executor.submit(task));
        }

        int totalOccurrences = 0;
        for (Future<Integer> result : results) {
            totalOccurrences += result.get();
        }

        executor.shutdown();
        System.out.println("Tổng số lần xuất hiện của '" + keyword + "': " + totalOccurrences);
    }
}
