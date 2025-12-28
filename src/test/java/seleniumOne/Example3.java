package seleniumOne;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Example3 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +
                "\\src\\test\\resources\\drivers\\chromedriver.exe");

        //(1) Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demoqa.com/automation-practice-form/");
        driver.manage().window().maximize();

        //(2) Input for text fields -- first name and last name driver.findElement(By.xpath(".//*[@id='firstName']")).sendKeys("John"); driver.findElement(By.id("lastName")).sendKeys("Smith");
        //(3) Input for text fields -- Email
        driver.findElement(By.id("userEmail")).sendKeys("example@eee.com");

        //(4) Select radio button -- Male/Female
        List<WebElement> rbnSex = driver.findElements(By.cssSelector("#genterWrapper label"));
        System.out.println(rbnSex.size());
        boolean bValue = false;
        bValue = rbnSex.get(0).isSelected();
        Thread.sleep(4000);
        if (bValue == true) {
            rbnSex.get(1).click();
        } else {
            rbnSex.get(0).click();
        }

        //(5) Input for text fields -- Mobile Number
        driver.findElement(By.id("userNumber")).sendKeys("0006374557");

        //(6) Select Calender - Date of Birth
        int x = driver.findElement(By.id("subjectsContainer")).getLocation().getX();
        int y = driver.findElement(By.id("subjectsContainer")).getLocation().getY();

        //scroll to x y
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + x + ", " + y + ")");

      /*Coordinates coordinate = ( (Locatable) driver.findElement(By.id("subjectsContainer")) ).getCoordinates();
      coordinate.onPage(); coordinate.inViewPort();*/
        driver.findElement(By.id("dateOfBirthInput")).click();
        List<WebElement> dayList = driver.findElements(By.cssSelector(".react-datepicker month - container[role = 'option']"));

        for (int i = 0; i < dayList.size(); i++) {
            String digit = dayList.get(i).getText();
            if (digit.contains("31")) {
                dayList.get(i).click();
                break;
            }
        }

        //(7) Auto Complete Field -- Subjects
        driver.findElement(By.cssSelector("#subjectsContainer input")).sendKeys("Computer Science");
        String subjectToSelect = "Computer Science";

        List<WebElement> subjectList = driver.findElements(By.cssSelector(".subjects- auto-complete option"));

        for (int i = 0; i < subjectList.size(); i++) {
            String subject = subjectList.get(i).getText();
            if (subject.contains(subjectToSelect)) {
                subjectList.get(i).click();
                // This will take the execution out of for loop
                break;
            }
        }

        //(8) Select check box -- Hobbies
        List<WebElement> chkBx_Sports = driver.findElements(By.cssSelector("#hobbiesWrapper .custom-checkbox label"));

        // This will tell you the number of Check Boxes are present
        int iSize = chkBx_Sports.size();

        // Start the loop from first Check Box to last Check Box
        for (int i = 0; i < iSize; i++) {

            // Store the Check Box name to the string variable
            String sValue = chkBx_Sports.get(i).getText();
            System.out.println(sValue);

            // Select the Check Box it the value of the Check Box is same what you are looking for
            if (sValue.equalsIgnoreCase("Music")) {
                chkBx_Sports.get(i).click();
                // This will take the execution out of for loop
                break;
            }
        }

        //(9) Input for text area -- Address
        driver.findElement(By.id("currentAddress")).sendKeys("Maradana Road Colombo 10 ");
        driver.quit();

    }
}