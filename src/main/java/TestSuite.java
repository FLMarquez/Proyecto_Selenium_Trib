import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestSuite {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "ruta/a/tu/driver/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testCase1() {
        // Caso de prueba 1
        driver.get("https://www.example.com");
        // Realizar operaciones de prueba
    }

    @Test
    public void testCase2() {
        // Caso de prueba 2
        driver.get("https://www.example.com");
        // Realizar operaciones de prueba
    }

    // Otros casos de prueba

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

