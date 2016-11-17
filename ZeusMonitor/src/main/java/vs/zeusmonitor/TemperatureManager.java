package vs.zeusmonitor;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author vasouv
 */
@Named("temperatureManager")
@RequestScoped
public class TemperatureManager implements Serializable {
    
    private String apolloTemperature;
    private String artemisTemperature;
    private String poseidonSupervisor;
    
    @EJB
    SupervisorRetriever supervisorRetriever;
    
    @EJB
    TemperatureRetriever tempRetriever;
    
    @PostConstruct
    public void init(){
        apolloTemperature = tempRetriever.getApolloTemperature();
        artemisTemperature = tempRetriever.getArtemisTemperature();
        poseidonSupervisor = supervisorRetriever.getSupervisor();
    }

    public TemperatureManager() {
        apolloTemperature = "0";
        artemisTemperature = "0";
        poseidonSupervisor = "none assigned";
    }

    public String getApolloTemperature() {
        return apolloTemperature;
    }

    public String getArtemisTemperature() {
        return artemisTemperature;
    }

    public String getPoseidonSupervisor() {
        return poseidonSupervisor;
    }
    
}
