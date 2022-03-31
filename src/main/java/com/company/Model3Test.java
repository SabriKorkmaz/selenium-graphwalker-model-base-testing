package com.company;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.graphwalker.core.machine.ExecutionContext;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import static java.lang.Thread.interrupted;
import static java.lang.Thread.sleep;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class Model3Test   extends ExecutionContext implements Model3{
    WebDriver webDriver;
    @Override
    public void v_DetailPage() throws InterruptedException {
        sleep(4000);
        String currentUrl = webDriver.getCurrentUrl();
        Assert.assertTrue( currentUrl.contains("urun"));
    }

    @Override
    public void e_ProceedShopping() {
        webDriver.get("https://www.lcwaikiki.com/tr-TR/TR");
    }

    @Override
    public void e_DetailPage() throws InterruptedException {
        sleep(4000);
        By banner = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/div/div[2]/div[1]/a/div[1]");

        WebElement element = webDriver.findElement(banner);
        String strJavaScript = "var element = arguments[0]; var mouseEventObj = document.createEvent('MouseEvents'); mouseEventObj.initEvent( 'mouseover', true, true ); element.dispatchEvent(mouseEventObj);";
        ((JavascriptExecutor) webDriver).executeScript(strJavaScript, element);
        webDriver.findElement(banner).click();

    }

    @Override
    public void e_IncreaseProduct() throws InterruptedException {
        sleep(4000);
        By search = By.className("oq-up");
        WebElement l3 = webDriver.findElement(search);
        Actions at3 = new Actions(webDriver);
        at3.moveToElement(l3).click().perform();
    }

    @Override
    public void e_EmptyBasket() {
        By count = By.className("item-quantity-input");
        WebElement l3 = webDriver.findElement(count);

            By search = By.className("fa-trash-o");
            WebElement l2 = webDriver.findElement(search);
            Actions at3 = new Actions(webDriver);
            at3.moveToElement(l2).click().perform();
    }

    @Override
    public void e_CheckoutBasket() throws InterruptedException {
        sleep(4000);
        By payment = By.xpath("//*[@id=\"ShoppingCartContent\"]/div[1]/div[2]/div[1]/a");
        WebElement l3 = webDriver.findElement(payment);
        Actions at3 = new Actions(webDriver);
        at3.moveToElement(l3).click().perform();

    }

    @Override
    public void v_HomePage() throws InterruptedException {
        sleep(4000);
        String title = "LC Waikiki | İlk Alışverişte Kargo Bedava! - LC Waikiki";
        String webDriverTitle = webDriver.getTitle();
        assertEquals(webDriverTitle, title);
    }

    @Override
    public void v_CheckoutPage() throws InterruptedException {
        sleep(4000);
        String currentUrl = webDriver.getCurrentUrl();
        Assert.assertTrue( currentUrl.contains("checkout"));
    }

    @Override
    public void e_OpenHomePage() {
        webDriver.get("https://www.lcwaikiki.com/tr-TR/TR");
    }

    @Override
    public void v_EmptyBasketPage() throws InterruptedException {
        sleep(4000);
        By emptyBasket = By.xpath("//*[@id=\"ShoppingCartContent\"]/div[1]/div[1]/div/a");
        WebElement l3 = webDriver.findElement(emptyBasket);
        assertEquals("ALIŞVERİŞE BAŞLA",l3.getText());

    }

    @Override
    public void v_IncreasedBasketPage() throws InterruptedException {
        sleep(4000);
        By count = By.className("item-quantity-input");
        WebElement l3 = webDriver.findElement(count);
        int loop = Integer.parseInt(l3.getAttribute("value"));
        assertTrue(loop>1);
    }

    @Override
    public void e_AddToBasket() throws InterruptedException {
        sleep(4000);
        By basket = By.xpath("//*[@id=\"option-size\"]/a[1]");
        WebElement l3 = webDriver.findElement(basket);
        Actions at3 = new Actions(webDriver);
        at3.moveToElement(l3).click().perform();
        sleep(4000);
        By basketAdd = By.xpath("//*[@id=\"pd_add_to_cart\"]");
        WebElement l2 = webDriver.findElement(basketAdd);
        Actions at2 = new Actions(webDriver);
        at2.moveToElement(l2).click().perform();
        By goToBasket = By.xpath("//*[@id=\"header__container\"]/header/div[1]/div[3]/div/div[2]/a");
        WebElement l4 = webDriver.findElement(goToBasket);
        Actions at5= new Actions(webDriver);
        at5.moveToElement(l4).click().perform();


    }

    @Override
    public void e_StartShopping() {
        webDriver.get("https://www.lcwaikiki.com/tr-TR/TR");
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
    public void e_OpenCategory() throws InterruptedException {
        sleep(4000);
        webDriver.get("https://www.lcwaikiki.com/tr-TR/TR/yeni-gelenler/erkek");

    }

    @Override
    public void v_CategoryPage() throws InterruptedException {
        sleep(4000);
        String currentUrl = webDriver.getCurrentUrl();
        Assert.assertTrue( currentUrl.contains("erkek"));
    }

    @Override
    public void v_BasketPage() throws InterruptedException {
        sleep(4000);
        String currentUrl = webDriver.getCurrentUrl();
        Assert.assertTrue( currentUrl.contains("sepetim"));
    }
}
