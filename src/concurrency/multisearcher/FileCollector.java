package concurrency.multisearcher;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileCollector {
    public List<File> getFiles(String folder) {
        List<File> result = new ArrayList<>();

        search(new File(folder), result);

        return result;
    }

    private void search(File base, List<File> result) {
        if (base.isFile()) {
            result.add(base);
        } else {
            for (File child : base.listFiles()) {
                search(child, result);
            }
        }
    }
}
