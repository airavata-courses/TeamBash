package iu.edu.teambash.resources;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by murugesm on 10/17/16.
 */
@Path("/startService/{service}")
@Produces(MediaType.TEXT_HTML)
public class StartServices
{
    @POST
    @Timed
    public boolean startService(@PathParam("service") String service)
    {
        return true;
    }

}
