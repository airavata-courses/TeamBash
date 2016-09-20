package iu.edu.teambash.resources;

/**
 * Created by janakbhalla on 14/09/16.
 */

import com.codahale.metrics.annotation.Timed;
import io.dropwizard.auth.Auth;
import io.dropwizard.hibernate.UnitOfWork;
import iu.edu.teambash.core.UsersEntity;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/loginUser")
@Produces(MediaType.APPLICATION_JSON)
public class LoginResource {

    @POST
    @Timed
    @UnitOfWork
    public Response login(@Auth UsersEntity user) {
        return Response.ok(user).build();
    }
}
