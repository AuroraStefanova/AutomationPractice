package WebPages;

import Custom.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class ActiveSales {
    WebDriver driver;
    Elements select;
    @FindBy(css = "#logout")
    WebElement logOutButton;
    @FindBy(css = "#firstname")
    WebElement firstNameField;
    @FindBy(css = "#lastname")
    WebElement lastNameField;
    @FindBy(css = "#salestarget")
    WebElement salesTargetField;
    @FindBy(css = "#salesresult")
    WebElement salesResultField;
    @FindBy(css = ".btn-primary")
    WebElement submitButton;
    @FindBy(xpath = "//button[contains(text(),'Show performance')]")
    WebElement showPerformanceButton;
    @FindBy(xpath = "//button[contains(text(),'Delete all sales entries')]")
    WebElement deleteAllSalesButton;
    public ActiveSales(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
        select =  new Elements(driver);
    }
    public void addSales(String firstName, String lastName, String saleTarget,String salesResult){
        this.firstNameField.sendKeys(firstName);
        this.lastNameField.sendKeys(lastName);
        this.salesTargetField.click();
        select.chooseOptionHeadAndSalesTarget(saleTarget).click();
        this.salesResultField.sendKeys(salesResult);
        this.submitButton.click();
    }
    public void showPerformance(){
        this.showPerformanceButton.click();
    }
    public void deleteSales(){
        this.deleteAllSalesButton.click();
    }
    public void logOutUser(){
        this.logOutButton.click();
    }
}
