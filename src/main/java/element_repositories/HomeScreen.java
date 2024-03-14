package element_repositories;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomeScreen extends BaseScreen {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Join 70M+ people shaping the future of the internet with us\"]")
    private WebElement getHomePageStatement;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Secret phrase or Swift wallet\"]")
    private WebElement getSecretPhrase;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Create new wallet']")
    private WebElement createNewWalletButton;

    public void verifyHomePageStatement() throws InterruptedException {
        Assert.assertEquals(getHomePageStatement.getText().trim(),"Join 70M+ people shaping the future of the internet with us");
    }
    public void verifySecretPhrase() throws InterruptedException {
        Assert.assertEquals(getSecretPhrase.getText().trim(),"Secret phrase or Swift wallet");
    }
    public void clickCreateNewWalletButton() {
        createNewWalletButton.click();
    }
}
