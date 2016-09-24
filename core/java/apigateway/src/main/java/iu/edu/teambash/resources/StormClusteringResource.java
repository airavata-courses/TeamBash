package iu.edu.teambash.resources;

import com.codahale.metrics.annotation.Timed;
import iu.edu.teambash.StringConstants;
import org.glassfish.jersey.client.JerseyClientBuilder;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by janakbhalla on 24/09/16.
 */

@Path("/stormClustering/")
public class StormClusteringResource {


    @Context
    private ResourceContext rc;

    @POST
    @Timed
    public Response redirect(String kml) {
        Client client = new JerseyClientBuilder().build();
        Response response = client.target(StringConstants.STORM_CLUSTERING).request(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_XML).post(Entity.entity(kml, MediaType.APPLICATION_XML));

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        String cluster = response.readEntity(String.class);
        ForecastTriggerResource forecastTriggerResource = rc.getResource(ForecastTriggerResource.class);
        return forecastTriggerResource.redirect(cluster);
    }
}
