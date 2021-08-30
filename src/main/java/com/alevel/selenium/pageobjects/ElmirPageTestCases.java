package com.alevel.selenium.pageobjects;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;


public class ElmirPageTestCases extends ElmirPage {

    private static final Config applicationConfig = ConfigFactory.parseResources("application.conf");
    private static final String USERNAME = applicationConfig.getString("credentialsUi.username");
    private static final String PASS = applicationConfig.getString("credentialsUi.pass");

    public void runSortTestCase() {
        this.login();
        specialOffers.click();
        sort.click();
        byNovelty.click();
        show.click();
        list.click();
        number.click();
        seventyTwo.click();
        availability.click();
        areAvailable.click();
        logOutBtn.click();
        exitBtn.click();
    }

    public void runRegistrationTestCase() {
        entranceRegistrationBtn.click();
        registrationBtn.click();
        emailRegistrationField.sendKeys(USERNAME);
        passwordRegistrationField.sendKeys(PASS);
        register.click();
    }

    public void runBuyFromSideBarTestCase() {
        this.login();
        mobileConnection.click();
        mobilePhone.click();
        phoneVerico.click();
        inBasket.click();
        basket.click();
        deletePhoneBtn.click();
        logOutBtn.click();
        exitBtn.click();
    }

    public void runComparisonTestCase() {
        this.login();
        gettingReadyForSchool.click();
        addToComparisonF5104.click();
        addToComparisonV222.click();
        compare.click();
        showOnlyDifferences.click();
        clearBtn.click();
        profile.click();
        exitBtn.click();
    }

    public void runBuyFromSearchLineTestCase(String inputName) {
        this.login();
        inputField.click();
        inputField.sendKeys(inputName);
        searchBtn.click();
        auto.click();
        basket.click();
        deleteCarBtn.click();
        logOutBtn.click();
        exitBtn.click();
    }

    private void login() {
        loginToYourAccountBtn.click();
        emailLoginField.sendKeys(USERNAME);
        passwordLoginField.sendKeys(PASS);
        entranceBtn.click();
    }
}
