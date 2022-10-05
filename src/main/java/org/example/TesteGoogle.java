package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteGoogle {
    @Test
    public  void teste() {
        //precisa setar essa linha se não tiver uma variave de ambiente setada para o chrome driver
        //System.setProperty("webdriver.chromdriver.driver", "\"C:\\chromedriver.exe\"");
        WebDriver driver = new ChromeDriver();
        //tamanho da tela maximizada
        driver.manage().window().maximize();
        //tamanho da tela setada um tamanho fixo
        //driver.manage().window().setPosition(new Dimencion(1200, 765));
        driver.get("http://www.google.com");
        Assert.assertEquals("Google", driver.getTitle());
        driver.quit();
    }
}