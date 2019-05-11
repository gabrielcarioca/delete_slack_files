package Stepdefs;

import Utility.DriverUtility;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.net.MalformedURLException;


public class ServiceHooks{

    @Before(order = 0)
    public void initializeTest() throws MalformedURLException {
        // Code to setup initial configurations
        System.out.println("Initialize Test");

        // Creating the chrome driver
        DriverUtility.getInstance().startANewChromeDriver();
    }

    @After(order = 0)
    public void embedScreenshot(Scenario scenario) {
        System.out.println("Finishing Test");
        DriverUtility.getInstance().stopRunningDriver();
        if (scenario.isFailed()) {
            try {
                // Code to capture and embed images in test reports (if scenario fails)
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}