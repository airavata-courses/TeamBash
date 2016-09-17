package iu.edu.teambash.resources;

/**
 * Created by janakbhalla on 14/09/16.
 */
import com.codahale.metrics.annotation.Timed;
import io.dropwizard.auth.Auth;
import io.dropwizard.hibernate.UnitOfWork;
import iu.edu.teambash.core.User;
import iu.edu.teambash.db.UserDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
public class LoginResource {
    private UserDao userDao;

    public LoginResource(UserDao userDao) {
        this.userDao = userDao;
    }

    @GET
    @Timed
    @UnitOfWork
    public String login(@Auth User user) {
        //userDao.create(user);
        return "Login Successful" + user.getName();
    }
}
