package iu.edu.teambash.resources;

import com.codahale.metrics.annotation.Timed;
import iu.edu.teambash.StringConstants;
import org.glassfish.jersey.client.JerseyClientBuilder;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

/**
 * Created by janakbhalla on 17/09/16.
 */


@Path("/dataIngestor/{year}/{month}/{date}/{station}")
public class DataIngestorResource {

    public DataIngestorResource() {
    }

    @Context
    private ResourceContext rc;

    @GET
    @Timed
    public Response redirect(@PathParam("year") String year, @PathParam("month") String month, @PathParam("date") String date, @PathParam("station") String station) {
        Client client = new JerseyClientBuilder().build();
        Response response = client.target(StringConstants.DATA_INGESTOR + year + "/" + month + "/" + date + "/" + station).request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).get();

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        String url = response.readEntity(String.class);
        StormDetectionResource stormDetectionResource = rc.getResource(StormDetectionResource.class);
        return stormDetectionResource.redirect(url);
    }
}
