package tests;

import org.testng.annotations.Test;
import element_repositories.*;

import java.util.logging.Logger;

public class CreateNewWalletWithManualBackUpTest extends BaseTest{
    public static final Logger logger=Logger.getLogger(CreateNewWalletWithManualBackUpTest.class.getName());
    @Test(description = "Create Wallet: Verification for utilizing the Back Up Manually option to create a new wallet.")
    public static void validateCreateNewWalletWithManualBackUp() throws InterruptedException {
        WelcomeScreen welcomeScreen = new WelcomeScreen();
        HomeScreen homeScreen   = new HomeScreen();
        BackUpScreen backUpScreen = new BackUpScreen();
        TermsAndConditionScreen termsAndConditionScreen = new TermsAndConditionScreen();
        SecretPhraseScreen secretPhraseScreen = new SecretPhraseScreen();
        SecretPhraseAlertScreen secretPhraseAlertScreen = new SecretPhraseAlertScreen();
        ConfirmSecretPhraseScreen confirmSecretPhraseScreen = new ConfirmSecretPhraseScreen();
        CreatePasscodeScreen createPasscodeScreen = new CreatePasscodeScreen();
        ConfirmPasscodeScreen confirmPasscodeScreen = new ConfirmPasscodeScreen();
        WelcomeAboardScreen welcomeAboardScreen = new WelcomeAboardScreen();

        logger.info("Launch App and Tap on Start in Welcome screen");
        welcomeScreen.clickStartButton();

        logger.info("Verify Home screen and tap on Create New Wallet");
        homeScreen.verifyHomePageStatement();
        homeScreen.verifySecretPhrase();
        homeScreen.clickCreateNewWalletButton();

        logger.info("Verify Back up options screen");
        backUpScreen.verifyTitle();
        backUpScreen.verifySkipButton();
        backUpScreen.verifySecretPhrase();
        backUpScreen.verifyProtectYourAssetsText();

        logger.info("Tap Start Back Up Manually button");
        backUpScreen.clickBackUpManually();

        logger.info("Verify terms and conditions content in the screen");
        termsAndConditionScreen.verifySecretPhraseHeader();
        termsAndConditionScreen.verifyTapOnAllCheckBoxSubTitle();
        termsAndConditionScreen.verifyFirstCheckBoxContent();
        termsAndConditionScreen.verifySecondCheckBoxContent();
        termsAndConditionScreen.verifyThirdCheckBoxContent();
        termsAndConditionScreen.clickFirstCheckBox();
        termsAndConditionScreen.clickSecondCheckBox();
        termsAndConditionScreen.clickThirdCheckBox();
        termsAndConditionScreen.clickContinueButton();

        logger.info("Validate Secret Phrase screen content");
        secretPhraseScreen.verifyTitle();
        secretPhraseScreen.getFirstSecretPhrase();

        logger.info("Validate security alert bottom up page");
        secretPhraseScreen.verifySecurityAlertContent();
        secretPhraseScreen.clickSecurityAlertContent();
        secretPhraseAlertScreen.verifyNeverShareHeader();
        secretPhraseAlertScreen.clickOKButton();
        secretPhraseScreen.clickContinueButton();

        logger.info("Validate Confirm Secret Phrase");
        confirmSecretPhraseScreen.verifyPleaseTapOnCorrectAnswerContent();
        confirmSecretPhraseScreen.selectRightSecretPhraseMatched();
        confirmSecretPhraseScreen.clickContinueButton();

        logger.info("Create Passcode and Confirm passcode");
        createPasscodeScreen.verifyTitle();
        createPasscodeScreen.enterCreatePasscode();
        confirmPasscodeScreen.verifyTitle();
        confirmPasscodeScreen.enterConfirmPasscode();

        logger.info("Validate Main Wallet Creation");
        welcomeAboardScreen.verifyWelcomeAboardHeader();
        welcomeAboardScreen.verifyYourWalletReadyContent();
        welcomeAboardScreen.clickStartUsingTrustButton();
    }
}
