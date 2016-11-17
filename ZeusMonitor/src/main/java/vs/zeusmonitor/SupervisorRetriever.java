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
@Named("supervisorRetriever")
@Stateless
public class SupervisorRetriever {
    
    protected Client client;
    
    private final String POSEIDON_URI = "http://localhost:8585/poseidon/supervisor/poseidon";
    
    @PostConstruct
    public void init(){
        client = ClientBuilder.newClient();
    }
    
    @PreDestroy
    public void clean(){
        client.close();
    }

    public SupervisorRetriever() {
    }
    
    public String getSupervisor(){
        return client.target(POSEIDON_URI).path("supervisor").request().get(String.class);
    }
    
}