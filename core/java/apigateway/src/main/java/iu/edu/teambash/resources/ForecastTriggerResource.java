package iu.edu.teambash.resources;

import com.codahale.metrics.annotation.Timed;
import iu.edu.teambash.StringConstants;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.client.Entity;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by janakbhalla on 22/09/16.
 */
@Path("/forecastTrigger/{uid}")
public class ForecastTriggerResource extends AbstractResource {


    @Context
    private ResourceContext rc;

    @POST
    @Timed
    public Response redirect(String cluster, @PathParam("uid") int uid) {
        Response response = invokeRemoteService(4, uid, StringConstants.FORECAST_TRIGGER, MediaType.TEXT_HTML, MediaType.TEXT_HTML, HttpMethod.POST, Entity.entity(cluster, MediaType.APPLICATION_XML));
        Boolean forecastTrigger = Boolean.valueOf(response.readEntity(String.class));
        if (!forecastTrigger)
            return Response.ok(forecastTrigger).build();
        RunWeatherForecastResource runWeatherForecastResource = rc.getResource(RunWeatherForecastResource.class);
        return runWeatherForecastResource.redirect(uid);
    }
}
