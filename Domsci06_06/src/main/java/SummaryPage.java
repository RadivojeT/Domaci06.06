import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummaryPage extends BasePage{
    private By facilityConfirmation = By.id("facility");
    private By readmissionConfirmation = By.id("hospital_readmission");
    private By dateConfirmation = By.id("visit_date");
    private By commentConfirmation = By.id("comment");
    private By goToHomepageBtn = By.xpath("/html/body/section/div/div/div[7]/p/a");

    public SummaryPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }


    public String facilityConfirmationReport (){
        return getDriver().findElement(facilityConfirmation).getText();
    }
    public String hospitalReadmissionConfirmationReport (){
        return getDriver().findElement(readmissionConfirmation).getText();
    }
    public String visitDateConfirmationReport () {
        return getDriver().findElement(dateConfirmation).getText();
    }
    public String commentConfirmationReport (){
        return getDriver().findElement(commentConfirmation).getText();
    }
    public void clickHomePageBtn(){
        getDriver().findElement(goToHomepageBtn).click();
    }

    public By getFacilityConfirmation() {
        return facilityConfirmation;
    }

    public By getReadmissionConfirmation() {
        return readmissionConfirmation;
    }

    public By getDateConfirmation() {
        return dateConfirmation;
    }

    public By getCommentConfirmation() {
        return commentConfirmation;
    }

    public By getGoToHomepageBtn() {
        return goToHomepageBtn;
    }
}
