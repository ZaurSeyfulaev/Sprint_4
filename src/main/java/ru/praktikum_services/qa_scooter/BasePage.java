package ru.praktikum_services.qa_scooter;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected final WebDriver webDriver;

    protected BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
