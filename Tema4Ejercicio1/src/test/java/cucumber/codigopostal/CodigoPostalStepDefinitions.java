package cucumber.codigopostal;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class CodigoPostalStepDefinitions {
    @Steps
    CodigoPostalAPI codigoPostalAPI;
    @When("Busco un codigo postal {word} para el codigo de pais {word}")
    public void buscarCodigoPostal(String postCode, String country){
        codigoPostalAPI.buscarUbicacionPorCodigoPostalYPais(postCode, country);
    }
    @Then("la ubicacion deberia ser {} en {}")
    public void ubicacionDeberiaSer(String ubicacion, String pais){
        restAssuredThat(response -> response.statusCode(200));
        restAssuredThat(response -> response.body(UbicacionResponse.PAIS, equalTo(pais)));
        restAssuredThat(response -> response.body(UbicacionResponse.UBICACION, equalTo(ubicacion)));
    }
}
