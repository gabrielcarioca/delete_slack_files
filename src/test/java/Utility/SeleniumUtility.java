package Utility;

import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class SeleniumUtility {

    private static SeleniumUtility singleInstance;

    public static SeleniumUtility getInstance(){
        if(singleInstance == null){
            singleInstance = new SeleniumUtility();
        }
        return singleInstance;
    }

    private String projectPathLocation = System.getProperty("user.dir");

    public String getCurrentTimestampAsString() {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }

    public int getARandomNumber(int limmin, int limmax){
        return new Random().nextInt(limmax - limmin) + limmin;
    }

    public int getARandomNumber(int limmax) {
        return getARandomNumber(0, limmax);
    }

    public void pauseForSeconds(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void takeScreenshotOnFailure(WebDriver driver, Scenario scenario) {
        if (scenario != null && scenario.isFailed()) {
            String projectPathLocation = System.getProperty("user.dir");
            String resultsLocation = projectPathLocation + "/results/";
            String fileLocation = projectPathLocation + "/results/screenshots/";

            try {
                new File(resultsLocation).mkdirs(); // Insure directory is there
                String failureImageFileName = scenario.getName()
                        + new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime()) + ".png";
                File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File failureImageFile = new File(fileLocation + failureImageFileName);
                FileUtils.copyFile(imageFile, failureImageFile);
            } catch (Exception e) {
                // No need to crash the tests if the screenshot fails
            }

        }
    }

    public void clickElementUsingJavascript(WebDriver driver, WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", element);
    }
}