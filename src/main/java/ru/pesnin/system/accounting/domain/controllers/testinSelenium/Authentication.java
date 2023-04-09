package ru.pesnin.system.accounting.domain.controllers.testinSelenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Authentication {
    public static void main(String[] args) {
        //Получаем драйвер браузера
        WebDriver driver = new InternetExplorerDriver();
        //Открывает страницу для теста
        driver.get("http://localhost:3000/auth");
        //Ищем элемент логина
        var getElLogin = driver.findElement(By.id("login"));
        //Нажать на поле логина
        getElLogin.click();
        //Задаем значение
        getElLogin.sendKeys("rico45");

        //Ищем элемент пароля
        var getElPass = driver.findElement(By.id("password"));
        //Нажать на поле пароля
        getElPass.click();
        //Задаем значение
        getElPass.sendKeys("1234");

        //Нажимаем на кнопку [вход]
        var getNext = driver.findElement(By.id("mb-4 w-100"));
        getNext.click();



    }
}
