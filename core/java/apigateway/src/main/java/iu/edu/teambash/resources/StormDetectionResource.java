package iu.edu.teambash.resources;

import com.codahale.metrics.annotation.Timed;
import iu.edu.teambash.StringConstants;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

/**
 * Created by janakbhalla on 17/09/16.
 */

@Path("/stormDetection/{url}/")
public class StormDetectionResource {

    public StormDetectionResource() {
    }

    @GET
    @Timed
    public Response redirect(@PathParam("url") String url) {
        URI uri = UriBuilder.fromUri(StringConstants.STORM_DETECTION + url).build();
        return Response.seeOther(uri).build();
    }
}
