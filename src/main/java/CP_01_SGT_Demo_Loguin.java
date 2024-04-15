import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class CP_01_SGT_Demo_Loguin {
    private WebDriver driver;
    By usernameLocator = By.id("vUSERNAME");
    By passwordLocator = By.id("vUSERPASSWORD");
    By registerBtnLocator = By.name("LOGIN");
    By userBtn = By.id("USERNAMETEXTBLOCK_MPAGE");
    By salirBtn = By.id("SIGNOUT_MPAGE");

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();

        // Configurar opciones para el controlador de Firefox
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless"); // Agregar esta línea para modo headless

        // Crear instancia de WebDriver con las opciones configuradas
        driver = new FirefoxDriver(options);

        // Iniciar sesión una vez
        login();
    }

    @Test
    public void Loguin() throws InterruptedException {
        // Aquí puedes colocar tus pruebas
    }

    @AfterClass
    public void afterClass() {
        // Cerrar sesión al finalizar todas las pruebas
        logout();
        driver.quit();
    }

    private void login() {
        driver.manage().window().maximize();
        driver.get("https://test.elinpar.com/sgtdemo2/com.ktksuitelr.k2bfsg.login");
        //driver.get("https://test.elinpar.com/sgtsylvi17_test/com.ktksuitelr.k2bfsg.login"); //SANTA SYLVINA
        try {
            Thread.sleep(2000);
            driver.findElement(usernameLocator).sendKeys("lhuens");
            driver.findElement(passwordLocator).sendKeys("lhuens123");
            driver.findElement(registerBtnLocator).click();
            Thread.sleep(7000);
            driver.findElement(userBtn).click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void logout() {
        driver.findElement(salirBtn).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
