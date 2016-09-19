package iu.edu.teambash.resources;

/**
 * Created by janakbhalla on 14/09/16.
 */

import com.codahale.metrics.annotation.Timed;
import io.dropwizard.auth.Auth;
import io.dropwizard.hibernate.UnitOfWork;
import iu.edu.teambash.core.UsersEntity;
import iu.edu.teambash.db.UserDao;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/loginUser")
@Produces(MediaType.APPLICATION_JSON)
public class LoginResource {
    private UserDao userDao;

    public LoginResource(UserDao userDao) {
        this.userDao = userDao;
    }

    @POST
    @Timed
    @UnitOfWork
    public Boolean login(@Auth UsersEntity user) {
        return true;
    }
}
