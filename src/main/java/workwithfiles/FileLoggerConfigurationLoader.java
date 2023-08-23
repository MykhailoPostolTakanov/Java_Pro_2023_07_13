package workwithfiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class FileLoggerConfigurationLoader implements LoggerConfigurationLoader {
    @Override
    public FileLoggerConfiguration load() throws FileNotFoundException {
        //FileLoggerConfigurationLoader.class.getResourceAsStream("/fileloggerconfiguration.txt"); Щось я не зрозумів як краще зробити вигрузку з ресурсу щоб було зручно читати строки
        var scanner = new Scanner(new FileInputStream(Path.of("src/main/resources/fileloggerconfiguration.txt").toFile()));
        String path = "";
        LoggingLevel level = LoggingLevel.DEBUG;
        int maxfilesize = 0;
        String format = "";
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            switch (line.split(": ")[0]) {
                case "FILE":
                    path = line.split(": ")[1];
                    break;
                case "LEVEL":
                    switch (line.split(": ")[1]) {
                        case "INFO":
                            level = LoggingLevel.INFO;
                            break;
                        case "DEBUG":
                            level = LoggingLevel.DEBUG;
                            break;
                    }
                    break;
                case "MAX-SIZE":
                    maxfilesize = Integer.parseInt(line.split(": ")[1]);
                    break;
                case "FORMAT":
                    format = line.split(": ")[1];
                    break;
            }
        }
        if (path.equals("") && maxfilesize == 0 && format.equals(""))
            return null;
        FileLoggerConfiguration configuration = new FileLoggerConfiguration(path, level, maxfilesize, format);
        return configuration;
    }
}
