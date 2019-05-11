package Stepdefs;

import PageObjects.*;
import Utility.*;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class AllStepDefs extends BaseStepDefs{
    public SlackScreen slackScreen;

    @Before(order = 1)
    public void beforeSuite() throws MalformedURLException {
        System.out.println("BeforeDeleteTest");

        slackScreen = new SlackScreen(driver());
    }

    @Given("^User goes to files management page$")
    public void goToManagementPage() throws MalformedURLException{
        driver().navigate().to(new URL("https://domain.slack.com/files"));
        slackScreen.getEmailField().sendKeys("");
        slackScreen.getPasswordField().sendKeys("");
        slackScreen.getSignInButton().click();

        SeleniumUtility.getInstance().pauseForSeconds(10);
    }

    @When("^User goes to the last page of image files and delete ten image files$")
    public void goToLastPageOnImageSorting() throws MalformedURLException{
        for (int i = 0; i < 100; i++) {
            try {
                driver().navigate().to(new URL("https://domain.slack.com/files/username"));
                SeleniumUtility.getInstance().pauseForSeconds(5);

                // User opens the last image on the list
                List <WebElement> imagesFiles = slackScreen.getImagesFiles();
                imagesFiles.get(imagesFiles.size() - 1).click();
                SeleniumUtility.getInstance().pauseForSeconds(5);

                // User delete file
                slackScreen.getActionsSelector().click();
                SeleniumUtility.getInstance().pauseForSeconds(2);
                slackScreen.getDeleteButton().click();
                SeleniumUtility.getInstance().pauseForSeconds(2);
                slackScreen.getConfirmDelete().click();
                SeleniumUtility.getInstance().pauseForSeconds(5);
            }
            catch(NoSuchElementException e) {

            }
        }
    }
}
