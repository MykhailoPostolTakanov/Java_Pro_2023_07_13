package workwithfiles;

public class FileLoggerConfiguration implements LoggerConfiguration {
    private String path;
    private LoggingLevel level;
    private int maxfilesize;
    private String format = "[%s][%s] Повідомлення: [%s]";

    public FileLoggerConfiguration(String path, LoggingLevel level, int maxfilesize, String format) {
        this.path = path;
        this.level = level;
        this.maxfilesize = maxfilesize;
        this.format = format;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public LoggingLevel getLevel() {
        return level;
    }

    public int getMaxfilesize() {
        return maxfilesize;
    }

    @Override
    public String getFormat() {
        return format;
    }
}
