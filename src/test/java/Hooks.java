import io.cucumber.java.After;

public class Hooks {

    @After
    public void tearDown() {
        if (LoginSteps.driver != null) {
            LoginSteps.driver.quit();
            LoginSteps.driver = null;
        }
    }
}