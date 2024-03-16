package concurrency.multisearcher;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiThreadSearcher {
    public List<File> search(String path, String search) throws InterruptedException {
        ExecutorService executors = Executors.newFixedThreadPool(10);

        List<File> files = new FileCollector().getFiles(path);
        System.out.println("Search in files: " + files.size());

        List<File> result = new CopyOnWriteArrayList<>();
        List<Future<?>> futures = new ArrayList<>();

        for (File file : files) {
            Future<?> future = executors.submit(() ->
                    new FileSearcher().search(file, search, result)
            );
            futures.add(future);
        }

        while (true) {
            boolean searchFinished = futures.stream().allMatch(Future::isDone);

            if (searchFinished) {
                executors.shutdownNow();
                break;
            }

            Thread.sleep(100);
        }
        return result;
    }
}
