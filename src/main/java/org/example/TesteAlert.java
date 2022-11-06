package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAlert {
    @Test
    public void deveInteragirAletSimples() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        driver.findElement(By.id("alert")).click();
        Alert alert =driver.switchTo().alert();
        String texto = alert.getText();
        Assert.assertEquals("Alert Simples", texto);
        alert.accept();
        driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
        driver.quit();

    }
    @Test
    public void deveInteragirConfirmSimples() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        driver.findElement(By.id("confirm")).click();
        Alert alert = driver.switchTo().alert();
        String texto = alert.getText();
        Assert.assertEquals("Confirm Simples", texto);
        alert.accept();
        Assert.assertEquals("Confirmado", alert.getText());
        alert.accept();
        driver.findElement(By.id("confirm")).click();
        Assert.assertEquals("Confirm Simples", alert.getText());
        alert.dismiss();
        Assert.assertEquals("Negado", alert.getText());
        alert.accept();
        driver.quit();

    }
    @Test
    public void deveInteragirPrompt() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        driver.findElement(By.id("prompt")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Digite um numero", alert.getText());
        alert.sendKeys("1234");
        alert.accept();
        Assert.assertEquals("Era 1234?", alert.getText());
        alert.accept();
        alert.accept();
        driver.findElement(By.id("prompt")).click();
        alert.sendKeys("1234");
        alert.dismiss();
        Assert.assertEquals("Era null?", alert.getText());
        alert.accept();
        alert.accept();
        driver.findElement(By.id("prompt")).click();
        alert.sendKeys("1234");
        alert.dismiss();
        Assert.assertEquals("Era null?", alert.getText());
        alert.dismiss();
        Assert.assertEquals(":(", alert.getText());
        alert.accept();
        driver.quit();
    }
}
