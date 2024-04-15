import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;


public class CP_02_03_SGT_Demo_Personas_VerifPDF {
    private WebDriver driver;

    static String pdfFilePath = "C:\\Users\\Lmarquez\\Desktop\\Escritorio PC Lucas\\SGT_DEMO\\DescargaPDF\\Reportar-Exportar\\reportwwpersonas_impl.pdf";
    static String extractedText;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");


        try {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless"); // Agregar esta línea para modo headless

            // Configurar perfil de Firefox para descargas automáticas
            FirefoxProfile firefoxProfile = new FirefoxProfile();
            firefoxProfile.setPreference("browser.download.folderList", 2);
            firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
            firefoxProfile.setPreference("pdfjs.disabled", true);
            firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
            options.setProfile(firefoxProfile);

            // Iniciar el driver de Firefox
            WebDriver driver = new FirefoxDriver(options);

            // Llamar al método setUp para extraer texto del PDF
            setUp();

            // Cerrar el driver de Firefox
            driver.quit();
        } catch (Exception e) {
            System.out.println("Error al configurar el perfil de Firefox: " + e.getMessage());
        }
    }


    @Test
    public void testPDFText() {
        // Verifica si existen los textos
        String textToCheck1 = "Administración de Personas";
        String textToCheck2 = "Apellido PEREZ";
        String textToCheck3 = "CUIT";
        String textToCheck4 = "Documento";
        String textToCheck5 = "Fecha de Nacimiento";
        String textToCheck6 = "Fecha de Fallecimiento";
        String textToCheck7 = "Género";
        String textToCheck8 = "Tipo Personeri";

        if (extractedText.contains(textToCheck1)) {
            System.out.println("El texto 'Administración de Personas' está presente en el PDF.");
        } else {
            System.out.println("El texto 'Administración de Personas' no está presente en el PDF.");
        }

        if (extractedText.contains(textToCheck2)) {
            System.out.println("El texto 'Apellido PEREZ' está presente en el PDF.");
        } else {
            System.out.println("El texto 'Apellido PEREZ' no está presente en el PDF.");
        }

        if (extractedText.contains(textToCheck3)) {
            System.out.println("El texto 'CUIT' está presente en el PDF.");
        } else {
            System.out.println("El texto 'CUIT' no está presente en el PDF.");
        }

        if (extractedText.contains(textToCheck4)) {
            System.out.println("El texto 'Documento' está presente en el PDF.");
        } else {
            System.out.println("El texto 'Documento' no está presente en el PDF.");
        }

        if (extractedText.contains(textToCheck5)) {
            System.out.println("El texto 'Fecha de Nacimiento' está presente en el PDF.");
        } else {
            System.out.println("El texto 'Fecha de Nacimiento' no está presente en el PDF.");
        }

        if (extractedText.contains(textToCheck6)) {
            System.out.println("El texto 'Fecha de Fallecimiento' está presente en el PDF.");
        } else {
            System.out.println("El texto 'Fecha de Fallecimiento' no está presente en el PDF.");
        }

        if (extractedText.contains(textToCheck7)) {
            System.out.println("El texto 'Género' está presente en el PDF.");
        } else {
            System.out.println("El texto 'Género' no está presente en el PDF.");
        }

        if (extractedText.contains(textToCheck8)) {
            System.out.println("El texto 'Tipo Personeri' está presente en el PDF.");
        } else {
            System.out.println("El texto 'Tipo Personeri' no está presente en el PDF.");
        }
    }


    @AfterClass
    public static void tearDown() {
        // Realizar la captura de pantalla del PDF
        takeScreenshot(pdfFilePath);
    }

    public static void setUp() {
        // Llama al método para obtener el texto del PDF
        extractedText = getTextFromPDF(pdfFilePath);

        // Imprime el texto extraído del PDF
        System.out.println("Texto extraído del PDF:");
        System.out.println(extractedText);
    }

    public static String getTextFromPDF(String pdfFilePath) {
        try (PDDocument document = PDDocument.load(new File(pdfFilePath))) {
            PDFTextStripper stripper = new PDFTextStripper();
            return stripper.getText(document);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void takeScreenshot(String pdfFilePath) {
        try (PDDocument document = PDDocument.load(new File(pdfFilePath))) {
            PDFRenderer pdfRenderer = new PDFRenderer(document);
            List<BufferedImage> images = new ArrayList<>();

            for (int page = 0; page < document.getNumberOfPages(); ++page) {
                BufferedImage image = pdfRenderer.renderImageWithDPI(page, 300, ImageType.RGB);
                images.add(image);
            }

            // Crear el directorio para guardar los screenshots si no existe
            File directory = new File("C:\\Users\\Lmarquez\\Desktop\\Escritorio PC Lucas\\SGT_DEMO\\ScreenShot");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Guardar cada página del PDF como una imagen PNG
            for (int i = 0; i < images.size(); i++) {
                File screenshotFile = new File(directory, "screenshot_page_" + (i + 1) + ".png");
                ImageIO.write(images.get(i), "png", screenshotFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}