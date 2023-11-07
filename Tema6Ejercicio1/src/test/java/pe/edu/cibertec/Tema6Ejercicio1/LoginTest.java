package pe.edu.cibertec.Tema6Ejercicio1;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class LoginTest {
  private static WebDriver driver;
  private static Map<String, Object> vars;
  static JavascriptExecutor js;
  @BeforeAll
  public static void setUp() {

//    driver = new ChromeDriver();
//    js = (JavascriptExecutor) driver;
//    vars = new HashMap<String, Object>();

    String key = "webdriver.chrome.driver";
    String value = "C:\\Users\\cesar.herrera\\Documents\\Cibertec\\Ciclo202302\\Pruebas de software\\chromedriver-win64\\chromedriver.exe";
    System.setProperty(key, value);
    driver = new ChromeDriver();
  }
  @AfterAll
  public static void tearDown() {
    driver.quit();
  }
  @Test
  public void login() {
    driver.get("https://www.saucedemo.com/");
    driver.findElement(By.cssSelector("*[data-test=\"username\"]")).sendKeys("standard_user");
    driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("secret_sauce");
    driver.findElement(By.cssSelector("*[data-test=\"login-button\"]")).click();
  }
}
