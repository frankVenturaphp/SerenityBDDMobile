package com.bdd.pageobjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Page extends PageObject {

    protected final WebDriver driver;
    //KeyEvent
    public final static int BACK_BUTTON = 4;

    public Page(WebDriver driver) {
        this.driver = ThucydidesWebDriverSupport.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String generateDate()
    {
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        return simpleDate.format(date);
    }

    public void elementIsPresent(final AndroidDriver driver, WebElement element, long time)
    {

        try {
            Assert.assertTrue(element.isDisplayed());

        } catch (Exception e) {System.out.println("CATCH :"+e);}

    }

    public static void sleep(String duration) throws InterruptedException
    {
        int time = Integer.parseInt(duration)*1000;
        Thread.sleep(time);
    }

    public void popUpHandler(final AndroidDriver driver, final WebElement element) {
        Thread one = new Thread() {
            public void run() {
                try
                {
                    element.click();
                } catch (Exception e) {
                    //System.out.println("CATCH :"+e);
                }
            }
        };
        one.start();
    }


}
