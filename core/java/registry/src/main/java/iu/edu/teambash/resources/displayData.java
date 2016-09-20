package iu.edu.teambash.resources;

import com.codahale.metrics.annotation.Timed;

import io.dropwizard.auth.Auth;
import io.dropwizard.hibernate.UnitOfWork;
import iu.edu.teambash.core.UsersEntity;
import iu.edu.teambash.db.UserDao;
import javax.ws.rs.core.Response;
import javax.ws.rs.*;

import javax.ws.rs.core.MediaType;
/**
 * Created by murugesm on 9/19/16.
 */

@Path("/displayData/{userid}")
@Produces(MediaType.APPLICATION_JSON)
public class displayData
{
    private final UserDao userDao;
    public UsersEntity user1 = new UsersEntity("mani", "password");

    public displayData(UserDao userDao)
    {
        this.userDao = userDao;
    }

    @POST
    @UnitOfWork
    @Produces(MediaType.TEXT_HTML)
    public String display(@PathParam("userid") String userid)
    {
        return userid;
    }
}