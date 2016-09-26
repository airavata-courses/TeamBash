package iu.edu.teambash.resources;

/**
 * Created by janakbhalla on 14/09/16.
 */

import com.codahale.metrics.annotation.Timed;
import iu.edu.teambash.StringConstants;
import iu.edu.teambash.core.User;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/loginUser")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginResource {

    @POST
    @Timed
    public Response login(User user) {
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder()
                .nonPreemptive()
                .credentials(user.getUsername(), user.getPassword())
                .build();
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.register(feature);
        Client client = JerseyClientBuilder.createClient(clientConfig);
        return client.target(StringConstants.LOGIN).request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(null);

    }
}