import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            if (LoginSteps.driver != null) {
                byte[] screenshot = ((TakesScreenshot) LoginSteps.driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Failed Scenario Screenshot");
            }
        }

        if (LoginSteps.driver != null) {
            LoginSteps.driver.quit();
        }
    }
}