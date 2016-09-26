package iu.edu.teambash.resources;

import iu.edu.teambash.StringConstants;

import javax.ws.rs.GET;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by janakbhalla on 24/09/16.
 */
@Path("/runForecast/{uid}")
public class RunWeatherForecastResource extends AbstractResource {


    @GET
    public Response redirect(@PathParam("uid") int uid) {
        Response response = invokeRemoteService(5, uid, StringConstants.RUN_FORECAST, MediaType.APPLICATION_XML, MediaType.APPLICATION_XML, HttpMethod.GET, null);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }
        return response;
    }


}
