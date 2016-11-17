package vs.poseidon;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

/**
 *
 * @author vasouv
 */
@Path("poseidon")
public class Poseidon {
    
    Client client = ClientBuilder.newClient();
    private final String APOLLO_URI = "http://localhost:8383/apollo/temperature/apollo";
    
    @GET
    @Path("supervisor")
    public String getSupervisorAndTime(){
        return "vasouv - " + getTemperatureFromApollo() + " Celsius - " + System.currentTimeMillis();
    }
    
    private String getTemperatureFromApollo(){
        int t = client.target(APOLLO_URI).path("celsius").request().get(Integer.class);
        return Integer.toString(t);
    }
    
}