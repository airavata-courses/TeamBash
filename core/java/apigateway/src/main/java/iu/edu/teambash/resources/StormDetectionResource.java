package iu.edu.teambash.resources;

import com.codahale.metrics.annotation.Timed;
import com.sun.org.apache.xpath.internal.operations.Bool;
import iu.edu.teambash.StringConstants;
import org.glassfish.jersey.client.JerseyClientBuilder;

import javax.ws.rs.GET;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.concurrent.ExecutionException;

/**
 * Created by janakbhalla on 17/09/16.
 */

@Path("/stormDetection/{url : .+}/{uid}")
public class StormDetectionResource extends AbstractResource {

    public StormDetectionResource() {
    }
    @Context
    private ResourceContext rc;

    @GET
    @Timed
    public Response redirect(@PathParam("url") String url, @PathParam("uid") int uid) {
        Response response = invokeRemoteService(2, uid, StringConstants.STORM_DETECTION + url, MediaType.APPLICATION_XML, MediaType.APPLICATION_XML, HttpMethod.GET, null);
        if (response.getStatus() == 206) {
            return Response.status(response.getStatus()).build();
        }
        String kml = response.readEntity(String.class);
        StormClusteringResource resourceB = rc.getResource(StormClusteringResource.class);
        return resourceB.redirect(kml, uid);
    }
}
