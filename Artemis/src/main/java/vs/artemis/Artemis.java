package vs.artemis;

import java.util.Random;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author vasouv
 */
@Path("artemis")
public class Artemis {
    
    @GET
    @Path("celsius")
    public int getTemperature(){
        return generateTemperature(300, 480);
    }
    
    private int generateTemperature(int min, int max){
        Random r = new Random();
        return r.ints(min, max+1).findFirst().getAsInt();
    }
    
}