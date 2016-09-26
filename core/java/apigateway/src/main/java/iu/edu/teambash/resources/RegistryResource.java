package iu.edu.teambash.resources;

import iu.edu.teambash.StringConstants;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

/**
 * Created by janakbhalla on 24/09/16.
 */

@Path("/registry/")
public class RegistryResource {


    @GET
    @Path("/displayData/{uid}")
    public Response displayData(@PathParam("uid") int uid) {
        URI uri = UriBuilder.fromUri(StringConstants.REGISTRY + "displayData/" + uid).build();
        return Response.seeOther(uri).build();
    }
}
