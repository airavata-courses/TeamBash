package iu.edu.teambash.resources;

import com.codahale.metrics.annotation.Timed;
import iu.edu.teambash.StringConstants;
import org.glassfish.jersey.client.JerseyClientBuilder;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by janakbhalla on 22/09/16.
 */
@Path("/forecastTrigger")
public class ForecastTriggerResource {


    @POST
    @Timed
    public Response redirect() {
        Client client = new JerseyClientBuilder().build();
        Response response = client.target(StringConstants.FORECAST_TRIGGER).request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(Entity.entity("hello", MediaType.APPLICATION_XML));

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        Boolean forecastTrigger = Boolean.valueOf(response.readEntity(String.class));
        return Response.ok(forecastTrigger).build();
    }
}
