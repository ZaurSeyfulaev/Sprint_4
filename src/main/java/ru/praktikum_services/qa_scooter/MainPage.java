package ru.praktikum_services.qa_scooter;

import com.sun.jna.WString;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {
    //Верхняя ктопка Заказать
    private By orderTopButton = By.xpath("(.//button[text()='Заказать'])[1]");
    //Нижняя ктопка Заказать
    private By orderBottomButton = By.xpath("(.//button[text()='Заказать'])[2]");
    //Аккардион - вопрос
    private String accordionQuestion = ".//div[text()='%s']";
    //Ответ
    private String accordionAnswer = ".//p[text()='%s']";

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    // Скрол строницы до нужного элемента
    public void scrollPage(WebElement element) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //Клик по кнопке заказать вверху страницы
    public void clickOrderTopButton() {
        webDriver.findElement(orderTopButton).click();
    }

    //Клик по кнопке заказать внизу страницы
    public void clickOrderBottomButton() {
        WebElement element = webDriver.findElement(orderBottomButton);
        scrollPage(element);
        element.click();
    }

    public void clickOnQuestion(String question) {
        WebElement element = webDriver.findElement(By.xpath(String.format(accordionQuestion, question)));
        scrollPage(element);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", element);
    }

    public String getAnswer(String answer) {
        return webDriver.findElement(By.xpath(String.format(accordionAnswer, answer))).getText();

    }
}
