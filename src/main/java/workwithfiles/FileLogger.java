package workwithfiles;

import java.io.*;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger implements Logger {
    private FileLoggerConfiguration config;

    public FileLogger(FileLoggerConfiguration config) {
        this.config = config;
    }

    @Override
    public void debug(String message) throws IOException {
        if (config.getLevel().equals(LoggingLevel.INFO))
            return;
        String logText = getFormatedText(message);
        Path path = Path.of(config.getPath());
        File file = path.toFile();
        if (!file.exists())
            file.createNewFile();
        if (file.length() > config.getMaxfilesize()) {
            setNewPath();
            path = Path.of(config.getPath());
            file = path.toFile();
            file.createNewFile();
        }
        try (var out = new OutputStreamWriter(new FileOutputStream(config.getPath(), true))) {
            out.append(logText + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void info(String message) throws IOException {
        String logText = getFormatedText(message);
        Path path = Path.of(config.getPath());
        File file = path.toFile();
        if (!file.exists())
            file.createNewFile();
        if (file.length() > config.getMaxfilesize()) {
            setNewPath();
            path = Path.of(config.getPath());
            file = path.toFile();
            file.createNewFile();
        }
        try (var out = new OutputStreamWriter(new FileOutputStream(config.getPath(), true))) {
            out.append(logText + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getFormatedText(String text) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy-HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String log = String.format(config.getFormat(), dtf.format(now), config.getLevel(), text);
        return log;
    }

    private void setNewPath() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy-HH.mm.ss.SSS");
        LocalDateTime now = LocalDateTime.now();
        String fileName = "Log_" + dtf.format(now) + ".txt";
        String newPath = config.getPath().substring(0, config.getPath().lastIndexOf("/"));
        config.setPath(newPath + "/" + fileName);
    }
}
