import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppointmentPage extends BasePage {
    private By facility = By.id("combo_faciliy");
    private By readmission = By.id("chk_hospotal_readmission");
    private By radio = By.xpath("//*[@name='programs'][@value='\"+radioInputName+\"']");
    private By date = By.id("txt_visit_date");
    private By comment = By.id("txt_comment");
    private By bookAppointmentBtn = By.id("btn-book-appointment");

    public AppointmentPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);

    }
    public void enterFacilityTokyo (){
        Select facilityFromList = new Select(getDriver().findElement(facility));
        facilityFromList.selectByVisibleText("Tokyo CURA Healthcare Center");
    }
    public void enterFacilityHongkong (){

        Select facilityFromList = new Select(getDriver().findElement(facility));
        facilityFromList.selectByVisibleText("Hongkong CURA Healthcare Center");
    }
    public void enterFacilitySeoul (){
        Select facilityFromList = new Select(getDriver().findElement(facility));
        facilityFromList.selectByVisibleText("Seoul CURA Healthcare Center");
    }

    public void hospitalReadmission () {
        getDriver().findElement(readmission).click();
    }
    public void healtcare (){
        getDriver().findElement(radio).click();
    }
    public void enterDate (String visitDate){
        getDriver().findElement(date).sendKeys(visitDate);
    }
    public void enterComment (String addComment){
        getDriver().findElement(comment).sendKeys(addComment);
    }
    public void clickBookAppointmentBtn (){
        getDriver().findElement(bookAppointmentBtn).click();
    }


    public By getFaciliti() {
        return facility;
    }

    public By getReadmission() {
        return readmission;
    }

    public By getRadio() {
        return radio;
    }

    public By getDate() {
        return date;
    }

    public By getComment() {
        return comment;
    }

    public By getBookAppointmentBtn() {
        return bookAppointmentBtn;
    }
    public boolean isFormPresented(){
        String urlActual = getDriver().getCurrentUrl();
        if (urlActual.equals("https://katalon-demo-cura.herokuapp.com/#appointment")){
            return true;
        }
        return false;

    }
}
