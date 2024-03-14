package tests;

import org.testng.annotations.Test;
import element_repositories.*;

import java.util.logging.Logger;

public class BackUpSecretPhraseTest extends BaseTest{

    public static final Logger logger=Logger.getLogger(BackUpSecretPhraseTest.class.getName());
    @Test(description = "Create Wallet: Validation for Back Up screen")
    public static void validateBackUpSecretPhraseAndTermsAndConditions() throws InterruptedException {
        WelcomeScreen welcomeScreen = new WelcomeScreen();
        HomeScreen homeScreen   = new HomeScreen();
        BackUpScreen backUpScreen = new BackUpScreen();
        TermsAndConditionScreen termsAndConditionScreen = new TermsAndConditionScreen();

        logger.info("Launch App and Tap on Start in Welcome screen");
        welcomeScreen.clickStartButton();

        logger.info("Verify Home screen and Tap on Create New Wallet");
        homeScreen.clickCreateNewWalletButton();

        logger.info("Verify Back up options screen");
        backUpScreen.verifyTitle();
        backUpScreen.verifySkipButton();
        backUpScreen.verifyProtectYourAssetsText();
        backUpScreen.verifySecretPhrase();
        backUpScreen.verifyBackUpManually();
        backUpScreen.verifyBackUpGoogleDriver();

        logger.info("Tap on Back Up Manually button");
        backUpScreen.clickBackUpManually();

        logger.info("Verify terms and conditions screen");
        termsAndConditionScreen.verifySecretPhraseHeader();
        termsAndConditionScreen.verifyTapOnAllCheckBoxSubTitle();
        termsAndConditionScreen.verifyFirstCheckBoxContent();
        termsAndConditionScreen.verifySecondCheckBoxContent();
        termsAndConditionScreen.verifyThirdCheckBoxContent();
        termsAndConditionScreen.clickFirstCheckBox();
        termsAndConditionScreen.clickSecondCheckBox();
        termsAndConditionScreen.clickThirdCheckBox();
        termsAndConditionScreen.verifyContinueButton();
    }
}
