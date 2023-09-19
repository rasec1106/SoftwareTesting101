package cucumber.codigopostal;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class CodigoPostalAPI {
    private static String UBICACION_POR_CODIGO_POSTAL_Y_PAIS = "http://api.zippopotam.us/{pais}/{codigopostal}";
    @Step("Obtener ubicacion por codigo postal {0} en pais {1}")
    public void buscarUbicacionPorCodigoPostalYPais(String codigopostal, String pais){
        SerenityRest.given()
                .pathParam("codigopostal",codigopostal) //replace "codigopostal" in the url with the value passed as a parameter
                .pathParam("pais",pais)
                .get(UBICACION_POR_CODIGO_POSTAL_Y_PAIS); // we'll use a GET http method
    }
}
