package iu.edu.teambash.resources;

import com.codahale.metrics.annotation.Timed;
import iu.edu.teambash.StringConstants;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
        Response response = invokeRemoteService(3, uid, StringConstants.STORM_CLUSTERING, MediaType.APPLICATION_XML, MediaType.APPLICATION_XML, HttpMethod.GET, null);

        String cluster = response.readEntity(String.class);
        ForecastTriggerResource forecastTriggerResource = rc.getResource(ForecastTriggerResource.class);
        return forecastTriggerResource.redirect(cluster, uid);
    }
}
