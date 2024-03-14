package element_repositories;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CreatePasscodeScreen extends BaseScreen {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Create passcode\"]\n")
    private WebElement getTitle;

    public void verifyTitle() throws InterruptedException {
        Assert.assertEquals(getTitle.getText().trim(),"Create passcode");

    }
    public void enterCreatePasscode(){
        for(int i=1; i<=6; i++){
            driver.findElement(By.xpath("//android.widget.TextView[@text='"+i+"']")).click();
        }
    }

}
