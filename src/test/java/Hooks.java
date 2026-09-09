import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed() && LoginSteps.driver != null) {
            try {
                byte[] screenshot = ((TakesScreenshot) LoginSteps.driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Failure Screenshot");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (LoginSteps.driver != null) {
            LoginSteps.driver.quit();
            LoginSteps.driver = null;
        }
    }
}