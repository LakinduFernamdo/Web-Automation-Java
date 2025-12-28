import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Example3 {

    public static void main(String[] args) throws InterruptedException {

        // (1) Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Open the application
        driver.navigate().to("https://demoqa.com/automation-practice-form/");
        driver.manage().window().maximize();

        // (2) Input text fields - First Name & Last Name
        driver.findElement(By.id("firstName")).sendKeys("John");
        driver.findElement(By.id("lastName")).sendKeys("Smith");

        // (3) Input Email
        driver.findElement(By.id("userEmail")).sendKeys("example@eee.com");

        // (4) Select Radio Button - Gender
        List<WebElement> genderRadioButtons =
                driver.findElements(By.cssSelector("#genterWrapper label"));

        boolean isSelected = genderRadioButtons.get(0).isSelected();

        Thread.sleep(2000);

        if (isSelected) {
            genderRadioButtons.get(1).click();
        } else {
            genderRadioButtons.get(0).click();
        }

        // (5) Input Mobile Number
        driver.findElement(By.id("userNumber")).sendKeys("0006374557");

        // (6) Scroll to Date of Birth field
        int x = driver.findElement(By.id("subjectsContainer")).getLocation().getX();
        int y = driver.findElement(By.id("subjectsContainer")).getLocation().getY();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + x + "," + y + ")");

        // Open Date Picker
        driver.findElement(By.id("dateOfBirthInput")).click();

        // Select date = 31
        List<WebElement> dayList =
                driver.findElements(By.cssSelector(".react-datepicker__day"));

        for (WebElement day : dayList) {
            if (day.getText().equals("31")) {
                day.click();
                break;
            }
        }

        // (7) Auto-complete field - Subjects
        driver.findElement(By.id("subjectsInput")).sendKeys("Computer Science");

        Thread.sleep(2000);

        List<WebElement> subjectList =
                driver.findElements(By.cssSelector(".subjects-auto-complete__option"));

        for (WebElement subject : subjectList) {
            if (subject.getText().contains("Computer Science")) {
                subject.click();
                break;
            }
        }

        // (8) Select Checkbox - Hobbies
        List<WebElement> hobbies =
                driver.findElements(By.cssSelector("#hobbiesWrapper label"));

        for (WebElement hobby : hobbies) {
            if (hobby.getText().equalsIgnoreCase("Music")) {
                hobby.click();
                break;
            }
        }

        // (9) Input Address
        driver.findElement(By.id("currentAddress"))
                .sendKeys("Maradana Road Colombo 10");

        Thread.sleep(2000);

        // Close browser
        driver.quit();
    }
}
