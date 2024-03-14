package element_repositories;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class TermsAndConditionScreen extends BaseScreen {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"This secret phrase is the master key to your wallet\"]")
    private WebElement getSecretPhraseHeader;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Tap on all checkboxes to confirm you understand the importance of your secret phrase\"]\n")
    private WebElement getTapOnAllCheckBoxSubTitle;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Trust Wallet does not keep a copy of your secret phrase.\"]")
    private WebElement getFirstCheckBoxContent;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Saving this digitally in plain text is NOT recommended. Examples include screenshots, text files, or emailing yourself\"]\n")
    private WebElement getSecondCheckBoxContent;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Write down your secret phrase, and store it in a secure offline location!\"]\n")
    private WebElement getThirdCheckBoxContent;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[1]")
    private WebElement getFirstCheckBox;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[2]")
    private WebElement getSecondCheckBox;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[3]")
    private WebElement getThirdCheckBox;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[4]/android.widget.Button")
    private WebElement getContinueButton;

    public void verifySecretPhraseHeader() throws InterruptedException {
        Assert.assertEquals(getSecretPhraseHeader.getText().trim(),"This secret phrase is the master key to your wallet");
    }
    public void verifyTapOnAllCheckBoxSubTitle() {
        Assert.assertEquals(getTapOnAllCheckBoxSubTitle.getText().trim(),"Tap on all checkboxes to confirm you understand the importance of your secret phrase");
    }
    public void verifyFirstCheckBoxContent()  {
        Assert.assertEquals(getFirstCheckBoxContent.getText().trim(),"Trust Wallet does not keep a copy of your secret phrase.");
    }

    public void verifySecondCheckBoxContent()  {
        Assert.assertEquals(getSecondCheckBoxContent.getText().trim(),"Saving this digitally in plain text is NOT recommended. Examples include screenshots, text files, or emailing yourself");
    }

    public void verifyThirdCheckBoxContent()  {
        Assert.assertEquals(getThirdCheckBoxContent.getText().trim(),"Write down your secret phrase, and store it in a secure offline location!");
    }

    public void clickFirstCheckBox()  {
        getFirstCheckBox.click();
    }
    public void clickSecondCheckBox()  {
        getSecondCheckBox.click();
    }
    public void clickThirdCheckBox()  {
        getThirdCheckBox.click();
    }
    public void verifyContinueButton()  {Assert.assertNotNull(getContinueButton);}
    public void clickContinueButton()  {getContinueButton.click();}

}
