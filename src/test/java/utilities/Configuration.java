package utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

    public static String getProperties(String key) throws IOException{

        File credsFile = new File("src/test/resources/conf/configuration.properties"); // location of the file credential.properties
        FileReader fileReader = new FileReader(credsFile); // please read my file
        Properties properties = new Properties(); // i need to read from property file this instance created
        properties.load(fileReader); // after you instance will read all your file
        String value=properties.getProperty(key); // now you asking the properties to the key and return the value
        return value;
    }
}
