import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {

    public static WebDriver driver; // Ή όπως αλλιώς παίρνεις τον driver σου (π.χ. από κάποιο DriverFactory)

    @After
    public void tearDown(Scenario scenario) {
        // 1. Αν το τεστ απέτυχε, τραβάμε screenshot ΕΝΩ ο driver είναι ακόμα ανοιχτός
        if (scenario.isFailed() && driver != null) {
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Failure Screenshot");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // 2. Τέλος, κλείνουμε τον browser ασφαλώς
        if (driver != null) {
            driver.quit();
            driver = null; // Μηδενισμός για να μην μείνει null session active
        }
    }
}