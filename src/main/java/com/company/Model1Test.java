package com.company;

import org.graphwalker.core.machine.ExecutionContext;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.graphwalker.core.machine.ExecutionContext;

import static java.lang.Thread.sleep;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class Model1Test  extends ExecutionContext implements Model1{
    WebDriver webDriver;


    public void e_HomePageRedirection() {
        String title = "LC Waikiki | İlk Alışverişte Kargo Bedava! - LC Waikiki";
        String email = "sabri.korkmaz@lcwaikiki.com";
        String password = "";
        String webDriverTitle = webDriver.getTitle();


    }
    @Override
    public void v_LoginPageOpened() {
        String title = "Üye Girişi - LC Waikiki";
        String email = "sabri.korkmaz@lcwaikiki.com";
        String password = "";
        String webDriverTitle = webDriver.getTitle();
        assertEquals(webDriverTitle, title);
    }


    @Override
    public void v_LoginErrorPageOpened() throws InterruptedException {

        sleep(4000);
        By closeCookie = By.xpath("/*//*[@id=\"login\"]/div/div/div/div/div/p*/");
        WebElement l = webDriver.findElement(closeCookie);
       assertEquals(l.getText(),"Lütfen e-posta ya da şifrenizi kontrol ediniz.");

    }

    @Override
    public void v_Start() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/sabri/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        String baseUrl ="https://www.lcwaikiki.com/tr-TR/TR";
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver(options);
        webDriver.manage().window().setSize(new Dimension(1920,1080));

        webDriver.get(baseUrl);


    }



    @Override
    public void e_IncorrectCredentials() throws InterruptedException {
        sleep(4000);
        By inputEmail = By.xpath("//*[@id=\"login\"]/div/div/div/div/form/div[2]/input");
        webDriver.findElement(inputEmail).sendKeys("sabri_51@hotmail.com");
        By password = By.xpath("//*[@id=\"login\"]/div/div/div/div/form/div[3]/div/input");
        webDriver.findElement(password).sendKeys("asdfasdf.");
        By loginButtonBy = By.xpath("//*[@id=\"login\"]/div/div/div/div/form/button");
        WebElement l3 = webDriver.findElement(loginButtonBy);
        Actions at3 = new Actions(webDriver);
        at3.moveToElement(l3).click().perform();;

    }

    @Override
    public void e_OpenHomePage() throws InterruptedException {
        sleep(2000);
        By closeCookie = By.xpath("//*[@id=\"footer__container\"]/div[2]/div/p[3]/button");
        WebElement l = webDriver.findElement(closeCookie);
        Actions at = new Actions(webDriver);
        at.moveToElement(l).click().perform();
    }


    @Override
    public void e_LoginPageRedirection() {
        webDriver.get("https://www.lcwaikiki.com/tr-TR/TR/giris");
    }

    @Override
    public void v_HomePageOpened() throws InterruptedException {
        sleep(4000);
        String title = "LC Waikiki | İlk Alışverişte Kargo Bedava! - LC Waikiki";
        String email = "sabri.korkmaz@lcwaikiki.com";
        String password = "";
        String webDriverTitle = webDriver.getTitle();
        assertEquals(webDriverTitle, title);

    }

    @Override
    public void e_OpenLogin() {
        By loginOrRegisterButtonBy = By.xpath("//*[@id=\"header__container\"]/header/div[2]/div[3]/div/span/div/a/span");

        By searchBoxBy = By.xpath("//*[@id=\"search\"]");
        WebElement element = webDriver.findElement(loginOrRegisterButtonBy);
        String strJavaScript = "var element = arguments[0]; var mouseEventObj = document.createEvent('MouseEvents'); mouseEventObj.initEvent( 'mouseover', true, true ); element.dispatchEvent(mouseEventObj);";
        ((JavascriptExecutor) webDriver).executeScript(strJavaScript, element);
        webDriver.findElement(loginOrRegisterButtonBy).click();
    }

    @Override
    public void e_LogOut() throws InterruptedException {
        sleep(4000);
        By closeCookie = By.xpath("//*[@id=\"header__container\"]/header/div[2]/div[3]/div/span/div/div/div/div/button");
        WebElement l = webDriver.findElement(closeCookie);
        Actions at = new Actions(webDriver);
        at.moveToElement(l).click().perform();
    }

    @Override
    public void v_AuthenticatedHomePage() throws InterruptedException {
        sleep(4000);
        By account = By.xpath("//*[@id=\"header__container\"]/header/div[2]/div[3]/div/span/div/button/span");
        WebElement l = webDriver.findElement(account);
        Actions at = new Actions(webDriver);
        assertEquals(l.getText(),"Lütfen e-posta ya da şifrenizi kontrol ediniz.");
    }

    @Override
    public void e_CorrectCredentials() throws InterruptedException {
        sleep(4000);
        By inputEmail = By.xpath("//*[@id=\"login\"]/div/div/div/div/form/div[2]/input");
        webDriver.findElement(inputEmail).sendKeys("sabri_51@hotmail.com");
        By password = By.xpath("//*[@id=\"login\"]/div/div/div/div/form/div[3]/div/input");
        webDriver.findElement(password).sendKeys("");
        By loginButtonBy = By.xpath("//*[@id=\"login\"]/div/div/div/div/form/button");
        WebElement l3 = webDriver.findElement(loginButtonBy);
        Actions at3 = new Actions(webDriver);
        at3.moveToElement(l3).click().perform();;

    }


}
