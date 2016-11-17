package vs.zeusmonitor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

/**
 *
 * @author vasouv
 */
@Named("temperatureRetriever")
@Stateless
public class TemperatureRetriever {
    
    protected Client client;
    
    private final String APOLLO_URI = "http://localhost:8383/apollo/temperature/apollo";
    private final String ARTEMIS_URI = "http://localhost:8484/artemis/temperature/artemis";
    
    @PostConstruct
    public void init(){
        client = ClientBuilder.newClient();
    }
    
    @PreDestroy
    public void clean(){
        client.close();
    }

    public TemperatureRetriever() {
    }
    
    public String getApolloTemperature(){
        int a = client.target(APOLLO_URI).path("celsius").request().get(Integer.class);
        return Integer.toString(a);
    }
    
    public String getArtemisTemperature(){
        return client.target(ARTEMIS_URI).path("celsius").request().get(String.class);
    }
    
}
