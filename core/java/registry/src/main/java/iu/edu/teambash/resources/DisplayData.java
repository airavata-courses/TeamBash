package iu.edu.teambash.resources;

import io.dropwizard.hibernate.UnitOfWork;
import iu.edu.teambash.core.UsersEntity;
import iu.edu.teambash.db.UserDao;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by murugesm on 9/19/16.
 */

@Path("/displayData/{userid}")
@Produces(MediaType.APPLICATION_JSON)
public class DisplayData {
    private final UserDao userDao;
    public UsersEntity user1 = new UsersEntity("mani", "password");

    public DisplayData(UserDao userDao) {
        this.userDao = userDao;
    }

    @POST
    @UnitOfWork
    @Produces(MediaType.TEXT_HTML)
    public String display(@PathParam("userid") String userid) {
        return userid;
    }
}