package concurrency.multisearcher;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileSearcher {
    public void search(File file, String search, List<File> ifFound) {
        try {
            String content = Files.readString(Path.of(file.getCanonicalPath()));

            if (content.toLowerCase().contains(search.toLowerCase())) {
                ifFound.add(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
