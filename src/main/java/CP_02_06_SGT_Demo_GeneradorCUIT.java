import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class CP_02_06_SGT_Demo_GeneradorCUIT {
    private WebDriver driver;
    By usernameLocator = By.id("vUSERNAME");
    By passwordLocator = By.id("vUSERPASSWORD");
    By registerBtnLocator = By.name("LOGIN");

    By MenuHamburguesa = By.id("MENUTOGGLE_MPAGE");
    By btnPersonas = By.xpath("(//span[@class='sidebar-nav-item'][contains(.,'Personas')])[1]");
    By btnGenerarCuit = By.xpath("//span[@class='sidebar-nav-item'][contains(.,'Generar Cuit/Cuil')]");

    By txtDni = By.id("vPSNNUMERODOCUMENTO");
    By btnSexo = By.xpath("//label[@for='vPSNSEXO1'][contains(.,'Masculino')]");
    By btnGenerar = By.id("GENERAR");
    By btnLimpiar = By.id("LIMPIAR");
    By cuitGenerado = By.id("span_vPSNCUIP");
    By userBtn = By.id("USERNAMETEXTBLOCK_MPAGE");
    By salirBtn = By.id("SIGNOUT_MPAGE");

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");

        try {
            FirefoxProfile firefoxProfile = new FirefoxProfile();
            firefoxProfile.setPreference("browser.download.folderList", 2);
            //firefoxProfile.setPreference("browser.download.dir", downloadFilePath);
            firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
            firefoxProfile.setPreference("pdfjs.disabled", true);
            firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);

            FirefoxOptions options = new FirefoxOptions();
            options.setProfile(firefoxProfile);
            options.addArguments("--headless"); // Agregar esta línea para modo headless

            driver = new FirefoxDriver(options);
        } catch (Exception e) {
            System.out.println("Error al configurar el perfil de Firefox: " + e.getMessage());
        }

    }

    @Test
    public void Loguin() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://test.elinpar.com/sgtdemo2/com.ktksuitelr.k2bfsg.login"); //SGT DEMO
        //driver.get("https://test.elinpar.com/sgtsylvi17_test/com.ktksuitelr.k2bfsg.login"); //SANTA SYLVINA
        Thread.sleep(2000);

        driver.findElement(usernameLocator).sendKeys("lhuens");
        driver.findElement(passwordLocator).sendKeys("lhuens123");
        driver.findElement(registerBtnLocator).click();
        Thread.sleep(7000);
        driver.findElement(MenuHamburguesa).click();
        Thread.sleep(2000);
        driver.findElement(btnPersonas).click();
        Thread.sleep(5000);
        driver.findElement(btnGenerarCuit).click();
        Thread.sleep(5000);
        // Obtener el cuerpo del texto de la página
        WebElement bodyElement1 = driver.findElement(By.tagName("body"));
        String pageText1 = bodyElement1.getText();

        // Texto que deseas validar
        String textoAValidar1 = "Generación de CUIT/CUIL";

        // Verificar si el texto está presente en la página
        if (pageText1.contains(textoAValidar1)) {
            System.out.println("El texto '" + textoAValidar1 + "' está presente en la página.");
        } else {
            System.out.println("El texto '" + textoAValidar1 + "' no está presente en la página.");
        }
        Thread.sleep(3000);
        // Obtener el cuerpo del texto de la página
        WebElement bodyElement2 = driver.findElement(By.tagName("body"));
        String pageText2 = bodyElement2.getText();

        // Texto que deseas validar
        String textoAValidar2 = "GENERADOR DE CUIT";

        // Verificar si el texto está presente en la página
        if (pageText2.contains(textoAValidar2)) {
            System.out.println("El texto '" + textoAValidar2 + "' está presente en la página.");
        } else {
            System.out.println("El texto '" + textoAValidar2 + "' no está presente en la página.");
        }
        Thread.sleep(3000);
        // Obtener el cuerpo del texto de la página
        WebElement bodyElement3 = driver.findElement(By.tagName("body"));
        String pageText3 = bodyElement3.getText();

        // Texto que deseas validar
        String textoAValidar3 = "Ingrese Nro de Documento";

        // Verificar si el texto está presente en la página
        if (pageText3.contains(textoAValidar3)) {
            System.out.println("El texto '" + textoAValidar3 + "' está presente en la página.");
        } else {
            System.out.println("El texto '" + textoAValidar3 + "' no está presente en la página.");
        }
        Thread.sleep(3000);
        //driver.switchTo().frame(0);

        //driver.findElement(barraBuscador).click();
        driver.findElement(txtDni).clear();
        driver.findElement(txtDni).sendKeys("32785541");
        Thread.sleep(1000);
        driver.findElement(btnSexo).click();
        driver.findElement(btnGenerar).click();
        Thread.sleep(1000);
        // Obtener el cuerpo del texto de la página
        WebElement bodyElement4 = driver.findElement(By.tagName("body"));
        String pageText4 = bodyElement4.getText();

        // Texto que deseas validar
        String textoAValidar4 = "20327855418";

        // Verificar si el texto está presente en la página
        if (pageText4.contains(textoAValidar4)) {
            System.out.println("El texto '" + textoAValidar4 + "' está presente en la página.");
        } else {
            System.out.println("El texto '" + textoAValidar4 + "' no está presente en la página.");
        }
        Thread.sleep(3000);
        // Obtener el cuerpo del texto de la página
        WebElement bodyElement5 = driver.findElement(By.tagName("body"));
        String pageText5 = bodyElement5.getText();

        // Texto que deseas validar
        String textoAValidar5 = "Masculino";

        // Verificar si el texto está presente en la página
        if (pageText5.contains(textoAValidar5)) {
            System.out.println("El texto '" + textoAValidar5 + "' está presente en la página.");
        } else {
            System.out.println("El texto '" + textoAValidar5 + "' no está presente en la página.");
        }
        Thread.sleep(3000);
        // Obtener el cuerpo del texto de la página
        WebElement bodyElement6 = driver.findElement(By.tagName("body"));
        String pageText6 = bodyElement5.getText();

        // Texto que deseas validar
        String textoAValidar6 = "Femenino";

        // Verificar si el texto está presente en la página
        if (pageText6.contains(textoAValidar6)) {
            System.out.println("El texto '" + textoAValidar6 + "' está presente en la página.");
        } else {
            System.out.println("El texto '" + textoAValidar6 + "' no está presente en la página.");
        }
        Thread.sleep(3000);
        // Obtener el cuerpo del texto de la página
        WebElement bodyElement7 = driver.findElement(By.tagName("body"));
        String pageText7 = bodyElement5.getText();

        // Texto que deseas validar
        String textoAValidar7 = "Seleccione Sexo";

        // Verificar si el texto está presente en la página
        if (pageText7.contains(textoAValidar7)) {
            System.out.println("El texto '" + textoAValidar7 + "' está presente en la página.");
        } else {
            System.out.println("El texto '" + textoAValidar7 + "' no está presente en la página.");
        }
        Thread.sleep(3000);
        // Obtener el cuerpo del texto de la página
        WebElement bodyElement8 = driver.findElement(By.tagName("body"));
        String pageText8 = bodyElement8.getText();

        // Texto que deseas validar
        String textoAValidar8 = "CUIT/CUIL Generado";

        // Verificar si el texto está presente en la página
        if (pageText8.contains(textoAValidar8)) {
            System.out.println("El texto '" + textoAValidar8 + "' está presente en la página.");
        } else {
            System.out.println("El texto '" + textoAValidar8 + "' no está presente en la página.");
        }
        Thread.sleep(3000);
        driver.findElement(btnLimpiar).click();
        Thread.sleep(2000);
        driver.findElement(userBtn).click();
        driver.findElement(salirBtn).click();
    }


        @AfterClass
        public void afterClass() {
            driver.quit();
        }

    }


