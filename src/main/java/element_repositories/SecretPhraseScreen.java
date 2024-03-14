package element_repositories;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.HashMap;

public class SecretPhraseScreen extends BaseScreen {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Secret phrase\"]\n")
    private WebElement getTitle;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Never share your secret phrase with anyone, and store it securely!\"]")
    private WebElement getSecurityAlert;
    @AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[5]/android.widget.Button\n")
    private WebElement getContinueButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text, '1. ')]")
    private WebElement getFirstSecretPhrase;
    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text, '4. ')]")
    private WebElement getFourthSecretPhrase;
    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text, '7. ')]")
    private WebElement getSeventhSecretPhrase;
    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text, '10. ')]")
    private WebElement getTenSecretPhrase;

    public static HashMap<String,String> oCommonMap = new HashMap<String,String>();

    public void verifyTitle() throws InterruptedException {
        Assert.assertEquals(getTitle.getText().trim(),"Secret phrase");
    }
    public void verifySecurityAlertContent() {
        Assert.assertEquals(getSecurityAlert.getText().trim(),"Never share your secret phrase with anyone, and store it securely!");
    }

    public void getFirstSecretPhrase(){
        String actualFirstPharse = getFirstSecretPhrase.getText().trim();
        String[] firPharse = actualFirstPharse.split("\\.");
        String firstPharse = firPharse[1].trim();

        String actualFourthPharse = getFourthSecretPhrase.getText().trim();
        String[] foPharse = actualFourthPharse.split("\\.");
        String fourthPharse = foPharse[1].trim();

        String actualSeventhPharse = getSeventhSecretPhrase.getText().trim();
        String[] sevPharse = actualSeventhPharse.split("\\.");
        String seventhPharse = sevPharse[1].trim();

        String actualTenthPharse = getTenSecretPhrase.getText().trim();
        String[] tenPharse = actualTenthPharse.split("\\.");
        String tenthPharse = tenPharse[1].trim();

        oCommonMap.put("1", firstPharse);
        oCommonMap.put("4", fourthPharse);
        oCommonMap.put("7", seventhPharse);
        oCommonMap.put("10", tenthPharse);
    }

    public void clickSecurityAlertContent()  {getSecurityAlert.click();}
    public void clickContinueButton()  {getContinueButton.click();}

}
