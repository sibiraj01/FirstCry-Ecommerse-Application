import javax.lang.model.element.Name;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Readproperty {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("./Xpath.properties"));
        String property = properties.getProperty("Url");
        System.out.println(property);
    }
}
