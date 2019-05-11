package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SlackScreen extends AbstractScreen {

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "signin_btn")
    private WebElement signInButton;

    @FindBy(className = "contents")
    private List<WebElement> imagesFiles;

    @FindBy(id = "file_action_cog")
    private WebElement actionsSelector;

    @FindBy(id = "delete_file")
    private WebElement deleteButton;

    @FindBy(className = "dialog_go")
    private WebElement confirmDelete;

    public SlackScreen (WebDriver driver) {
        super(driver);
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getSignInButton() {
        return signInButton;
    }

    public List<WebElement> getImagesFiles() {
        return imagesFiles;
    }

    public WebElement getActionsSelector() {
        return actionsSelector;
    }

    public WebElement getDeleteButton() {
        return deleteButton;
    }

    public WebElement getConfirmDelete() {
        return confirmDelete;
    }
}
