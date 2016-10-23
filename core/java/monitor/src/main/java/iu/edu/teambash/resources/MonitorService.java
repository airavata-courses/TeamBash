package iu.edu.teambash.resources;

import com.codahale.metrics.annotation.Timed;
import iu.edu.teambash.StringConstants;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by murugesm on 10/17/16.
 */
@Path("/monitor")
@Produces(MediaType.TEXT_HTML)
public class MonitorService
{
    @POST
    @Timed
    public String monitor()
    {
        boolean login = loginCheck();
        Response response1 = invokeRemoteService(1, 3, StringConstants.DATA_INGESTOR + "1996/06/06/KVBX", MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON, HttpMethod.GET, null);
        if(response1.getStatus() != 200)
        {
            return "Failed at Data Ingestor with code "+ response1.getStatus();
        }
        Response response2 = invokeRemoteService(2, 3, "http://ec2-52-25-123-69.us-west-2.compute.amazonaws.com:34000/getKml/noaa-nexrad-level2.s3.amazonaws.com/1996/06/06/KVBX/KVBX19960606_001958.gz", MediaType.APPLICATION_XML, MediaType.APPLICATION_XML, HttpMethod.GET, null);
        if(response2.getStatus() != 200)
        {
            return "Failed at Data Ingestor with code "+ response2.getStatus();
        }
        Response response3 = invokeRemoteService(3, 3, StringConstants.STORM_CLUSTERING, MediaType.APPLICATION_XML, MediaType.APPLICATION_XML, HttpMethod.GET, null);
        if(response3.getStatus() != 200)
        {
            return "Failed at Storm Clustering with code "+ response3.getStatus();
        }
        Response response4 = invokeRemoteService(4, 3, StringConstants.FORECAST_TRIGGER, MediaType.TEXT_HTML, MediaType.TEXT_HTML, HttpMethod.POST, Entity.entity("cluster", MediaType.APPLICATION_XML));
        if(response4.getStatus() != 200)
        {
            return "Failed at Forecast Trigger with code "+ response4.getStatus();
        }
        Response response5 = invokeRemoteService(5, 3, StringConstants.RUN_FORECAST, MediaType.APPLICATION_XML, MediaType.APPLICATION_XML, HttpMethod.GET, null);
        if(response5.getStatus() != 200)
        {
            return "Failed at Run Forecast with code "+ response5.getStatus();
        }
        return "Success";
    }

    public boolean loginCheck()
    {
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder()
                .nonPreemptive()
                .credentials("mani", "pass")
                .build();
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.register(feature);
        Client client = JerseyClientBuilder.createClient(clientConfig);
        if((client.target(StringConstants.LOGIN).request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(null)) != null)
        {
            return true;
        }
        return false;
    }

    protected Response invokeService(String url, String request, String accept, String method, Entity em)
    {
        Client client = new JerseyClientBuilder().build();
        return client.target(url).request(request).accept(accept).method(method, em);
    }

    protected Response invokeRemoteService(int id, int uid, String url, String request, String accept, String method, Entity em)
    {
        int logId = Integer.valueOf(invokeService(StringConstants.REGISTRY + "startLog/" + uid + "/" + id, MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON, HttpMethod.POST, null).readEntity(String.class));
        Response response = invokeService(url, request, accept, method, em);
        invokeService(StringConstants.REGISTRY + "endLog/" + logId, MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON, HttpMethod.POST, null);
        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            throw new WebApplicationException(url, response.getStatus());
        }
        return response;
    }
}
