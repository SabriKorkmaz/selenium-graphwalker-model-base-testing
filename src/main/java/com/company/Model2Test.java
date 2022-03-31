package com.company;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.graphwalker.core.machine.ExecutionContext;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.Objects;

import static java.lang.Thread.sleep;
import static junit.framework.Assert.assertEquals;

public class Model2Test extends ExecutionContext implements Model2 {
    WebDriver webDriver;

    @Override
    public void e_ClickLogo() throws InterruptedException {
        sleep(4000);
        By logo = null;
        boolean mainPage = Objects.equals(webDriver.getCurrentUrl(), "https://www.lcwaikiki.com/tr-TR/TR");
        if (mainPage) {
            logo = By.xpath("//*[@id=\"header__container\"]/header/div[2]/div[1]/a");

        } else {
            logo = By.xpath("//*[@id=\"header__container\"]/header/div[1]/div[1]/a");
        }

        By searchBoxBy = By.xpath("//*[@id=\"search\"]");
        WebElement element = webDriver.findElement(logo);
        String strJavaScript = "var element = arguments[0]; var mouseEventObj = document.createEvent('MouseEvents'); mouseEventObj.initEvent( 'mouseover', true, true ); element.dispatchEvent(mouseEventObj);";
        ((JavascriptExecutor) webDriver).executeScript(strJavaScript, element);
        webDriver.findElement(logo).click();

    }

    @Override
    public void v_SearchPageWithProduct() throws InterruptedException {
        sleep(4000);
        String currentUrl = webDriver.getCurrentUrl();
        Assert.assertTrue( currentUrl.contains("PageIndex=2"));
    }

    @Override
    public void e_ClickBanner() throws InterruptedException {
        sleep(4000);
        By banner = By.xpath("//*[@id=\"container\"]/div[1]/div[6]/div/div[1]/a");

        WebElement element = webDriver.findElement(banner);
        String strJavaScript = "var element = arguments[0]; var mouseEventObj = document.createEvent('MouseEvents'); mouseEventObj.initEvent( 'mouseover', true, true ); element.dispatchEvent(mouseEventObj);";
        ((JavascriptExecutor) webDriver).executeScript(strJavaScript, element);
        webDriver.findElement(banner).click();
    }

    @Override
    public void v_SearchPage() throws InterruptedException {
        sleep(4000);
        By banner = By.xpath("  //*[@id=\"root\"]/div/div[2]/div[2]/div[4]/button/span");
        WebElement l = webDriver.findElement(banner);
        assertEquals(l.getText(), "Filtreyi Gizle");
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
    public void v_ListPage() throws InterruptedException {
        sleep(4000);
        By banner = By.xpath("  //*[@id=\"root\"]/div/div[2]/div[2]/div[4]/button/span");
        WebElement l = webDriver.findElement(banner);
        assertEquals(l.getText(), "Filtreyi Gizle");
    }

    @Override
    public void v_HomePage() throws InterruptedException {
        sleep(4000);
        String title = "LC Waikiki | İlk Alışverişte Kargo Bedava! - LC Waikiki";
        String webDriverTitle = webDriver.getTitle();
        assertEquals(webDriverTitle, title);
    }

    @Override
    public void e_OpenHomePage() {
        webDriver.get("https://www.lcwaikiki.com/tr-TR/TR");
    }

    @Override
    public void e_ClickMoreProduct() {
        By moreProduct = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/div/div[2]/div[97]/button/span[1]");

        WebElement element = webDriver.findElement(moreProduct);
        String strJavaScript = "var element = arguments[0]; var mouseEventObj = document.createEvent('MouseEvents'); mouseEventObj.initEvent( 'mouseover', true, true ); element.dispatchEvent(mouseEventObj);";
        ((JavascriptExecutor) webDriver).executeScript(strJavaScript, element);
        webDriver.findElement(moreProduct).click();

    }

    @Override
    public void e_TrySearch() throws InterruptedException {
        sleep(4000);
        By input = By.xpath("//*[@id=\"search-form__input-field__search-input\"]\n");
        webDriver.findElement(input).sendKeys("pantolon");
        sleep(4000);
        By search = By.className("search-form__input-field__btn-search");
        WebElement l3 = webDriver.findElement(search);
        Actions at3 = new Actions(webDriver);
        at3.moveToElement(l3).click().perform();
    }
}
