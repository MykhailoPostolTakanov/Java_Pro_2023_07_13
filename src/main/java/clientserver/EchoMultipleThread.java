package clientserver;

import JDBC.Hero;
import JDBC.HeroDaoImpl;
import org.postgresql.ds.PGSimpleDataSource;
import patternsandtesting.HeroMovieService;
import patternsandtesting.HeroService;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class EchoMultipleThread extends Thread {
    private static final String EXIT_COMMAND = "-exit";
    private static final String FIND_BY_NAME_COMMAND = "-name";
    private static final String ERROR_MESSAGE_WHEN_COMMAND_NOT_FOUND = "Command not found";
    private static final String HERO_NOT_FOUND_MESSAGE = "Hero not found";
    private final Socket socket;

    EchoMultipleThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            var out = new PrintWriter(socket.getOutputStream(), true);
            var in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            HeroService heroService = new HeroService(new HeroDaoImpl(createDataSource()), new HeroMovieService());

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                if (inputLine.equals(EXIT_COMMAND)) {
                    out.println(EXIT_COMMAND);
                    break;
                } else if (inputLine.contains(FIND_BY_NAME_COMMAND)) {
                    String heroName = inputLine.split(FIND_BY_NAME_COMMAND)[1].trim();
                    List<Hero> result = heroService.getHeroesByName(heroName);
                    if (result == null)
                        out.println(HERO_NOT_FOUND_MESSAGE);
                    else if (result.size() == 0)
                        out.println(HERO_NOT_FOUND_MESSAGE);
                    else
                        out.println(result);
                } else {
                    out.println(ERROR_MESSAGE_WHEN_COMMAND_NOT_FOUND);
                }
            }

            out.close();
            in.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static DataSource createDataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setServerNames(new String[]{"localhost"});
        dataSource.setDatabaseName("postgres");
        dataSource.setUser("hillel");
        dataSource.setPassword("hillel");
        return dataSource;
    }
}
