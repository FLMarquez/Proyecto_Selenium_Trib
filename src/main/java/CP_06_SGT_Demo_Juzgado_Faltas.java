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


public class CP_06_SGT_Demo_Juzgado_Faltas {
    private WebDriver driver;

    private String downloadFilePath = "C:\\Users\\Lmarquez\\Desktop\\Escritorio PC Lucas\\SGT_DEMO\\DescargaPDF";
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

    By nombrePersona = By.id("PSNDENOMINACION");
    By btnEstadocivil = By.id("PECID");
    By btnActualizar2 = By.name("ENTER");
    By clicMensaje = By.xpath("//div[@class='toast-message'][contains(.,'La persona física MARQUEZ fue actualizada')]");
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
        //driver.get("https://test.elinpar.com/sgtdemo2/com.ktksuitelr.k2bfsg.login"); //SGT DEMO
        driver.get("https://test.elinpar.com/sgtsylvi17_test/com.ktksuitelr.k2bfsg.login"); //SANTA SYLVINA
        Thread.sleep(2000);

        driver.findElement(usernameLocator).sendKeys("lhuens");
        driver.findElement(passwordLocator).sendKeys("lhuens123");
        driver.findElement(registerBtnLocator).click();
        Thread.sleep(7000);
        driver.findElement(MenuHamburguesa).click();
        Thread.sleep(2000);
        driver.findElement(btnPersonas).click();
        Thread.sleep(2000);
        driver.findElement(btnAdministracionPersonas).click();
        Thread.sleep(5000);
        //driver.switchTo().frame(0);
        driver.findElement(barraBuscador).click();
        driver.findElement(barraBuscador).click();
        driver.findElement(barraBuscador).sendKeys("20327855418");
        Thread.sleep(5000);
        driver.findElement(fechaFin).click();
        Thread.sleep(1000);
        driver.findElement(btnVer).click();
        Thread.sleep(5000);
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



