package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCadastro {

    @Test
    public void cadastro() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Manoel");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Silva");
        driver.findElement(By.id("elementosForm:sexo")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();

        new Select(driver.findElement(By.id("elementosForm:escolaridade"))).selectByVisibleText("Mestrado");
        new Select(driver.findElement(By.id("elementosForm:esportes"))).selectByVisibleText("Natacao");

        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
        Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Manoel"));
        Assert.assertEquals("Sobrenome: Silva", driver.findElement(By.id("descSobrenome")).getText());
        Assert.assertEquals("Sexo: Masculino", driver.findElement(By.id("descSexo")).getText());
        Assert.assertEquals("Comida: Pizza", driver.findElement(By.id("descComida")).getText());
        Assert.assertEquals("Escolaridade: mestrado", driver.findElement(By.id("descEscolaridade")).getText());
        Assert.assertEquals("Esportes: Natacao", driver.findElement(By.id("descEsportes")).getText());
        //Assert.assertEquals("diogo", driver.findElement(By.id("descSugestoes")).getText());
        driver.quit();
    }
}
