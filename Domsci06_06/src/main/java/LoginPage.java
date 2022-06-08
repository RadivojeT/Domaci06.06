import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
    private By makeAppointmentBtn = By.id("btn-make-appointment");
    private By username = By.name("username");
    private By password = By.name("password");
    private By login = By.id("btn-login");

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void enterUsername(String username){
        getDriver().findElement(this.username).sendKeys(username);
    }
    public void enterPassword(String password){
        getDriver().findElement(this.password).sendKeys(password);
    }
    public void clickMakeAppointmentBtn(){
        getDriver().findElement(makeAppointmentBtn).click();
    }
    public void login(String username, String password) throws InterruptedException {
        clickMakeAppointmentBtn();
        Thread.sleep(1000);
       // clearField(this.username);
        enterUsername(username);
      //  clearField(this.password);
        enterPassword(password);
        clickLoginButton();
    }
    public void clickLoginButton(){
        getDriver().findElement(login).click();
    }
}
