import org.openqa.selenium.WebDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelperClass extends AbstractClass {
    public HelperClass(WebDriver driver) {
        super(driver);
    }

    public List<String> getTestData(String fileName) throws IOException {
        List<String> records = new ArrayList<String>();
        String record;
        try (BufferedReader buffer = new BufferedReader(new FileReader(fileName));) {
            while ((record = buffer.readLine()) != null) {
                records.add(record);
            }
        }
        return records;
    }
}
