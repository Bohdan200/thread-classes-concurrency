package concurrency.multisearcher;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MultiThreadSearcherTests {
    public static void main(String[] args) throws InterruptedException, IOException {
        String path = "./src";

        long start = System.currentTimeMillis();
        List<File> result = new MultiThreadSearcher().search(path, "first");
        long duration = System.currentTimeMillis() - start;

        System.out.println("duration = " + duration + " ms");
        System.out.println("Found: " + result.size());

        for (File file : result) {
            System.out.println("file.getCanonicalPath() = " + file.getCanonicalPath());
        }
    }
}
