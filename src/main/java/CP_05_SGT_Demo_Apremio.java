import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxProfile;


import static org.testng.Assert.assertTrue;


public class CP_05_SGT_Demo_Apremio {
    private WebDriver driver;

    private String downloadFilePath = "C:\\Users\\Lmarquez\\Desktop\\Escritorio PC Lucas\\SGT_DEMO\\DescargaPDF";
    By usernameLocator = By.id("vUSERNAME");
    By passwordLocator = By.id("vUSERPASSWORD");
    By registerBtnLocator = By.name("LOGIN");
    By MenuHamburguesa = By.id("MENUTOGGLE_MPAGE");
    By btnApremio = By.xpath("(//span[@class='sidebar-nav-item'][contains(.,'Apremio')])[1]");
    By btnAdministracionApremio = By.xpath("//span[@class='sidebar-nav-item'][contains(.,'Administración de Apremios')]");

    //By tipoLiquidacion = By.xpath("//select[contains(@id,'vTLQID')]");
    //By tipoObjeto = By.xpath("//select[contains(@id,'vOTPID')]");
    By btnConsultar = By.id("BUTTON1");
    By userBtn = By.xpath("//a[@href='#'][contains(.,'Leonel Huens')]");
    By salirBtn = By.id("SIGNOUT_MPAGE");


    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");

        try {
            FirefoxProfile firefoxProfile = new FirefoxProfile();
            firefoxProfile.setPreference("browser.download.folderList", 2);
            firefoxProfile.setPreference("browser.download.dir", downloadFilePath);
            firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
            firefoxProfile.setPreference("pdfjs.disabled", true);
            firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);

            FirefoxOptions options = new FirefoxOptions();
            options.setProfile(firefoxProfile);
            //options.addArguments("--headless"); // Agregar esta línea para modo headless

            driver = new FirefoxDriver(options);
        } catch (Exception e) {
            System.out.println("Error al configurar el perfil de Firefox: " + e.getMessage());
        }

    }


    @Test
    public void Loguin() throws InterruptedException {
        driver.manage().window().maximize();
        //driver.get("https://test.elinpar.com/sgtdemo2/com.ktksuitelr.k2bfsg.login"); //SGT DEMO
        driver.get("https://test.elinpar.com/sgtsylvi17_test/com.ktksuitelr.k2bfsg.login"); //SANTA SYLVINA
        Thread.sleep(2000);

        driver.findElement(usernameLocator).sendKeys("lhuens");
        driver.findElement(passwordLocator).sendKeys("lhuens123");
        driver.findElement(registerBtnLocator).click();
        Thread.sleep(7000);
        driver.findElement(MenuHamburguesa).click();
        Thread.sleep(2000);
        driver.findElement(btnApremio).click();
        Thread.sleep(2000);
        driver.findElement(btnAdministracionApremio).click();
        // Obtener el título de la página
        String titulo = driver.getTitle();

        // Imprimir el título en la consola
        System.out.println("El título de la página es: " + titulo);

        // Validar el título
        if (titulo.equals("Administración de Apremios")) {
            System.out.println("El título es correcto.");
        } else {
            System.out.println("El título no es el esperado.");
        }Thread.sleep(1000);
        Thread.sleep(5000);
        WebElement tipoLiquidacion = driver.findElement(By.xpath("//select[contains(@id,'vTLQID')]"));
        Select tipoActaSelect = new Select(tipoLiquidacion);
        tipoActaSelect.selectByVisibleText("APREMIO");
        Thread.sleep(2000);
        WebElement tipoObjeto = driver.findElement(By.xpath("//select[contains(@id,'vOTPID')]"));
        Select tipoObjetoSelect = new Select(tipoObjeto);
        tipoObjetoSelect.selectByVisibleText("COMERCIO");
        //driver.switchTo().frame(0);
        Thread.sleep(2000);
        driver.findElement(btnConsultar).click();
        Thread.sleep(4000);
        driver.findElement(userBtn).click();
        Thread.sleep(2000);
        driver.findElement(salirBtn).click();
        //Thread.sleep(2000);

    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

