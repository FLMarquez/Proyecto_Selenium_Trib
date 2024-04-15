import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertTrue;

public class CP_02_02_SGT_Demo_Personas_ReportePDF {
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
        driver.findElement(btnDescarga).click();
        Thread.sleep(5000);
        driver.findElement(btnReporte).click();
        Thread.sleep(6000);

        //String mainWindow = driver.getWindowHandle();
        //for(String windowHandle : driver.getWindowHandles()) {
        //driver.switchTo().window(windowHandle);
        //}
        //Thread.sleep(16000);
        // Realizar acciones en la ventana emergente, como encontrar y hacer clic en el botón de descarga
        //driver.findElement(descargaBtnid).click();


        //Thread.sleep(16000);
        // Volver al contexto principal
        //driver.switchTo().window(mainWindow);

        // Verificar la descarga de archivos
        File folder = new File(downloadFilePath);
        File[] listOfFiles = folder.listFiles();
        assertTrue(listOfFiles != null && listOfFiles.length > 0, "No se descargaron archivos correctamente");


        // Renombrar el archivo descargado
        //File downloadedFile = listOfFiles[listOfFiles.length - 1];
        //String newFileName = "prueba.pdf"; // Establece el nombre que desees
        //File renamedFile = new File(downloadFilePath + File.separator + newFileName);
        //downloadedFile.renameTo(renamedFile);

        // Verificar si el archivo se ha descargado correctamente con el nuevo nombre
        //assertTrue(renamedFile.exists(), "No se pudo cambiar el nombre del archivo descargado");

        //driver.findElement(userBtn).click();
       // Thread.sleep(2000);
        // Espera explícita para esperar a que el elemento esté presente y sea visible
        //WebDriverWait wait = new WebDriverWait(driver, 10000); // Espera hasta 10 segundos
        //WebElement elemento = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='#'][contains(.,'Leonel Huens')]"))); // Cambia el selector según el elemento que estés esperando

        // Hacer clic en el elemento después de que esté presente, visible e interactuable
        //elemento.click();
        //driver.findElement(salirBtn).click();
        //Thread.sleep(2000);

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}