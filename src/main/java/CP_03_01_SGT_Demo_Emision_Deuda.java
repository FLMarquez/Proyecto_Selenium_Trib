import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;

import static org.testng.Assert.assertTrue;


public class CP_03_01_SGT_Demo_Emision_Deuda {
    private WebDriver driver;
    private WebDriverWait wait;

    private String downloadFilePath = "C:\\Users\\Lmarquez\\Desktop\\Escritorio PC Lucas\\SGT_DEMO\\DescargaPDF";
    By usernameLocator = By.id("vUSERNAME");
    By passwordLocator = By.id("vUSERPASSWORD");
    By registerBtnLocator = By.name("LOGIN");
    By MenuHamburguesa = By.id("MENUTOGGLE_MPAGE");
    By btnEmisionDeuda = By.xpath("//span[@class='sidebar-nav-item'][contains(.,'Emisión Deuda')]");
    By btnAtencionPrimaria = By.xpath("//span[@class='sidebar-nav-item'][contains(.,'Atención Primaria')]");
    By barraBuscador = By.id("vFILTROGENERAL");
    By btnBuscar = By.id("BUSCAR");
    By btnConsultar = By.xpath("//a[contains(@data-items-index,'1')]");
    By btnTasasServObj = By.id("Tab_TABS_TABSCONTROLContainerpanel1");

    //By paginado = By.id("GRIDVINCULOS_PERSONA_OBJETO_RECORDCOUNT");

    //By paginado2 = By.id("GRIDOBLIGACIONES_RECORDCOUNT");
    By checkObjeto =By.xpath("//input[@id='vMULTIROWITEMSELECTED_GRIDVINCULOS_PERSONA_OBJETO_0001']");
    By btnConsultarObjeto = By.id("ACTUALIZAROBLIGACIONES");
    By checkObligaciones = By.xpath("//label[@for='vCHECKALL_GRIDOBLIGACIONES'][contains(.,'_')]");
    By btnImprimirContado = By.id("IMPRIMIRCONTADO");
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
        driver.findElement(btnEmisionDeuda).click();
        Thread.sleep(2000);
        driver.findElement(btnAtencionPrimaria).click();
        Thread.sleep(5000);
        // Obtener el título de la página
        String titulo = driver.getTitle();

        // Imprimir el título en la consola
        System.out.println("El título de la página es: " + titulo);

        // Validar el título
        if (titulo.equals("Atención Primaria")) {
            System.out.println("El título es correcto.");
        } else {
            System.out.println("El título no es el esperado.");
        }Thread.sleep(3000);
        //driver.switchTo().frame(0);
        //driver.findElement(barraBuscador).click();
        driver.findElement(barraBuscador).click();
        driver.findElement(barraBuscador).sendKeys("20276701429");
        Thread.sleep(5000);
        driver.findElement(btnBuscar).click();
        Thread.sleep(5000);
        driver.findElement(btnConsultar).click();
        Thread.sleep(14000);
        driver.findElement(btnTasasServObj).click();
        Thread.sleep(14000);
        // Encontrar el elemento (por ejemplo, un botón) usando XPath
        WebElement element = driver.findElement(By.xpath("//input[@id='vMULTIROWITEMSELECTED_GRIDVINCULOS_PERSONA_OBJETO_0001']"));
        Thread.sleep(6000);
        // Desplazarse hacia el elemento usando JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(8000);
        element.click();
        driver.findElement(btnConsultarObjeto).click();
        Thread.sleep(8000);
        // Desplazarse al final de la página
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(1000);
        driver.findElement(checkObligaciones).click();
        Thread.sleep(2000);
        driver.findElement(btnImprimirContado).click();
        Thread.sleep(8000);
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
        Thread.sleep(3000);
        driver.findElement(userBtn).click();
        Thread.sleep(3000);
        driver.findElement(salirBtn).click();
        //Thread.sleep(2000);

    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

