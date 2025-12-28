package seleniumOne;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example1 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +
                "\\src\\test\\resources\\drivers\\chromedriver.exe");

        //(1) Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        //(2) Storing the Application Url in the String variable
        String url = "https://www.ebay.com/";

        //Launch the ToolsQA WebSite driver.get(url); driver.manage().window().maximize();
        //(3) Storing Title name in the String variable
        String title = driver.getTitle();

        //(4) Storing Title length in the Int variable
        int titleLength = driver.getTitle().length();

        // Printing Title & Title length in the Console window System.out.println("Title of the page is : " + title); System.out.println("Length of the title is : "+ titleLength);
        //(5) Storing URL in String variable
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.equals(url)) {
            System.out.println("Verification Successful - The correct Url is opened.");
        } else {
            System.out.println("Verification Failed - An incorrect Url is opened.");
            //In case of Fail, you like to print the actual and expected URL for the record purpose
            System.out.println("Actual URL is : " + actualUrl);
            System.out.println("Expected URL is : " + url);
        }

        //(6) Storing Page Source in String variable
        String pageSource = driver.getPageSource();

        // Storing Page Source length in Int variable
        int pageSourceLength = pageSource.length();

        // Printing length of the Page Source on console
        System.out.println("Total length of the Page Source is : " + pageSourceLength);

        //Closing browser
        driver.quit();

    }
}

