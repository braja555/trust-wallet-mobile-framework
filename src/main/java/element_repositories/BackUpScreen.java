package element_repositories;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BackUpScreen extends BaseScreen {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Backup\"]")
    private WebElement getTitle;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Back up secret phrase\"]")
    private WebElement getSecretPhraseText;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Protect your assets by backing up your seed phrase now.\"]")
    private WebElement getProtectYourAssetsText;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Back up manually\"]\n")
    private WebElement getBackUpManually;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Back up to Google Drive\"]")
    private WebElement getBackUpGoogleDrive;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"SKIP\"]\n")
    private WebElement getSkip;

    public void verifyTitle() throws InterruptedException {
        Assert.assertEquals(getTitle.getText().trim(),"Backup");
    }
    public void verifySkipButton() {
        Assert.assertNotNull(getSkip);
    }
    public void clickSkipButton() {
        getSkip.click();
    }
    public void verifySecretPhrase() {
        Assert.assertEquals(getSecretPhraseText.getText().trim(),"Back up secret phrase");
    }
    public void verifyProtectYourAssetsText()  {
        Assert.assertEquals(getProtectYourAssetsText.getText().trim(),"Protect your assets by backing up your seed phrase now.");
    }
    public void verifyBackUpManually()  {
        Assert.assertEquals(getBackUpManually.getText().trim(),"Back up manually");
    }
    public void verifyBackUpGoogleDriver()  {
        Assert.assertEquals(getBackUpGoogleDrive.getText().trim(),"Back up to Google Drive");
    }
    public void clickBackUpManually()  {
        getBackUpManually.click();
    }

}
