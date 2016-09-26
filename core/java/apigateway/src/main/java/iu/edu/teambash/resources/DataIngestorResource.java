package iu.edu.teambash.resources;

import com.codahale.metrics.annotation.Timed;
import iu.edu.teambash.StringConstants;
import org.glassfish.jersey.client.JerseyClientBuilder;

import javax.ws.rs.GET;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.client.Client;
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


@Path("/dataIngestor/{uid}/{year}/{month}/{date}/{station}")
public class DataIngestorResource extends AbstractResource {

    public DataIngestorResource() {
    }

    @Context
    private ResourceContext rc;

    @GET
    @Timed
    public Response redirect(@PathParam("uid") int uid, @PathParam("year") String year, @PathParam("month") String month, @PathParam("date") String date, @PathParam("station") String station) {

        Response response = invokeRemoteService(1, uid, StringConstants.DATA_INGESTOR + year + "/" + month + "/" + date + "/" + station, MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON, HttpMethod.GET, null);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        String url = response.readEntity(String.class);
        StormDetectionResource stormDetectionResource = rc.getResource(StormDetectionResource.class);
        return stormDetectionResource.redirect(url, uid);
    }
}
