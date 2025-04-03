import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.Callable;

class KeywordSearchTask implements Callable<Integer> {
    private final String filePath;
    private final String keyword;

    public KeywordSearchTask(String filePath, String keyword) {
        this.filePath = filePath;
        this.keyword = keyword;
    }

    @Override
    public Integer call() throws Exception {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                count += countOccurrences(line, keyword);
            }
        }
        System.out.println("File: " + filePath + " - Số lần xuất hiện: " + count);
        return count;
    }

    private int countOccurrences(String line, String keyword) {
        int index = 0, count = 0;
        while ((index = line.indexOf(keyword, index)) != -1) {
            count++;
            index += keyword.length();
        }
        return count;
    }
}
