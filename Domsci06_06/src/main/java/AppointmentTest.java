import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AppointmentTest {
    private WebDriver driver;
    private WebDriverWait driverWait;
    private AppointmentPage appointmentPage;
    private SummaryPage summaryPage;
    private LoginPage loginPage;

    private final String visitDate = "05/06/2022";
    private final String addComment = "Mene poslo brat od strica da se kod vas pregledam." +
            "Inace jako dobar drug doktora Lovrica. Pa da mi to sredite.";

    @BeforeClass
    public void BeforeClass(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\mlade\\IdeaProjects\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        appointmentPage = new AppointmentPage(driver,driverWait);
        summaryPage = new SummaryPage(driver,driverWait);
        loginPage = new LoginPage(driver,driverWait);

        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
    }
    @Test(priority = 1)
    public void login() throws InterruptedException {
        loginPage.login("John Doe","ThisIsNotAPassword");
        Assert.assertTrue(appointmentPage.isFormPresented());

    }
    @Test (priority = 2)
    public void appointmentForm(){
       //  appointmentPage.enterFacilityHongkong();
        appointmentPage.hospitalReadmission();
        //  appointmentPage.healtcare();
        appointmentPage.enterDate(visitDate);
        appointmentPage.enterComment(addComment);
        appointmentPage.clickBookAppointmentBtn();

        Assert.assertEquals(addComment,summaryPage.commentConfirmationReport());

    }
}
