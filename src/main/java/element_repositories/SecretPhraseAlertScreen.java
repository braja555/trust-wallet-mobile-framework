package element_repositories;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SecretPhraseAlertScreen extends BaseScreen {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Never Share Your Secret Phrase\"]\n")
    private WebElement getNeverShareHeader;
    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.widget.Button\n")
    private WebElement getOKButton;

    public void verifyNeverShareHeader() throws InterruptedException {
        Assert.assertEquals(getNeverShareHeader.getText().trim(),"Never Share Your Secret Phrase");
    }
    public void clickOKButton()  {getOKButton.click();}

}
