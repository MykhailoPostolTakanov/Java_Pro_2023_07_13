package workwithfiles;

import java.io.FileNotFoundException;

public interface LoggerConfigurationLoader {
    public  LoggerConfiguration load() throws FileNotFoundException;
}
