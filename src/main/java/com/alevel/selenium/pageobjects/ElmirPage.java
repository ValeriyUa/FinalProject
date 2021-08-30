package com.alevel.selenium.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class ElmirPage {

    @FindBy(xpath = "//*[@id=\"autho\"]/span")
    WebElement entranceRegistrationBtn;

    @FindBy(xpath ="//*[@id=\"email\"]")
    WebElement emailRegistrationField;

    @FindBy(xpath = "//*[@id=\"password\"]")
    WebElement passwordRegistrationField;

    @FindBy(xpath = "//*[@id=\"delete_999436\"]")
    WebElement deleteCarBtn;

    @FindBy(xpath = "//*[@id=\"delete_974135\"]")
    WebElement deletePhoneBtn;

    @FindBy(xpath = "//*[@id=\"autho\"]/span")
    WebElement loginToYourAccountBtn;

    @FindBy(xpath = "//*[@id=\"login-form\"]/form/input")
    WebElement emailLoginField;

    @FindBy(xpath ="//*[@id=\"login-form\"]/form/div[2]/input")
    WebElement passwordLoginField;

    @FindBy(xpath = "//*[@id=\"login-form\"]/form/button")
    WebElement entranceBtn;

    @FindBy(xpath = "//*[@id=\"q\"]")
    WebElement inputField;

    @FindBy(xpath = "//*[@id=\"find\"]")
    WebElement searchBtn;

    @FindBy(xpath = "//*[@id=\"vitrina-tovars\"]/li[1]/section/div/div/div")
    WebElement auto;

    @FindBy(xpath = "//*[@id=\"basket-small\"]")
    WebElement basket;

    @FindBy(xpath = "//*[@id=\"autho\"]/ul/li/a")
    WebElement logOutBtn;

    @FindBy(xpath = "//*[@id=\"autho\"]/ul/li/ul/li[4]/form")
    WebElement exitBtn;

    @FindBy(xpath = "//*[@id=\"content-container\"]/section[1]/a[1]/span")
    WebElement gettingReadyForSchool;

    @FindBy(xpath = "//*[@id=\"vitrina-tovars\"]/li[1]/section/span[6]")
    WebElement addToComparisonF5104;

    @FindBy(xpath = "//*[@id=\"vitrina-tovars\"]/li[2]/section/span[7]")
    WebElement addToComparisonV222;

    @FindBy(xpath = "//*[@id=\"vitrina-tovars\"]/li[2]/section/a[3]")
    WebElement compare;

    @FindBy(xpath = "//*[@id=\"compare-filter\"]/a[3]")
    WebElement showOnlyDifferences;

    @FindBy(xpath = "//*[@id=\"compare-links\"]/a[1]")
    WebElement clearBtn;

    @FindBy(xpath = "//*[@id=\"autho\"]/ul/li/a")
    WebElement profile;

    @FindBy(xpath = "//*[@id=\"tab-5\"]/span")
    WebElement mobileConnection;

    @FindBy(xpath = "//*[@id=\"content-container\"]/div[5]/a")
    WebElement mobilePhone;

    @FindBy(xpath = "//*[@id=\"vitrina-tovars\"]/li[1]/section/a[1]")
    WebElement phoneVerico;

    @FindBy(xpath = "//*[@id=\"product-card-block\"]/div[1]/div[2]/div[1]/div[2]/div[1]")
    WebElement inBasket;

    @FindBy(linkText = "Зарегистрироваться")
    WebElement registrationBtn;

    @FindBy(xpath = "//*[@id=\"do-registration\"]")
    WebElement register;

    @FindBy(xpath = "//*[@id=\"out-link-4\"]")
    WebElement specialOffers;

    @FindBy(xpath = "//*[@id=\"top-paging\"]/div[1]/div")
    WebElement sort;

    @FindBy(xpath = "//*[@id=\"top-paging\"]/div[1]/div/div/a[7]")
    WebElement byNovelty;

    @FindBy(xpath = "//*[@id=\"top-paging\"]/div[2]/div")
    WebElement show;

    @FindBy(linkText = "списком")
    WebElement list;

    @FindBy(xpath = "//*[@id=\"top-paging\"]/div[3]/div")
    WebElement number;

    @FindBy(linkText = "72")
    WebElement seventyTwo;

    @FindBy(xpath = "//*[@id=\"top-paging\"]/div[4]/div/span/span")
    WebElement availability;

    @FindBy(linkText = "есть в наличии")
    WebElement areAvailable;

}
