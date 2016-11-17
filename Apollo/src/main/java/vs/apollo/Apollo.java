package vs.apollo;

import java.util.Random;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author vasouv
 */
@Path("apollo")
public class Apollo {
    
    @GET
    @Path("celsius")
    public int getTemperature(){
        return generateTemperature(260, 430);
    }
    
    private int generateTemperature(int min, int max){
        Random r = new Random();
        return r.ints(min, max+1).findFirst().getAsInt();
    }
    
}