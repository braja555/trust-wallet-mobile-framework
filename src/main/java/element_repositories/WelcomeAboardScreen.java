package element_repositories;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WelcomeAboardScreen extends BaseScreen {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Welcome aboard\"]\n")
    private WebElement getWelcomeAboard;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Your wallet is now ready to use. Dive in and start your crypto journey. Stay secure!\"]\n")
    private WebElement getYourWalletReadyContent;

    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.widget.Button\n")
    private WebElement getStartUsingTrustButton;

    public void verifyWelcomeAboardHeader() throws InterruptedException {
        Assert.assertEquals(getWelcomeAboard.getText().trim(),"Welcome aboard");
    }
    public void verifyYourWalletReadyContent() {
        Assert.assertEquals(getYourWalletReadyContent.getText().trim(),"Your wallet is now ready to use. Dive in and start your crypto journey. Stay secure!");
    }

    public void clickStartUsingTrustButton()  {getStartUsingTrustButton.click();}
}
