package ru.praktikum_services.qa_scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RentalPage extends BasePage {
    // Заголовок страницы Про Аренду
    private By pageRentalTitle = By.xpath(".//div[text()='Про аренду']");
    // Поле с датой доставки
    private By fieldDeliveryDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // Поле с периодом аренды
    private By fieldRentalPeriod = By.xpath(".//span[@class='Dropdown-arrow']");
    // Итем периода из выпадающего списка
    private String periodItem = ".//div[text()='%s']";
    // чекбоксы цвета черный жемчуг
    private By checkBoxScooterColorBlackPearl = By.xpath(".//label[text()='чёрный жемчуг']");
    //чекбокс цвета серая безысходность
    private By checkBoxScooterColorGrayHopelessness = By.xpath(".//input[text()='серая безысходность']");
    private By fieldCommentForCourier = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    private By backButton = By.xpath(".//button[text()='Назад']");

    public RentalPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean checkTransitionToRentalPage() {
        return webDriver.findElement(pageRentalTitle).isDisplayed();
    }

    public void enterDeliveryDate(String deliveryDate) {
        webDriver.findElement(fieldDeliveryDate).sendKeys(deliveryDate);
    }

    public void selectRentalPeriod(String period) {
        webDriver.findElement(fieldRentalPeriod).click();
        webDriver.findElement(By.xpath(String.format(periodItem, period))).click();
    }

    public void selectBlackPearlCheckBox() {
        webDriver.findElement(checkBoxScooterColorBlackPearl).click();
    }

    public void selectGrayHopelessnessCheckBox() {
        webDriver.findElement(checkBoxScooterColorGrayHopelessness).click();
    }

    public void enterCommentForCourier(String comment) {
        webDriver.findElement(fieldCommentForCourier).sendKeys(comment);
    }

    public void clickOrderButton() {
        webDriver.findElement(orderButton).click();
    }

    public void clickBackButton() {
        webDriver.findElement(backButton).click();
    }

    public void fillRentalInformation(String deliveryDate, String period, String comment) {
        enterDeliveryDate(deliveryDate);
        selectRentalPeriod(period);
        selectBlackPearlCheckBox();
        enterCommentForCourier(comment);
    }
}
