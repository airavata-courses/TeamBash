package iu.edu.teambash.resources;

import iu.edu.teambash.StringConstants;
import org.glassfish.jersey.client.JerseyClientBuilder;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.ExecutionException;

/**
 * Created by janakbhalla on 25/09/16.
 */
public class AbstractResource {

    protected Response invokeRemoteService(int id, int uid, String url, String request, String accept, String method, Entity em) {
        int logId = Integer.valueOf(invokeService(StringConstants.REGISTRY + uid, MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON, HttpMethod.POST, null).readEntity(String.class));
        Response response = invokeService(url, request, accept, method, em);
        invokeService(StringConstants.REGISTRY + logId, MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON, HttpMethod.POST, null);
        return response;
    }

    protected Response invokeService(String url, String request, String accept, String method, Entity em) {
        try {
            Client client = new JerseyClientBuilder().build();
            Response response = client.target(url).request(request).accept(accept).method(method, em);
            return response;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
