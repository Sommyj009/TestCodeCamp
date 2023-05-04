import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumWebSignUpTest {

    private WebDriver driver;

    public void start(){

        System.setProperty("webdriver.chrome.driver" "resources/chromedriver/chromedriver");

        //1. Open your chrome browser
        driver = new ChromeDriver();

        //2. Input your Selenium Demopage URL
        driver.get("https://selenium-blog.herokuapp.com/");
        Thread.sleep(10000);

        //3. Maximise the browser
        driver.manage().window().maximize();

        //4. Click on SignUp button to open the sign up page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();

        //5. Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("sommyj009");

        //6. Input your email in the email field
        driver.findElement(By.id("user_email")).sendKeys("sommyj@mailinator.com");

        //7.locate your password and input password
        driver.findElement(By.id("user_password")).sendKeys("Sommy009sommy@");

        //8. Click the sign up button
        driver.findElement(By.id("user_password")).click();

        //9. Wait for success message
        Thread.sleep(5000);

        //10. Click on the meaghan item on the list page
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div")).click();

        //11. Search for an item (Using Python with Selenium) and confirm it is present
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]")).click();

        //12. Logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();







    }

}
