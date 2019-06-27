import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;


public class GradeReport {



    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "Driver/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://portal.aait.edu.et");
        System.out.println(" ");
        System.out.println("Portal Website.");
        System.out.println(" ");

        /*log in to the portal*/
        driver.findElement(By.id("UserName")).sendKeys("ATR/2784/09");
        driver.findElement(By.id("Password")).sendKeys("0223");
        driver.findElement(By.className("btn-success")).click();
        /****************/

        /*Go to grade report*/
        driver.navigate().to("https://portal.aait.edu.et/Grade/GradeReport");
        List<WebElement> graderows = driver.findElements(By.tagName("tr"));
        StringBuilder gradeReport;
        gradeReport = new StringBuilder();
        for (WebElement  row:
                graderows) {
            for (WebElement td:
                    row.findElements(By.tagName("td"))) {
                gradeReport.append(td.getText()).append("  ");
            }
            gradeReport.append("\n");
        }

        Printer pr= new Printer();
        pr.print(gradeReport.toString());

        driver.close();

    }
}
