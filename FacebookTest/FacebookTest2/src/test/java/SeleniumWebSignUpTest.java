import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//**   8. Verify that User1 item is present on the item list page.
//
public class SeleniumWebSignUpTest {

    private WebDriver driver;

        @BeforeTest
        public void start() throws InterruptedException {

            //locate where the chromedriver is
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver/chromedriver");

            //1. Open your chrome browser
            driver = new ChromeDriver();

            //2. Input your Selenium Demopage URL
            driver.get("https://selenium-blog.herokuapp.com/");
            //Test 1: Verify user inputs the right url and is on the right webpage
            if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/"))
                //Pass
                System.out.println("Correct Webpage");
            else
                //Fail
                System.out.println("Wrong Webpage");

            Thread.sleep(1000);

            //3. Maximise the browser
            driver.manage().window().maximize();
            Thread.sleep(1000);

            //4. Click on SignUp button to open the sign up page
            driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();

            Thread.sleep(1000);

            positiveSignup();
        }

        @Test (priority = 0)
        public void positiveSignup() throws InterruptedException {
            //Test 7. Verify that user is successfully signed up when valid details are inputted
            //5. Input your username on the username field
            driver.findElement(By.id("user_username")).sendKeys("Sommygirly12");
            //6. Input your email in the email field
            driver.findElement(By.id("user_email")).sendKeys("jaysommie12@mailinator.com");
            //7.locate your password and input password
            driver.findElement(By.id("user_password")).sendKeys("sommy009Sommy@");
            //8. Click the sign up button
            driver.findElement(By.id("submit")).click();
            //9. Wait for success message
            Thread.sleep(5000);

            clickUser1Item();
        }

        @Test (priority = 1)
        public void clickUser1Item() throws InterruptedException {
            //10. Click on the user1 item on the list page
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]")).click();
            //Test 2: Verify that when user clicks on the signup button, the user is directed to the signup page
            String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
            String actualUrl = driver.getCurrentUrl();
            if (actualUrl.contains(expectedUrl))
                //Pass
                System.out.println("Correct Webpage");
            else
                //Fail
                System.out.println("Wrong Webpage");
            Thread.sleep(5000);

            verItem();
        }

        @Test (priority = 2)
        public void verItem() throws InterruptedException {
            //11. Search for an item (Using Python with Selenium) and confirm it is present
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
            Thread.sleep(5000);

            verifyItem();
        }

        @Test (priority = 3)
        public void verifyItem() throws InterruptedException {
            //Test 9. Verify that the item searched for on the User1 page is present.
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
            String expectedPageUrl = "https://selenium-blog.herokuapp.com/users/1";
            String actualPageUrl = driver.getCurrentUrl();
            if (actualPageUrl.contains(expectedPageUrl))
                //Pass
                System.out.println("Correct UserPage");
            else
                //Fail
                System.out.println("Wrong UserPage");
            Thread.sleep(5000);

            logoutSuccessfully();
        }

        @Test (priority = 4)
        public void logoutSuccessfully(){
        //12. Logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        //Test 10. Verify that when the user logout, he/she is directed back to the home page
        String expectedTitle = "AlphaBlog";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle))
            //Pass
            System.out.println("Correct WebPage");
        else
            //Fail
            System.out.println("Wrong WebPage");
   }

    @Test (priority = 5)
    public void negativeSignup() throws InterruptedException {
        //Test 3: Verify that user cannot signup with username less than 3 characters
        //5. Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("so");
        //6. Input your email in the email field
        driver.findElement(By.id("user_email")).sendKeys("sommyjay2@mailinator.com");
        //7.locate your password and input password
        driver.findElement(By.id("user_password")).sendKeys("Sommy009sommy@");
        //8. Click the sign up button
        driver.findElement(By.id("submit")).click();
        //9. Wait for success message
        Thread.sleep(5000);

        //12. Login
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[1]/a")).click();

        negSignup();
    }

    @Test (priority = 6)
    public void negSignup() throws InterruptedException {
        //Test 4. Verify user cannot sign up with invalid email address
        //5. Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("sommyj078");
        //6. Input your email in the email field
        driver.findElement(By.id("user_email")).sendKeys("sommyjay2");
        //7.locate your password and input password
        driver.findElement(By.id("user_password")).sendKeys("Sommy009sommy@");
        //8. Click the sign up button
        driver.findElement(By.id("submit")).click();
        //9. Wait for success message
        Thread.sleep(5000);

        //12. Login
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[1]/a")).click();

        noSignup();
    }

    @Test (priority = 7)
    public void noSignup() throws InterruptedException {
        //Test 5. Verify user cannot login with password less than or equal to one character
        //5. Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("sommyj079");
        //6. Input your email in the email field
        driver.findElement(By.id("user_email")).sendKeys("sommyjay5@mailinator.com");
        //7.locate your password and input password
        driver.findElement(By.id("user_password")).sendKeys("");
        //8. Click the sign up button
        driver.findElement(By.id("submit")).click();
        //9. Wait for success message
        Thread.sleep(5000);

        //12. Login
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[1]/a")).click();

        notSignup();
    }

    @Test (priority = 8)
    public void notSignup() throws InterruptedException {
        //Test 6. Verify user cannot signup with either/all of the fields blank
        //5. Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("");
        //6. Input your email in the email field
        driver.findElement(By.id("user_email")).sendKeys("");
        //7.locate your password and input password
        driver.findElement(By.id("user_password")).sendKeys("");
        //8. Click the sign up button
        driver.findElement(By.id("submit")).click();
        //9. Wait for success message
        Thread.sleep(5000);

        //12. Login
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[1]/a")).click();

        Thread.sleep(5000);

    }

    @AfterTest
    public void closeBrowser() {
        //Quit the browser
        driver.quit();
    }
}

