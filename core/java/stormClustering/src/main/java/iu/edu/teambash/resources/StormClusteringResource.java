package iu.edu.teambash.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by janakbhalla on 26/09/16.
 */

@Path("/StormClustering")
public class StormClusteringResource {

    @GET
    @Produces("application/xml")
    public String generateKML() {

        String sampleOutput = "<kml><b1>Data Here</b1></kml>";
        return sampleOutput;
    }
}
