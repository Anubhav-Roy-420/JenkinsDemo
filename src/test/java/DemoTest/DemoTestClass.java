package DemoTest;

import DemoLogin.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DemoTestClass {

    WebDriver cd;
    Login lp;


    @BeforeTest
    public void setup() throws MalformedURLException {
        ChromeOptions chromeOptions=new ChromeOptions();
        cd=new RemoteWebDriver(new URL("http://192.168.29.87:4444"),chromeOptions);
        lp=new Login(cd);
        cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void LoginSetup()
    {
        lp.hitUrl("https://www.saucedemo.com/").
                enterCreds("standard_user","secret_sauce").
                submit();
        String product=cd.findElement(By.xpath("//span[@class= 'title']")).getText();
        System.out.println(product);
        Assert.assertEquals("Products",product,"Login failed" );
    }

}
