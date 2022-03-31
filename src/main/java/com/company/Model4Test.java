package com.company;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.graphwalker.core.machine.ExecutionContext;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import static java.lang.Thread.sleep;
import static junit.framework.Assert.assertEquals;

public class Model4Test   extends ExecutionContext implements Model4{

    WebDriver webDriver;
    @Override
    public void e_AddToFavourite() throws InterruptedException {
        sleep(4000);
        By search = By.xpath("//*[@id=\"add-to-favorite-detail\"]");
        WebElement l3 = webDriver.findElement(search);
        Actions at3 = new Actions(webDriver);
        at3.moveToElement(l3).click().perform();
        sleep(4000);
        By goToFav = By.xpath("//*[@id=\"header__container\"]/header/div[1]/div[3]/div/div[1]/a");
        WebElement l4 = webDriver.findElement(goToFav);
        Actions at5= new Actions(webDriver);
        at5.moveToElement(l4).click().perform();
    }

    @Override
    public void e_SelectBanner() throws InterruptedException {
        sleep(4000);
        By banner = By.xpath("//*[@id=\"container\"]/div[1]/div[6]/div/div[1]/a");

        WebElement element = webDriver.findElement(banner);
        String strJavaScript = "var element = arguments[0]; var mouseEventObj = document.createEvent('MouseEvents'); mouseEventObj.initEvent( 'mouseover', true, true ); element.dispatchEvent(mouseEventObj);";
        ((JavascriptExecutor) webDriver).executeScript(strJavaScript, element);
        webDriver.findElement(banner).click();
    }

    @Override
    public void e_SelectProduct() throws InterruptedException {
        sleep(4000);
        By product = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/div/div[2]/div[1]/a/div[1]");

        WebElement element = webDriver.findElement(product);
        String strJavaScript = "var element = arguments[0]; var mouseEventObj = document.createEvent('MouseEvents'); mouseEventObj.initEvent( 'mouseover', true, true ); element.dispatchEvent(mouseEventObj);";
        ((JavascriptExecutor) webDriver).executeScript(strJavaScript, element);
        webDriver.findElement(product).click();
    }

    @Override
    public void e_ClearFavourite() {
        By clear = By.className("emi-icon");

        WebElement element = webDriver.findElement(clear);
        String strJavaScript = "var element = arguments[0]; var mouseEventObj = document.createEvent('MouseEvents'); mouseEventObj.initEvent( 'mouseover', true, true ); element.dispatchEvent(mouseEventObj);";
        ((JavascriptExecutor) webDriver).executeScript(strJavaScript, element);
        webDriver.findElement(clear).click();

    }

    @Override
    public void e_ProceedShopping() {
        webDriver.get("https://www.lcwaikiki.com/tr-TR/TR");
    }

    @Override
    public void v_EmptyFavouritePage() throws InterruptedException {
        sleep(4000);
        By emptyBasket = By.xpath("//*[@id=\"divModels\"]/div[3]/a");
        WebElement l3 = webDriver.findElement(emptyBasket);
        assertEquals("ALIŞVERİŞE BAŞLA",l3.getText());

    }

    @Override
    public void v_Start() {
        System.setProperty("webdriver.chrome.driver", "/Users/sabri/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        String baseUrl = "https://www.lcwaikiki.com/tr-TR/TR";
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver(options);
        webDriver.manage().window().setSize(new Dimension(1920, 1080));

        webDriver.get(baseUrl);
    }

    @Override
    public void v_ListPageOpened() throws InterruptedException {
        sleep(4000);
        By banner = By.xpath("  //*[@id=\"root\"]/div/div[2]/div[2]/div[4]/button/span");
        WebElement l = webDriver.findElement(banner);
        assertEquals(l.getText(), "Filtreyi Gizle");
    }

    @Override
    public void v_FavouritePageOpened() throws InterruptedException {
        sleep(4000);
        By banner = By.xpath("//*[@id=\"divModels\"]/h1");
        WebElement l = webDriver.findElement(banner);
        assertEquals(l.getText(), "Favorilerim");
    }

    @Override
    public void v_HomePageOpened() throws InterruptedException {
        sleep(4000);
        String title = "LC Waikiki | İlk Alışverişte Kargo Bedava! - LC Waikiki";
        String webDriverTitle = webDriver.getTitle();
        assertEquals(webDriverTitle, title);
    }

    @Override
    public void v_DetailPageOpened() throws InterruptedException {
        sleep(4000);
        String currentUrl = webDriver.getCurrentUrl();
        Assert.assertTrue( currentUrl.contains("urun"));
    }

    @Override
    public void e_OpenHomePage() {
        webDriver.get("https://www.lcwaikiki.com/tr-TR/TR");
    }
}
