package Utility;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverUtility {

    private static DriverUtility singleInstance;

    public static DriverUtility getInstance(){
        if(singleInstance == null){
            singleInstance = new DriverUtility();
        }
        return singleInstance;
    }

    private WebDriver driver;

    private boolean isDriverStarted = false;

    public void startANewChromeDriver() throws MalformedURLException{

        if (!isDriverStarted) {
            // Chrome Capabilities
            Capabilities chromeCapabilities = DesiredCapabilities.chrome();

            // create a new instance of the chrome driver
            WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeCapabilities);
            // implicit wait when searching for elements on the page
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            this.driver = driver;
            isDriverStarted = true;
        }
    }

    public void stopRunningDriver() {
        if (isDriverStarted) {
            isDriverStarted = false;
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
