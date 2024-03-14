package tests;

import org.testng.annotations.Test;
import element_repositories.*;

import java.util.logging.Logger;

public class SelectWrongSecretPhraseTest extends BaseTest{

    public static final Logger logger=Logger.getLogger(SelectWrongSecretPhraseTest.class.getName());
    @Test(description = "Create Wallet: Validation for error pop up while entering wrong input for secret phrases")
    public static void validateErrorAlertWhileSelectWrongSecretPhrase() throws InterruptedException {
        WelcomeScreen welcomeScreen = new WelcomeScreen();
        HomeScreen homeScreen   = new HomeScreen();
        BackUpScreen backUpScreen = new BackUpScreen();
        TermsAndConditionScreen termsAndConditionScreen = new TermsAndConditionScreen();
        SecretPhraseScreen secretPhraseScreen = new SecretPhraseScreen();
        ConfirmSecretPhraseScreen confirmSecretPhraseScreen = new ConfirmSecretPhraseScreen();
        logger.info("Launch App and Tap on Start in Welcome screen");
        welcomeScreen.clickStartButton();

        logger.info(" Verify Home screen and Tap on Create New Wallet");
        homeScreen.verifyHomePageStatement();
        homeScreen.verifySecretPhrase();
        homeScreen.clickCreateNewWalletButton();

        logger.info("Verify Back up options screen");
        backUpScreen.verifyTitle();
        backUpScreen.verifySkipButton();
        backUpScreen.verifySecretPhrase();
        backUpScreen.verifyProtectYourAssetsText();

        logger.info("Tap on Start Back Up Manually button");
        backUpScreen.clickBackUpManually();

        logger.info("Validate terms and conditions screen");
        termsAndConditionScreen.verifySecretPhraseHeader();
        termsAndConditionScreen.verifyTapOnAllCheckBoxSubTitle();
        termsAndConditionScreen.clickFirstCheckBox();
        termsAndConditionScreen.clickSecondCheckBox();
        termsAndConditionScreen.clickThirdCheckBox();
        termsAndConditionScreen.clickContinueButton();

        logger.info("Validate Secret Phrase");
        secretPhraseScreen.verifyTitle();
        secretPhraseScreen.getFirstSecretPhrase();
        secretPhraseScreen.verifySecurityAlertContent();
        secretPhraseScreen.clickContinueButton();

        logger.info("Validate Confirm Secret Phrase");
        confirmSecretPhraseScreen.verifyPleaseTapOnCorrectAnswerContent();
        confirmSecretPhraseScreen.selectWrongSecretPhrase();
        confirmSecretPhraseScreen.clickContinueButton();

        logger.info("Verify error message");
        confirmSecretPhraseScreen.verifyIncorrectErrorMsgText();
        confirmSecretPhraseScreen.verifyErrorMsgForSelectionNotMatched();
        confirmSecretPhraseScreen.verifyTryAgainButton();

    }
}
