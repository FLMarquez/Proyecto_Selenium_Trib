import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxProfile;
import java.io.File;
import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class CP_02_01_SGT_Demo_Personas {
    private WebDriver driver;

    private final String downloadFilePath = "C:\\Users\\Lmarquez\\Desktop\\Escritorio PC Lucas\\SGT_DEMO\\DescargaPDF\\Reportar-Exportar";
    By usernameLocator = By.id("vUSERNAME");
    By passwordLocator = By.id("vUSERPASSWORD");
    By registerBtnLocator = By.name("LOGIN");
    By MenuHamburguesa = By.id("MENUTOGGLE_MPAGE");
    By btnPersonas = By.xpath("(//span[@class='sidebar-nav-item'][contains(.,'Personas')])[1]");
    By btnAdministracionPersonas = By.xpath("//span[@class='sidebar-nav-item'][contains(.,'Administración de Personas')]");
    By barraBuscador = By.id("vK2BTOOLSGENERICSEARCHFIELD");

    By fechaFin = By.id("span_PSNFECHAFIN_0001");
    By btnVer = By.id("vVER_0001");
    By btnDomicilio = By.id("Tab_TABS_TABSCONTROLContainerpanel1");
    By btnObjetos = By.id("Tab_TABS_TABSCONTROLContainerpanel2");
    By btnVinculos = By.id("Tab_TABS_TABSCONTROLContainerpanel3");
    By btnAdjuntos = By.id("Tab_TABS_TABSCONTROLContainerpanel4");
    By linkAdministracionPersonas = By.id("span_vVOLVERPERSONAS_ACTION");
    By btnActualizar = By.id("vUPDATE_0001");

    By clicMensaje = By.xpath("//div[@class='toast-message'][contains(.,'La persona física MARQUEZ fue actualizada')]");

    By checkPersonas = By.id("FILTERTOGGLE_COMBINED");

    By testboxCuit = By.id("vPSNCUIP");

    By testboxApellido = By.id("vPSNDENOMINACION");

    By testboxNombre = By.id("vPSNNOMBRE");

    By closeFilter = By.id("FILTERCLOSE_COMBINED");
    By btnDescarga = By.id("IMAGE1");

    By btnReporte = By.id("REPORT");
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
        driver.findElement(btnAdministracionPersonas).click();
        Thread.sleep(5000);
        // Obtener el título de la página
        String titulo = driver.getTitle();

        // Imprimir el título en la consola
        System.out.println("El título de la página es: " + titulo);

        // Validar el título
        if (titulo.equals("Administración de Personas")) {
            System.out.println("El título es correcto.");
        } else {
            System.out.println("El título no es el esperado.");
        }Thread.sleep(3000);
        //driver.switchTo().frame(0);

        //driver.findElement(barraBuscador).click();
        driver.findElement(barraBuscador).sendKeys("20327855418");
        Thread.sleep(4000);
        driver.findElement(fechaFin).click();
        Thread.sleep(6000);
        driver.findElement(btnVer).click();
        Thread.sleep(12000);
        driver.findElement(btnDomicilio).click();
        driver.findElement(btnObjetos).click();
        driver.findElement(btnVinculos).click();
        driver.findElement(btnAdjuntos).click();
        driver.findElement(linkAdministracionPersonas).click();
        Thread.sleep(5000);
        driver.findElement(fechaFin).click();
        Thread.sleep(1000);
        driver.findElement(btnActualizar).click();
        Thread.sleep(5000);
        driver.switchTo().frame(0);
        //driver.findElement(nombrePersona).click();
        //driver.findElement(btnEstadocivil).click();
        WebElement tipoAmbiente = driver.findElement(By.xpath("//select[contains(@id,'PECID')]"));
        Thread.sleep(4000);
        Select tipoAmbienteSelect = new Select(tipoAmbiente);
        tipoAmbienteSelect.selectByVisibleText("SOLTERO/A");
        Thread.sleep(4000);
        tipoAmbiente.sendKeys(Keys.ENTER);
        Thread.sleep(6000);
        // Cambio al nuevo popup
        String popupWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
        driver.switchTo().window(popupWindow);
        driver.findElement(clicMensaje).click();
        Thread.sleep(2000);
        driver.findElement(checkPersonas).click();
        driver.findElement(testboxCuit).clear();
        driver.findElement(barraBuscador).clear();
        Thread.sleep(3000);
        driver.findElement(testboxCuit).sendKeys("20327855418");
        Thread.sleep(3000);
        driver.findElement(closeFilter).click();
        Thread.sleep(2000);
        // Obtener el cuerpo del texto de la página
        WebElement bodyElement1 = driver.findElement(By.tagName("body"));
        String pageText1 = bodyElement1.getText();

        // Texto que deseas validar
        String textoAValidar1 = "FEDERICO LUCAS";
        String textoAValidar2 = "MARQUEZ";
        String textoAValidar3 = "20327855418";

        // Verificar si el texto está presente en la página
        if (pageText1.contains(textoAValidar1)) {
            System.out.println("El texto '" + textoAValidar1 + "' está presente en la página.");
        } else {
            System.out.println("El texto '" + textoAValidar1 + "' no está presente en la página.");
        }
        // Verificar si el texto está presente en la página
        if (pageText1.contains(textoAValidar2)) {
            System.out.println("El texto '" + textoAValidar2 + "' está presente en la página.");
        } else {
            System.out.println("El texto '" + textoAValidar2 + "' no está presente en la página.");
        }
        // Verificar si el texto está presente en la página
        if (pageText1.contains(textoAValidar3)) {
            System.out.println("El texto '" + textoAValidar3 + "' está presente en la página.");
        } else {
            System.out.println("El texto '" + textoAValidar3 + "' no está presente en la página.");
        }

        driver.findElement(checkPersonas).click();
        driver.findElement(barraBuscador).clear();
        driver.findElement(testboxCuit).clear();
        Thread.sleep(3000);
        driver.findElement(testboxApellido).sendKeys("Marquez");
        Thread.sleep(3000);
        driver.findElement(closeFilter).click();
        // Obtener el cuerpo del texto de la página
        WebElement bodyElement2 = driver.findElement(By.tagName("body"));
        String pageText2 = bodyElement2.getText();

        // Texto que deseas validar
        String textoAValidar4 = "FEDERICO LUCAS";
        String textoAValidar5 = "MARQUEZ";
        String textoAValidar6 = "20327855418";

        // Verificar si el texto está presente en la página
        if (pageText2.contains(textoAValidar4)) {
            System.out.println("El texto '" + textoAValidar4 + "' está presente en la página.");
        } else {
            System.out.println("El texto '" + textoAValidar4 + "' no está presente en la página.");
        }
        // Verificar si el texto está presente en la página
        if (pageText2.contains(textoAValidar5)) {
            System.out.println("El texto '" + textoAValidar5 + "' está presente en la página.");
        } else {
            System.out.println("El texto '" + textoAValidar5 + "' no está presente en la página.");
        }
        // Verificar si el texto está presente en la página
        if (pageText2.contains(textoAValidar6)) {
            System.out.println("El texto '" + textoAValidar6 + "' está presente en la página.");
        } else {
            System.out.println("El texto '" + textoAValidar6 + "' no está presente en la página.");
        }

        driver.findElement(checkPersonas).click();
        driver.findElement(barraBuscador).clear();
        driver.findElement(testboxApellido).clear();
        Thread.sleep(3000);
        driver.findElement(testboxNombre).sendKeys("Federico Lucas");
        Thread.sleep(3000);
        driver.findElement(closeFilter).click();
        // Obtener el cuerpo del texto de la página
        WebElement bodyElement3 = driver.findElement(By.tagName("body"));
        String pageText3 = bodyElement3.getText();

        // Texto que deseas validar
        String textoAValidar7 = "FEDERICO LUCAS";
        String textoAValidar8 = "MARQUEZ";
        String textoAValidar9 = "20327855418";

        // Verificar si el texto está presente en la página
        if (pageText3.contains(textoAValidar7)) {
            System.out.println("El texto '" + textoAValidar7 + "' está presente en la página.");
        } else {
            System.out.println("El texto '" + textoAValidar7 + "' no está presente en la página.");
        }
        // Verificar si el texto está presente en la página
        if (pageText3.contains(textoAValidar8)) {
            System.out.println("El texto '" + textoAValidar8 + "' está presente en la página.");
        } else {
            System.out.println("El texto '" + textoAValidar8 + "' no está presente en la página.");
        }
        // Verificar si el texto está presente en la página
        if (pageText3.contains(textoAValidar9)) {
            System.out.println("El texto '" + textoAValidar9 + "' está presente en la página.");
        } else {
            System.out.println("El texto '" + textoAValidar9 + "' no está presente en la página.");
        }

        driver.findElement(checkPersonas).click();
        driver.findElement(barraBuscador).clear();
        driver.findElement(testboxCuit).clear();
        driver.findElement(testboxNombre).clear();
        driver.findElement(testboxApellido).clear();
        Thread.sleep(3000);
        driver.findElement(testboxApellido).sendKeys("Perez");
        Thread.sleep(3000);
        driver.findElement(closeFilter).click();
        Thread.sleep(3000);
        // Obtener el cuerpo del texto de la página
        WebElement bodyElement4 = driver.findElement(By.tagName("body"));
        String pageText4 = bodyElement4.getText();

        // Texto que deseas validar
        String textoAValidar10 = "Perez";


        // Verificar si el texto está presente en la página
        if (pageText4.contains(textoAValidar10)) {
            System.out.println("El texto '" + textoAValidar10 + "' está presente en la página.");
        } else {
            System.out.println("El texto '" + textoAValidar10 + "' no está presente en la página.");
        }
        Thread.sleep(3000);

        // Define la duración del tiempo de espera en segundos
        int segundosEspera = 10;

// Convierte la duración del tiempo de espera en un objeto de tipo Duration
        Duration duracionEspera = Duration.ofSeconds(segundosEspera);

// Crea una instancia de WebDriverWait utilizando la duración especificada
        WebDriverWait wait = new WebDriverWait(driver, duracionEspera);

// Espera hasta que el elemento sea clickable dentro del tiempo de espera especificado
        WebElement elemento = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='#'][contains(.,'Leonel Huens')]")));

        // Hacer clic en el elemento después de que esté presente, visible e interactuable
        elemento.click();
        driver.findElement(salirBtn).click();
        //Thread.sleep(2000);

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}