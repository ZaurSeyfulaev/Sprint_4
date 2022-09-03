package ru.praktikum_services.qa_scooter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

public class ScooterOrderTest extends BaseUiTest {

    @Test
    public void orderInformationWindowShouldAppearFirstDataSet() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickOrderTopButton();

        СustomerInformationPage customerInformationPage = new СustomerInformationPage(webDriver);
        customerInformationPage.fillCustomerInformation("Василий",
                "Аристархович",
                "Пушкина дом 2",
                "Лубянка",
                "+79312334545");
        customerInformationPage.clickNextButton();

        RentalPage rentalPage = new RentalPage(webDriver);
        Assert.assertTrue(rentalPage.checkTransitionToRentalPage());
        rentalPage.fillRentalInformation("01.09.2022",
                "двое суток",
                "Стучать три раза");
        rentalPage.clickOrderButton();

        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(webDriver);
        Assert.assertTrue(orderConfirmationPage.isDisplayedOrderConfirmationPage());
        orderConfirmationPage.clickButtonYes();
        //Было условие что все тесты должны проходить. Поэтому assertFalse
        Assert.assertTrue("Не открылось окно подтверждения заказа",orderConfirmationPage.isDisplayedOrderStatus());
    }

    @Test
    public void orderInformationWindowShouldAppearSecondDataSet() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickOrderTopButton();

        СustomerInformationPage customerInformationPage = new СustomerInformationPage(webDriver);
        customerInformationPage.fillCustomerInformation("Игнатий",
                "Кабачков",
                "Лермонтова дом 3",
                "Улица Академика Янгеля",
                "+79312333333");
        customerInformationPage.clickNextButton();

        RentalPage rentalPage = new RentalPage(webDriver);
        Assert.assertTrue(rentalPage.checkTransitionToRentalPage());
        rentalPage.fillRentalInformation("01.09.2022",
                "семеро суток",
                "Бейте в дверь ногой");
        rentalPage.clickOrderButton();

        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(webDriver);
        Assert.assertTrue(orderConfirmationPage.isDisplayedOrderConfirmationPage());
        orderConfirmationPage.clickButtonYes();
        //Было условие что все тесты должны проходить. Поэтому assertFalse
        Assert.assertTrue("Не открылось окно подтверждения заказа",orderConfirmationPage.isDisplayedOrderStatus());
    }
}
