package Tests;

import BrowserFactory.BrowserFactory;
import WebPages.ActiveSales;
import WebPages.LoginPage;
import WebPages.RobotOrder;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;
@TestMethodOrder(OrderAnnotation.class)

public class TestCases {
    private static String typeOfBrowser = "Chrome";
    private String baseUrl = "https://robotsparebinindustries.com/#/";
    String message;
    static WebDriver driver;
    static LoginPage loginPage;
    static RobotOrder robotOrderPage;
    static ActiveSales activeSalesPage;
    @BeforeAll
    public static void beforeClass(){
        driver = BrowserFactory.getBrowser(typeOfBrowser);
        loginPage = new LoginPage(driver);
        robotOrderPage = new RobotOrder(driver);
        activeSalesPage = new ActiveSales(driver);
    }
    @AfterAll
    public static void afterClass(){
        BrowserFactory.closeBrowser();
    }
    @Test
    @Order(1)
    public void incorrectLogin(){
        driver.get(baseUrl);
        loginPage.loginUser("Petq", "Kirova");

        String buttonLogIn = driver.findElement(By.className("btn-primary")).getText();
        Assert.assertEquals("LOG IN",buttonLogIn);
    }
    @Test
    @Order(2)
    public void correctLogin(){
        driver.get(baseUrl);
        loginPage.loginUser("maria", "thoushallnotpass");

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        String containerWithLoginUser = driver.findElement(By.xpath("//*[contains(text(),'maria')]")).getText();
        Assert.assertNotEquals("maria", containerWithLoginUser);
    }
    @Test
    @Order(3)
    public void positiveSalesWithHidePerformance(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("username")));

        String logOut = driver.findElement(By.id("logout")).getText();
        Assert.assertEquals("Log out", logOut);

        activeSalesPage.addSales("Mariq", "Marinova", "10000","20000");
        activeSalesPage.showPerformance();

        message = driver.findElement(By.xpath("//span[contains(text(),'A positive result. Well done!')]")).getText();
        Assert.assertEquals("A positive result. Well done!", message);

        activeSalesPage.deleteSales();
    }
    @Test
    @Order(4)
    public void positiveSalesWithDeleteAllSales(){
        boolean isElementVisible = driver.findElement((By.id("logout"))).isDisplayed();

        activeSalesPage.addSales("Mariq", "Marinova", "90000", "97000");
        activeSalesPage.showPerformance();

        message = driver.findElement(By.xpath("//span[contains(text(),'A positive result. Well done!')]")).getText();
        Assert.assertNotEquals("The boss wants to see you...", message);

        activeSalesPage.deleteSales();
    }
    @Test
    @Order(5)
    public void negativeSalesWithShowPerformance(){
        boolean containerUserAndLogOut = driver.findElement(By.className("btn-primary")).isDisplayed();

        activeSalesPage.addSales("Mariq", "Marinova","15000", "10000");
        activeSalesPage.showPerformance();

        message = driver.findElement(By.xpath("//*[contains(text(),'Well. It was a nice attempt. I guess?')]")).getText();
        Assert.assertEquals("Well. It was a nice attempt. I guess?", message);

        activeSalesPage.deleteSales();
    }
    @Test
    @Order(6)
    public void negativeSalesWithDeleteAllSales(){
        String buttonSubmit = driver.findElement(By.className("btn-primary")).getText();
        Assert.assertEquals("SUBMIT",buttonSubmit);

        activeSalesPage.addSales("Petq", "Kirova","75000", "10000");
        activeSalesPage.showPerformance();

        message = driver.findElement(By.xpath("//span[contains(text(),'The boss wants to see you...')]")).getText();
        Assert.assertNotSame("Well. It was a nice attempt. I guess?", message);

        activeSalesPage.deleteSales();
    }
    @Test
    @Order(7)
    public void buildRobotRollAThor(){
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("main-container")));
        robotOrderPage.orderYourRobot();
        robotOrderPage.modalButtonNoWay();
        robotOrderPage.modalButtonOk();
        robotOrderPage.showModelInfo();
        robotOrderPage.hideModelInfo();
        robotOrderPage.buildAndOrderARobot("1", "1", "1");
        robotOrderPage.completeOrder();
        robotOrderPage.orderAnotherRobot();
    }
    @Test
    @Order(8)
    public void buildRobotPeanutCrusher(){
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("main-container")));
        robotOrderPage.modalButtonOk();
        robotOrderPage.buildAndOrderARobot("2", "2", "2");
        robotOrderPage.completeOrder();
        robotOrderPage.orderAnotherRobot();
    }
    @Test
    @Order(9)
    public void buildRobotDAVE(){
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("main-container")));
        robotOrderPage.modalButtonYep();
        robotOrderPage.buildAndOrderARobot("3", "3", "3");
        robotOrderPage.completeOrder();
        robotOrderPage.orderAnotherRobot();
    }
    @Test
    @Order(10)
    public void buildRobotAndyRoid(){
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("main-container")));
        robotOrderPage.modalButtonYep();
        robotOrderPage.buildAndOrderARobot("4", "4", "4");
        robotOrderPage.completeOrder();
        robotOrderPage.orderAnotherRobot();
    }
    @Test
    @Order(11)
    public void buildRobotSpannerMate(){
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("main-container")));
        robotOrderPage.modalButtonIGuessSo();
        robotOrderPage.buildAndOrderARobot("5", "5", "5");
        robotOrderPage.completeOrder();
        robotOrderPage.orderAnotherRobot();
    }
    @Test
    @Order(12)
    public void buildRobotDrillbit2000(){
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("main-container")));
        robotOrderPage.modalButtonIGuessSo();
        robotOrderPage.buildAndOrderARobot("6", "6", "6");
        robotOrderPage.completeOrder();
        robotOrderPage.previewRobot();
    }
    @Test
    @Order(13)
    public void logOut(){
        activeSalesPage.logOutUser();
    }
}
/*
Task 1
Description
The main task is to build similar framework, but for another web app with different
structure and business logic i.e. you will have to:

Explore the web app and make notes for its properties
Think about the business logic, note what is important to test
Prepare a list of test cases to be automated
Build a framework to run the web tests
Upload the solution in Git
 */
