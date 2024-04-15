import org.testng.TestNG;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class TestSuiteRunner {

    @Test
    public void runTestSuite() {
        TestNG testSuite = new TestNG();
        List<String> suites = new ArrayList<>();
        suites.add("C:\\Users\\Lmarquez\\IdeaProjects\\SGT_Version_Demo\\Suite-Prueba.xml"); // Ruta a tu archivo XML de configuración de TestNG
        testSuite.setTestSuites(suites);
        testSuite.run();
    }
}

