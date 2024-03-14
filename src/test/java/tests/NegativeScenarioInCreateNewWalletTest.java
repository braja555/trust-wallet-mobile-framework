package tests;

import org.testng.annotations.Test;
import element_repositories.*;

import java.util.logging.Logger;

public class NegativeScenarioInCreateNewWalletTest extends BaseTest{

    public static final Logger logger=Logger.getLogger(NegativeScenarioInCreateNewWalletTest.class.getName());
    @Test(description = "Create Wallet: Verifying Negative scenarios when establishing a fresh wallet")
    public static void validateErrorForInvalidPasscode() throws InterruptedException {
        WelcomeScreen welcomeScreen = new WelcomeScreen();
        HomeScreen homeScreen   = new HomeScreen();
        BackUpScreen backUpScreen = new BackUpScreen();
        TermsAndConditionScreen termsAndConditionScreen = new TermsAndConditionScreen();
        SecretPhraseScreen secretPhraseScreen = new SecretPhraseScreen();
        ConfirmSecretPhraseScreen confirmSecretPhraseScreen = new ConfirmSecretPhraseScreen();
        CreatePasscodeScreen createPasscodeScreen = new CreatePasscodeScreen();
        ConfirmPasscodeScreen confirmPasscodeScreen = new ConfirmPasscodeScreen();

        logger.info("Launch App and Tap on Start in Welcome screen");
        welcomeScreen.clickStartButton();

        logger.info("Verify Home screen and Tap on Create New Wallet");
        homeScreen.clickCreateNewWalletButton();

        logger.info("Verify various Back up options");
        backUpScreen.verifyTitle();
        backUpScreen.verifySkipButton();
        backUpScreen.verifySecretPhrase();
        backUpScreen.verifyProtectYourAssetsText();

        logger.info("Tap on Start Back Up Manually button");
        backUpScreen.clickBackUpManually();

        logger.info("Verify terms and conditions screen");
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
        confirmSecretPhraseScreen.selectRightSecretPhraseMatched();
        confirmSecretPhraseScreen.clickContinueButton();

        logger.info("Create Passcode and Confirm passcode");
        createPasscodeScreen.verifyTitle();
        createPasscodeScreen.enterCreatePasscode();
        confirmPasscodeScreen.verifyTitle();

        logger.info("Error message verification");
        confirmPasscodeScreen.enterInvalidConfirmPasscode();
        confirmPasscodeScreen.verifyErrorMessage();

    }
}
