package iu.edu.teambash.resources;

/**
 * Created by janakbhalla on 14/09/16.
 */
import com.codahale.metrics.annotation.Timed;
import io.dropwizard.auth.Auth;
import iu.edu.teambash.core.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
public class APIGatewayResource {
    private final String template;
    private final String defaultName;

    public APIGatewayResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
    }

    @GET
    @Timed
    public String login(@Auth User user, @QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.orElse(defaultName));
        return "Login Successful" + value;
    }
}
