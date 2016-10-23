package iu.edu.teambash.resources;

/**
 * Created by janakbhalla on 14/09/16.
 */

import com.codahale.metrics.annotation.Timed;
import io.dropwizard.hibernate.UnitOfWork;
import iu.edu.teambash.core.UsersEntity;
import iu.edu.teambash.db.UserDao;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/createUser")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    UserDao userDao;

    public UserResource(UserDao userDao) {
        this.userDao = userDao;
    }

    @POST
    @Timed
    @UnitOfWork
    public int login(String uname) {
        UsersEntity user = new UsersEntity(uname);
        userDao.create(user);
        return user.getUid();
    }
}
