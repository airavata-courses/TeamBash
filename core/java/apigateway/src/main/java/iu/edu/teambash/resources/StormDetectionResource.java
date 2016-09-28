package iu.edu.teambash.resources;

import com.codahale.metrics.annotation.Timed;
import iu.edu.teambash.StringConstants;

import javax.ws.rs.GET;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by janakbhalla on 17/09/16.
 */

@Path("/stormDetection/{url : .+}/{uid}")
public class StormDetectionResource extends AbstractResource {

    @Context
    private ResourceContext rc;

    public StormDetectionResource() {
    }

    @GET
    @Timed
    public Response redirect(@PathParam("url") String url, @PathParam("uid") int uid) {
        Response response = invokeRemoteService(2, uid, StringConstants.STORM_DETECTION + url, MediaType.APPLICATION_XML, MediaType.APPLICATION_XML, HttpMethod.GET, null);
        String kml = response.readEntity(String.class);
        StormClusteringResource resourceB = rc.getResource(StormClusteringResource.class);
        return resourceB.redirect(kml, uid);
    }
}
