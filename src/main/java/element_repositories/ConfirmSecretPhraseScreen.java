package element_repositories;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static element_repositories.SecretPhraseScreen.oCommonMap;

public class ConfirmSecretPhraseScreen extends BaseScreen {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Confirm secret phrase\"]\n")
    private WebElement getTitle;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Please tap on the correct answer of the below seed phrases.\"]\n")
    private WebElement getPleaseTapOnCorrectAnswerContent;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Try again\"]\n")
    private WebElement getTryAgainButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Selections not matched. Please try again.\"]\n")
    private WebElement getErrorMsgForSelectionNotMatched;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Confirm\"]\n")
    private WebElement getConfirmButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Incorrect\"]\n")
    private WebElement getIncorrectErrorMsgText;

    public void verifyPleaseTapOnCorrectAnswerContent() {
        Assert.assertEquals(getPleaseTapOnCorrectAnswerContent.getText().trim(),"Please tap on the correct answer of the below seed phrases.");
    }
    public void verifyTryAgainButton()  {
        Assert.assertNotNull(getTryAgainButton);
    }
    public void verifyErrorMsgForSelectionNotMatched()  {
        Assert.assertNotNull(getErrorMsgForSelectionNotMatched);
    }
    public void verifyIncorrectErrorMsgText()  {
        Assert.assertNotNull(getIncorrectErrorMsgText);
    }

    public void selectRightSecretPhraseMatched(){
        int wordPhraseSize = driver.findElements(By.xpath("//android.widget.TextView[@text=\"Word #1\"]//following-sibling::android.view.View")).size();
        for(int i=1; i<=wordPhraseSize; i++){

            for (String word: oCommonMap.values()){
                WebElement getWordPhrase = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Word #1\"]//following-sibling::android.view.View["+i+"]/android.widget.TextView"));
                if(word.equalsIgnoreCase(getWordPhrase.getText().trim()))
                getWordPhrase.click();
            }
        }
    }

    public void selectWrongSecretPhrase(){
        int wordPhraseSize = driver.findElements(By.xpath("//android.widget.TextView[@text=\"Word #1\"]//following-sibling::android.view.View")).size();
        for(int i=1; i<=wordPhraseSize; i++){

            for (String word: oCommonMap.values()){
                WebElement getWordPhrase = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Word #1\"]//following-sibling::android.view.View["+i+"]/android.widget.TextView"));
                    getWordPhrase.click();
            }
        }
    }

    public void clickContinueButton()  {getConfirmButton.click();}

}
