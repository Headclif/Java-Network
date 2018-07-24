package Server;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    private static final String PROPERTIES_FILE = "src/main/resources/Server/server.properties";

    public static int PORT;
    public static int SLEEP_TIME;

    static {
        Properties properties = new Properties();
        FileInputStream propertiesFile = null;

        try {
            propertiesFile = new FileInputStream(PROPERTIES_FILE);
            properties.load(propertiesFile);
            PORT = Integer.parseInt(properties.getProperty("PORT"));
            SLEEP_TIME = Integer.parseInt(properties.getProperty("SLEEP_TIME"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                propertiesFile.close();
            } catch (IOException e) {
                System.err.print("Can't close properties file");
                e.printStackTrace();
            }
        }
    }
}
