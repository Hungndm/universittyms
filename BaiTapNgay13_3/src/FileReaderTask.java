import java.io.RandomAccessFile;
import java.util.concurrent.Callable;

class FileReaderTask implements Callable<byte[]> {
    private final String filePath;
    private final long start;
    private final int size;

    public FileReaderTask(String filePath, long start, int size) {
        this.filePath = filePath;
        this.start = start;
        this.size = size;
    }

    @Override
    public byte[] call() throws Exception {
        RandomAccessFile file = new RandomAccessFile(filePath, "r");
        byte[] buffer = new byte[size];
        file.seek(start);
        file.read(buffer);
        file.close();
        return buffer;
    }
}

