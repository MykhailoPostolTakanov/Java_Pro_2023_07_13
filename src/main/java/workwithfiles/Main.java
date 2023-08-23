package workwithfiles;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        FileLoggerConfigurationLoader configurationLoader = new FileLoggerConfigurationLoader();
        try {
            FileLoggerConfiguration configuration = configurationLoader.load();
            if(configuration!=null) {
                tryInfo(configuration);
                tryDebug(configuration);
                tryDebugInfo(configuration);
            }else {
                System.out.println("FileLoggerConfiguration is null!!!");
            }
        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static void tryInfo(FileLoggerConfiguration configuration) {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy-HH.mm.ss.SSS");
            LocalDateTime now = LocalDateTime.now();
            String fileName = "Log_" + dtf.format(now) + ".txt";
            configuration.setPath(configuration.getPath() + fileName);
            FileLogger fileLogger = new FileLogger(configuration);
            for (int i = 0; i < 500; i++)
                fileLogger.info("Test Info Log: " + i);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void tryDebug(FileLoggerConfiguration configuration) {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy-HH.mm.ss.SSS");
            LocalDateTime now = LocalDateTime.now();
            String fileName = "Log_" + dtf.format(now) + ".txt";
            configuration.setPath(configuration.getPath() + fileName);
            FileLogger fileLogger = new FileLogger(configuration);
            for (int i = 0; i < 500; i++)
                fileLogger.debug("Test Debug Log: " + i);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void tryDebugInfo(FileLoggerConfiguration configuration) {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy-HH.mm.ss.SSS");
            LocalDateTime now = LocalDateTime.now();
            String fileName = "Log_" + dtf.format(now) + ".txt";
            configuration.setPath(configuration.getPath() + fileName);
            FileLogger fileLogger = new FileLogger(configuration);
            for (int i = 0; i < 500; i++)
                fileLogger.debug("Test Debug Info Log: " + i);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
