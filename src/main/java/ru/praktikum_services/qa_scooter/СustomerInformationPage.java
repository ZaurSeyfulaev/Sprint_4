package ru.praktikum_services.qa_scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class СustomerInformationPage extends BasePage {

    // Поле "Имя"
    private By fieldName = By.xpath(".//input[@placeholder='* Имя']");
    // Поле "Фамилия"
    private By fieldSurname = By.xpath(".//input[@placeholder='* Фамилия']");
    //Поле "Адрес: куда привезти"
    private By fieldAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Поле ввода названия станции метро
    private By fieldMetroStation = By.xpath(".//input[@placeholder='* Станция метро']");
    //Найденный после ввода названия станции элемент
    private String stationItem = ".//div[text()='%s']/..";
    //Поле ввода телефона
    private By phoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка Далее
    private By nextButton = By.xpath(".//button[text()='Далее']");
    //Кнопка для скрытия информации о куках
    private final By cookieMessageCloseButton = By.xpath(".//button[@id='rcc-confirm-button']");

    public СustomerInformationPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterName(String name) {
        webDriver.findElement(fieldName).sendKeys(name);
    }

    public void enterSurname(String surname) {
        webDriver.findElement(fieldSurname).sendKeys(surname);
    }

    public void enterAddress(String address) {
        webDriver.findElement(fieldAddress).sendKeys(address);
    }

    public void chooseMetroStation(String stationName) {
        webDriver.findElement(fieldMetroStation).sendKeys(stationName);
        webDriver.findElement(By.xpath(String.format(stationItem, stationName))).click();
    }

    public void enterPhoneNumber(String phoneNumber) {
        webDriver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    /*Поскольку на мониторе 13" панель с сообщением про куки перекрывает кнопку Далее и при этом страница
       не скроллится, закрываю панель если она видна
     */
    public void closeCookieMessagePanel() {
        if (webDriver.findElements(cookieMessageCloseButton).size() > 0) {
            webDriver.findElement(cookieMessageCloseButton).click();
        }


    }

    public void clickNextButton() {
        closeCookieMessagePanel();
        webDriver.findElement(nextButton).click();
    }

    public void fillCustomerInformation(String name, String surname, String address, String stationName, String phoneNumber) {
        enterName(name);
        enterSurname(surname);
        enterAddress(address);
        chooseMetroStation(stationName);
        enterPhoneNumber(phoneNumber);
    }
}

