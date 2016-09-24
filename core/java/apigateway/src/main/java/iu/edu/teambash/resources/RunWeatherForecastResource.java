package iu.edu.teambash.resources;

import io.dropwizard.jersey.PATCH;
import iu.edu.teambash.StringConstants;
import org.glassfish.jersey.client.JerseyClientBuilder;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by janakbhalla on 24/09/16.
 */
@Path("/runForecast/")
public class RunWeatherForecastResource {

    @GET
    public Response redirect(String cluster) {
        Client client = new JerseyClientBuilder().build();
        Response response = client.target(StringConstants.RUN_FORECAST).request(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_XML).get();

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }
        return response;
    }


}
