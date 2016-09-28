package iu.edu.teambash.resources;

import iu.edu.teambash.StringConstants;
import org.glassfish.jersey.client.JerseyClientBuilder;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by janakbhalla on 25/09/16.
 */
public class AbstractResource {

    protected Response invokeRemoteService(int id, int uid, String url, String request, String accept, String method, Entity em) {
        int logId = Integer.valueOf(invokeService(StringConstants.REGISTRY + "startLog/" + uid + "/" + id, MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON, HttpMethod.POST, null).readEntity(String.class));
        Response response = invokeService(url, request, accept, method, em);
        invokeService(StringConstants.REGISTRY + "endLog/" + logId, MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON, HttpMethod.POST, null);
        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            throw new WebApplicationException(url, response.getStatus());
        }
        return response;
    }

    protected Response invokeService(String url, String request, String accept, String method, Entity em) {
        Client client = new JerseyClientBuilder().build();
        return client.target(url).request(request).accept(accept).method(method, em);
    }
}
