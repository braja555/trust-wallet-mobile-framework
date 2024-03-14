package element_repositories;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ConfirmPasscodeScreen extends BaseScreen {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Confirm passcode\"]\n")
    private WebElement getTitleConfirmPasscode;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Those passwords didn’t match!\"]\n")
    private WebElement getErrorMessage;

    public void verifyTitle() throws InterruptedException {
        Assert.assertEquals(getTitleConfirmPasscode.getText().trim(),"Confirm passcode");
    }
    public void enterConfirmPasscode(){
        for(int i=1; i<=6; i++){
            driver.findElement(By.xpath("//android.widget.TextView[@text='"+i+"']")).click();
        }
    }
    public void enterInvalidConfirmPasscode(){
        for(int i=2; i<=7; i++){
            driver.findElement(By.xpath("//android.widget.TextView[@text='"+i+"']")).click();
        }
    }
    public void verifyErrorMessage() throws InterruptedException {
        Assert.assertEquals(getErrorMessage.getText().trim(),"Those passwords didn’t match!");
    }



}
