package ru.praktikum_services.qa_scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage extends BasePage {
    //Заголовок страницы
    private By pageTitle = By.xpath(".//div[text()='Хотите оформить заказ?']");
    // Кнопка Да
    private By buttonYes = By.xpath(".//button[text()='Да']");
    // Канопка Нет
    private By buttonNo = By.xpath(".//button[text()='Нет']");
    //Заголовок окна подтверждения заказа
    private By messageOrderCompleted = By.xpath(".//div[text()='Заказ оформлен']");

    public OrderConfirmationPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isDisplayedOrderConfirmationPage() {
        return webDriver.findElement(pageTitle).isDisplayed();
    }

    public void clickButtonYes() {
        webDriver.findElement(buttonYes).click();
    }

    public void clickButtonNo() {
        webDriver.findElement(buttonNo).click();
    }

    public boolean isDisplayedOrderStatus() {
        try {
            return webDriver.findElement(messageOrderCompleted).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}


