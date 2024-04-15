import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CP_02_05_SGT_Demo_Personas_VerifXLS {
    static String xlsFilePath = "C:\\Users\\Lmarquez\\Desktop\\Escritorio PC Lucas\\SGT_DEMO\\DescargaPDF\\Reportar-Exportar\\ExportWWPersonas.xlsx";
    static String textToCompare = "Administración de Personas";
    static String textToCompare2 = "Apellido";
    static String textToCompare3 = "CUIT";

    public static void main(String[] args) {
        try {
            // Leer el archivo XLS
            String xlsContent = readXLS(xlsFilePath);

            // Comparar el texto con el contenido del archivo XLS
            if (xlsContent.contains(textToCompare)) {
                System.out.println("El texto '" + textToCompare + "' está presente en el archivo XLS.");
            } else {
                System.out.println("El texto '" + textToCompare + "' no está presente en el archivo XLS.");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // Leer el archivo XLS
            String xlsContent = readXLS(xlsFilePath);

            // Comparar el texto con el contenido del archivo XLS
            if (xlsContent.contains(textToCompare2)) {
                System.out.println("El texto '" + textToCompare2 + "' está presente en el archivo XLS.");
            } else {
                System.out.println("El texto '" + textToCompare2 + "' no está presente en el archivo XLS.");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // Leer el archivo XLS
            String xlsContent = readXLS(xlsFilePath);

            // Comparar el texto con el contenido del archivo XLS
            if (xlsContent.contains(textToCompare3)) {
                System.out.println("El texto '" + textToCompare3 + "' está presente en el archivo XLS.");
            } else {
                System.out.println("El texto '" + textToCompare3 + "' no está presente en el archivo XLS.");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }


    }




    public static String readXLS(String xlsFilePath) throws IOException {
        StringBuilder content = new StringBuilder();
        FileInputStream fileInputStream = new FileInputStream(new File(xlsFilePath));
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0); // Se asume que el texto está en la primera hoja del libro

        for (Row row : sheet) {
            for (Cell cell : row) {
                switch (cell.getCellTypeEnum()) {
                    case STRING:
                        content.append(cell.getStringCellValue()).append(" ");
                        break;
                    case NUMERIC:
                        content.append(cell.getNumericCellValue()).append(" ");
                        break;
                    case BOOLEAN:
                        content.append(cell.getBooleanCellValue()).append(" ");
                        break;
                    default:
                        // No hacer nada para otros tipos de celdas
                }
            }
        }

        fileInputStream.close();
        return content.toString();
    }
}
