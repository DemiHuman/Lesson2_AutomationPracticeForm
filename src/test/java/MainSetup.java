import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Configuration.startMaximized;

public class MainSetup {
    @BeforeAll
    static void MainSetup() {
        startMaximized = true;
    }
}
