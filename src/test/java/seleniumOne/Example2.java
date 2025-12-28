package seleniumOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Example2 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +
                "\\src\\test\\resources\\drivers\\chromedriver.exe");

        //(1) Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        //(2) Open the URL
        driver.navigate().to("http://demo.guru99.com/test/newtours/");

        //(3) Maximize the window
        driver.manage().window().maximize();

        //(4) Input User name and Password
        driver.findElement(By.name("userName")).sendKeys("tutorials");
        driver.findElement(By.name("password")).sendKeys("tutorials");
        driver.findElement(By.name("submit")).click();
        Thread.sleep(2000);

        driver.get("https://demo.guru99.com/test/newtours/reservation.php");

        //driver.findElement(By.xpath(".//*[contains(text(),'Flights')]")).click();

        //(5) In Flight Details select the option One way
        driver.findElement(By.xpath("//*[@value='oneway']")).click();

        //(6) Select the passenger count for the flight by the Index
        Select oSelect = new Select(driver.findElement(By.name("passCount")));
        oSelect.selectByIndex(3);

        //(7) Select the Departing Airport by the Value
        Select fromPort = new Select(driver.findElement(By.name("fromPort")));
        fromPort.selectByValue("New York");

        //(8) Select the Departing Month by the Value
        Select fromMonth = new Select(driver.findElement(By.name("fromMonth")));
        fromMonth.selectByValue("8");
        Select fromDate = new Select(driver.findElement(By.name("fromDay")));
        fromDate.selectByValue("15");

        //(9) Select the Arriving Airport by the Value
        Select toPort = new Select(driver.findElement(By.name("toPort")));
        toPort.selectByValue("Paris");

        //(10) Select the Arriving Month by selectByVisibleText as name is not visible Select toMonth = new Select(driver.findElement(By.name("toMonth"))); toMonth.selectByVisibleText("September");
        Select toDate = new Select(driver.findElement(By.name("toDay")));
        toDate.selectByValue("25");

        //(11) Select Service Class
        driver.findElement(By.xpath("//*[@value='Business']")).click();

        //(12) Select Airline
        Select airline = new Select(driver.findElement(By.name("airline")));
        airline.selectByVisibleText("Blue Skies Airlines");

        //(13)List of Elements
        List<WebElement> options =
                driver.findElements(By.xpath("//*[@name='airline']//option"));
        int sizeOfOption = options.size();
        for (int i = 0; i < sizeOfOption; i++) {
            System.out.println(options.get(i).getText());
        }
        driver.findElement(By.name("findFlights")).click();
        Thread.sleep(2000);
        driver.quit();

    }
}