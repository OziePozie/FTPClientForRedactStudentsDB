import org.testng.TestNG;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        testNG.setTestSuites(Collections.singletonList("testng.xml"));
        testNG.run();
    }
}
