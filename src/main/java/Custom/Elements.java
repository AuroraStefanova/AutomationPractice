package Custom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Elements {
    WebDriver driver;
    public Elements(WebDriver driver){
        this.driver = driver;
    }
    public WebElement chooseOptionHeadAndSalesTarget(String option){
    return driver.findElement(By.xpath("//option[@value=" + option +"]"));
    }
    public WebElement chooseBodyType(String bodyType){
        return driver.findElement(By.id("id-body-" + bodyType));
    }
    public void selectHeadField(){
        driver.findElement(By.className("custom-select")).click();
    }
    public void selectBodyTypeField(){
        driver.findElement(By.className("form-check-input")).click();
    }
}
