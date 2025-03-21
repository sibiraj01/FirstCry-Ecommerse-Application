package steps;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static String getProperty(String key)throws FileNotFoundException,IOException{
        Properties properties = new Properties();
        FileInputStream file = new FileInputStream("./Xpath.properties");
        properties.load(file);
        return properties.getProperty(key);
    }

    public static void main(String[] args) throws IOException {
        String appurl = ConfigReader.getProperty("Url");
        System.out.println("Application Url " + appurl);
    }
}
