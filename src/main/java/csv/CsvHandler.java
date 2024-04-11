package csv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class CsvHandler {
    private String PARENT_DIR;
    private final String SEPARATOR;

    public CsvHandler(String parentDir, String separator) {
        PARENT_DIR = parentDir;
        SEPARATOR = separator;

        if (PARENT_DIR.charAt(PARENT_DIR.length() - 1) != '/')
            PARENT_DIR += '/';
    }

    public void writeResult(String file, String function, double x, double result) {
        Path path = Paths.get(PARENT_DIR + ensureCsvExtension(file));
        String data = x + SEPARATOR + result + System.lineSeparator();

        try {
            if (!Files.exists(path)) {
                Files.createDirectories(path.getParent());
                Files.createFile(path);
            }

//            if (Files.size(path) == 0) {
//                data = "x" + SEPARATOR + function + "(x)" + System.lineSeparator() + data;
//            }

            Files.write(path, data.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    private String ensureCsvExtension(String filename) {
        if (!filename.toLowerCase().endsWith(".csv")) {
            return filename + ".csv";
        }
        return filename;
    }

    public List<String> readData(String file) {
        Path path = Paths.get(PARENT_DIR + ensureCsvExtension(file));
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
