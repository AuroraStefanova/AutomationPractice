package WebPages;

import Custom.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class RobotOrder {
    WebDriver driver;
    Elements select;
    @FindBy(css = ".form-control")
    WebElement legsField;
    @FindBy(css = "#address")
    WebElement addressField;
    @FindBy(css = "#preview")
    WebElement previewButton;
    @FindBy(css = "#robot-preview")
    WebElement previewRobot;
    @FindBy(css = "#order")
    WebElement orderButton;
    @FindBy(xpath = "//button[contains(text(),'Show model info')]")
    WebElement showModelInfoButton;
    @FindBy(xpath = "//button[contains(text(),'Hide model info')]")
    WebElement hideModelInfoButton;
    @FindBy(css = "#order-another")
    WebElement orderAnotherRobotButton;
    public RobotOrder(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
        select = new Elements(driver);
    }
    public void buildAndOrderARobot(String headOfRobot, String bodyType, String legsNumber){
        select.selectHeadField();
        select.chooseOptionHeadAndSalesTarget(headOfRobot).click();
        select.selectBodyTypeField();
        select.chooseBodyType(bodyType).click();
        this.legsField.sendKeys(legsNumber);
        this.addressField.sendKeys("Bulgaria, city Gabrovo, str. Aleko Konstantinov 3");
        this.orderButton.click();
    }
    public void showModelInfo(){
        this.showModelInfoButton.click();
    }
    public void hideModelInfo(){
        this.hideModelInfoButton.click();
    }
    public void robotVisibility(){
        this.previewRobot.isDisplayed();
    }
    public void completeOrder(){
        this.orderAnotherRobotButton.isDisplayed();
    }
    public void orderAnotherRobot(){
        this.orderAnotherRobotButton.click();
    }
    public void modalButtonOk(){
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
    }
    public void modalButtonYep(){
        driver.findElement(By.xpath("//button[contains(text(),'Yep')]")).click();
    }
    public void modalButtonIGuessSo(){
        driver.findElement(By.xpath("//button[contains(text(),'I guess so...')]")).click();
    }
    public void modalButtonNoWay(){
        driver.findElement(By.xpath("//button[contains(text(),'No way!')]")).click();
    }
    public void orderYourRobot(){
        driver.findElement(By.xpath("//a[contains(text(),'Order your robot!')]")).click();
    }
    public void previewRobot(){
        this.previewButton.click();
        robotVisibility();
    }
}
