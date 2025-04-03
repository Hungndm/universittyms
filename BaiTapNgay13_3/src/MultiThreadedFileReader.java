import java.io.*;
import java.util.concurrent.*;

public class MultiThreadedFileReader {
    private static final int CHUNK_SIZE = 1024 * 1024;

    public static void main(String[] args) throws Exception {
        String inputFile = "large_file.txt";
        String outputFile = "output_file.txt";
        File file = new File(inputFile);
        long fileSize = file.length();
        int numChunks = (int) Math.ceil((double) fileSize / CHUNK_SIZE);

        ExecutorService executor = Executors.newFixedThreadPool(4);
        Future<byte[]>[] results = new Future[numChunks];

        for (int i = 0; i < numChunks; i++) {
            long start = (long) i * CHUNK_SIZE;
            int size = (int) Math.min(CHUNK_SIZE, fileSize - start);
            results[i] = executor.submit(new FileReaderTask(inputFile, start, size));
        }

        try (FileOutputStream fos = new FileOutputStream(outputFile)) {
            for (Future<byte[]> result : results) {
                fos.write(result.get());
            }
        }

        executor.shutdown();
        System.out.println("File đọc xong và đã ghi vào: " + outputFile);
    }
}
