package cucumber.stepdefs;
//import cucumber.pages.PaginaInventario;
import cucumber.pages.PaginaLogin;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class LoginStepDefs {
    private static WebDriver driver;
    private PaginaLogin paginaLogin;
//    private PaginaInventario paginaInventario;
    @Given("Estoy en la página de inicio de sesion")
    public void estoyEnLaPaginaInicio() {
        String key = "webdriver.chrome.driver";
        String value = "C:\\Users\\cesar.herrera\\Documents\\Cibertec\\Ciclo202302\\Pruebas de software\\chromedriver-win64\\chromedriver.exe";
        System.setProperty(key, value);
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        paginaLogin = new PaginaLogin(driver);
    }
    @When("Ingreso {string} y password secret_sauce")
    public void ingresoUsernameYPassword(String username) {
        paginaLogin.ingresarUsername(username);
        paginaLogin.ingresarPassword("secret_sauce");
    }
    @And("Hago clic en el boton de inicio de sesion")
    public void clickBotonInicioSesion() {
        paginaLogin.clickBotonLogin();
    }
    @Then("Ingresare a la pagina de inventario")
    public void ingresarePaginaInventario() {
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//        paginaInventario = new PaginaInventario(driver);
    }
    @When("Inserto un username invalido y un password valido")
    public void iInsertAnInvalidUsername() {
        paginaLogin.ingresarUsername("locked_out_user");
        paginaLogin.ingresarPassword("secret_sauce");
    }
    @When("Inserto un username valido y un password invalido")
    public void iInsertAnInvalidPassword() {
        paginaLogin.ingresarUsername("standard_user");
        paginaLogin.ingresarPassword("12345");
    }
    @Then("Me quedare en la pagina de inicio de sesion")
    public void meQuedareEnPaginaInicioSesion() {
        Assertions.assertTrue("https://www.saucedemo.com".equals(driver.getCurrentUrl()) || "https://www.saucedemo.com/".equals(driver.getCurrentUrl()));
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("tearDown");
        }
    }
}