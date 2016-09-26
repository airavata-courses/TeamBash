package iu.edu.teambash.resources;

import com.codahale.metrics.annotation.Timed;
import iu.edu.teambash.StringConstants;
import org.glassfish.jersey.client.JerseyClientBuilder;

import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.ExecutionException;

/**
 * Created by janakbhalla on 24/09/16.
 */

@Path("/stormClustering/{uid}")
public class StormClusteringResource extends AbstractResource {

    @Context
    private ResourceContext rc;

    @POST
    @Timed
    public Response redirect(String kml, @PathParam("uid") int uid) {
        Response response = invokeRemoteService(3, uid, StringConstants.STORM_DETECTION, MediaType.APPLICATION_XML, MediaType.APPLICATION_XML, HttpMethod.GET, null);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        String cluster = response.readEntity(String.class);
        ForecastTriggerResource forecastTriggerResource = rc.getResource(ForecastTriggerResource.class);
        return forecastTriggerResource.redirect(cluster, uid);
    }
}
