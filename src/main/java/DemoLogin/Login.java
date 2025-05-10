package DemoLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login {

    WebDriver cd;
    WebDriverWait wait;
    private By userNameField = By.xpath("//input[@name = 'user-name']");
    private By passwordField = By.xpath("//input[@name = 'password']");
    private By submitButtonField = By.xpath("//input[@type = 'submit']");

    public Login(WebDriver wd){
        this.cd=wd;
        wait=new WebDriverWait(cd, Duration.ofSeconds(10));
    }

    public Login hitUrl(String url)
    {
        cd.get(url);
        return this;
    }

    public Login enterCreds(String username, String pwd)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameField));
        cd.findElement(userNameField).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        cd.findElement(passwordField).sendKeys(pwd);
        return this;
    }

    public Login submit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButtonField));
        cd.findElement(submitButtonField).click();
        return this;
    }
}
