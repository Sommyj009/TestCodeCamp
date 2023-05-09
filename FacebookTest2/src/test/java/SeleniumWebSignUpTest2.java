import net.bytebuddy.build.Plugin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebSignUpTest2 {

    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");

        //Open your new Chrome browser
        driver = new ChromeDriver();

        //Input your Selenium Demo Page URL
        driver.get ("https://selenium-blog.herokuapp.com/");
        Thread.sleep(5000);

        //Test 1- Verify the user input the right url and his on the right webpage
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/"))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong Webpage");
        Thread.sleep(5000);

        //Maximise the browser
        driver.manage().window().maximize();

        //Test 2-   Verify that when a user clicks on the signup button, the user is directed to the sign-up page
        //Click on the sign-up button
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        //verify that the sign-up button leads to the sign-up page
        String expectedPageUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualPageUrl = driver.getCurrentUrl();
        if (actualPageUrl.contains(expectedPageUrl))
            //Pass
            System.out.println("Correct Signup Page");
        else
            //Fail
            System.out.println("Wrong Signup Page");
        Thread.sleep(5000);
    }
    @Test (priority = 0)
    public void negativeSignup() throws InterruptedException {
        //Test 3. Verify that user cannot sign up with username less than 3 characters
        //Input username on the username field
        driver.findElement(By.id("user_username")).sendKeys("si");
        //Input email on the email field
        driver.findElement(By.id("user_email")).sendKeys("jaysim@mailinator.com");
        //Input password in the password field
        driver.findElement(By.id("user_password")).sendKeys("lovelyDate");
        //Click the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
        //Click the Sign-Up Button
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(1000);
    }
    @Test (priority = 1)
    public void negSignup() throws InterruptedException {
       //Test 4. Verify user cannot sign up with invalid email address
        //Input username on the username field
        driver.findElement(By.id("user_username")).sendKeys("Siminto");
        //Input email in the email field
        driver.findElement(By.id("user_email")).sendKeys("jaysim");
        //Input password in password field
        driver.findElement(By.id("user_password")).sendKeys("lovelyDate");
        //Click the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
        //Click the Sign-Up Button
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(1000);
    }
    @Test (priority = 2)
    public void noSignup() throws InterruptedException {
        //Test 5. Verify user cannot log in with password less than or equal to one character
        //Input username on the username field
        driver.findElement(By.id("user_username")).sendKeys("Siminto");
        //Input email in the email field
        driver.findElement(By.id("user_email")).sendKeys("jaysim@mailinator.com");
        //Input password in password field
        driver.findElement(By.id("user_password")).sendKeys("l");
        //Click the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
        //Click the Sign-Up Button
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(1000);
    }
    @Test (priority = 3)
    public void doNotSignup() throws InterruptedException {
        //Test 6. Verify user cannot sign up with either or all the fields blank
        //Input username on the username field
        driver.findElement(By.id("user_username")).sendKeys("");
        //Input email in the email field
        driver.findElement(By.id("user_email")).sendKeys("");
        //Input password in password field
        driver.findElement(By.id("user_password")).sendKeys("");
        //Click the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
        //Click the Sign-Up Button
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(1000);
    }
    @Test (priority = 4)
    public void positiveSignup() throws InterruptedException {
        //Test 7. Verify that user is successfully signed up when valid details are inputted
        //Input username on the username field
        driver.findElement(By.id("user_username")).sendKeys("Siminto1");
        //Input email in the email field
        driver.findElement(By.id("user_email")).sendKeys("jaysim1@mailinator.com");
        //Input password in password field
        driver.findElement(By.id("user_password")).sendKeys("loveDay1");
        //Click the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }
    @Test (priority = 5)
    public void verifyItem() throws InterruptedException {
        //Test 8. Verify that User1 item is present on the item list page
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a"));
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/users"))
            //Pass
            System.out.println("Correct Item");
        else
            //Fail
            System.out.println("Wrong Item");
        Thread.sleep(5000);
    }
    @Test (priority = 6)
    public void verifySearch() throws InterruptedException {
        //Test 9. Verify that the item searched for on the User1 page is present
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        String expectedPageUrl = "https://selenium-blog.herokuapp.com/users/1";
        String actualPageUrl = driver.getCurrentUrl();
        if (actualPageUrl.contains(expectedPageUrl))
            //Pass
            System.out.println("Item is present");
        else
            //Fail
            System.out.println("Item is not present");
        Thread.sleep(5000);
    }
    @Test (priority = 7)
    public void verifyLogOut() throws InterruptedException{
        //Test 10. Verify that when the user logs out, he/she is directed back to the home page
        driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[3]/a")).click();
        String expectedPageUrl = "https://selenium-blog.herokuapp.com/";
        String actualPageUrl = driver.getCurrentUrl();
        if (actualPageUrl.contains(expectedPageUrl))
            //Pass
            System.out.println("Correct homepage");
        else
            //Fail
            System.out.println("Incorrect homepage");
        Thread.sleep(1000);
    }
    @AfterTest
    public void closeBrowser() {
        //Close Browser
        driver.quit();
    }
}
