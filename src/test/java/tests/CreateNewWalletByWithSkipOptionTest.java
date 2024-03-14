package tests;

import org.testng.annotations.Test;
import element_repositories.*;

import java.util.logging.Logger;

public class CreateNewWalletByWithSkipOptionTest extends BaseTest{

    public static final Logger logger=Logger.getLogger(CreateNewWalletByWithSkipOptionTest.class.getName());
    @Test(description = "Create Wallet: Verification of launching a new wallet by selecting the Skip option in the Backup screen")
    public static void validateCreateNewWalletByWithSkipOption() throws InterruptedException {
        WelcomeScreen welcomeScreen = new WelcomeScreen();
        HomeScreen homeScreen   = new HomeScreen();
        BackUpScreen backUpScreen = new BackUpScreen();
        CreatePasscodeScreen createPasscodeScreen = new CreatePasscodeScreen();
        ConfirmPasscodeScreen confirmPasscodeScreen = new ConfirmPasscodeScreen();
        WelcomeAboardScreen welcomeAboardScreen = new WelcomeAboardScreen();

        logger.info("Launch App and Tap on Start in Welcome screen");
        welcomeScreen.clickStartButton();

        logger.info("Validate Home screen and tap on Create New Wallet");
        homeScreen.verifyHomePageStatement();
        homeScreen.verifySecretPhrase();
        homeScreen.clickCreateNewWalletButton();

        logger.info("Validate Back up options screen");
        backUpScreen.verifyTitle();
        backUpScreen.verifySkipButton();
        backUpScreen.clickSkipButton();

        logger.info("Create New Passcode");
        createPasscodeScreen.verifyTitle();
        createPasscodeScreen.enterCreatePasscode();

        logger.info("Confirm New Passcode");
        confirmPasscodeScreen.verifyTitle();
        confirmPasscodeScreen.enterConfirmPasscode();

        logger.info("Validate Main Wallet Creation welcome message");
        welcomeAboardScreen.verifyWelcomeAboardHeader();
        welcomeAboardScreen.verifyYourWalletReadyContent();

        logger.info("Tap on Start using trust button");
        welcomeAboardScreen.clickStartUsingTrustButton();
    }
}
