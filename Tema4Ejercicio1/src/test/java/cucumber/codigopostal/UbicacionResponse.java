package cucumber.codigopostal;

public class UbicacionResponse {
    public static final String PAIS = "'country'"; // we use this to navigate through the json
    public static final String UBICACION = "'places'[0].'place name'"; // I need to go to the place name in the Json response
}
/**
 * THIS IS THE JSON RESPONSE
 *
 * {
 *    "post code":"10000",
 *    "country":"United States",
 *    "country abbreviation":"US",
 *    "places":[
 *       {
 *          "place name":"New York City",
 *          "longitude":"-73.6731",
 *          "state":"New York",
 *          "state abbreviation":"NY",
 *          "latitude":"40.7069"
 *       }
 *    ]
 * }
 */