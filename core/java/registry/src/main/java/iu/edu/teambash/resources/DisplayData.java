package iu.edu.teambash.resources;

import io.dropwizard.hibernate.UnitOfWork;
import iu.edu.teambash.core.LogEntity;
import iu.edu.teambash.db.LogDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by murugesm on 9/19/16.
 */

@Path("/registry")
@Produces(MediaType.APPLICATION_JSON)
public class DisplayData {
    private final LogDao logDao;

    private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private Date date = new Date();

    public DisplayData(LogDao logDao) {
        this.logDao = logDao;
    }

    @GET
    @UnitOfWork
    @Path("/displayData/{uID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response display(@PathParam("uID") int uID) {
        List<LogEntity> logList = logDao.findLogs(uID);
        return Response.ok(logList).build();
    }

    @POST
    @UnitOfWork
    @Path("/startLog/{uID}/{mID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertService(@PathParam("uID") int uID, @PathParam("mID") int mID) {
        //Creates new Log row
        LogEntity newLog = new LogEntity();

        //Sets the value the user passes
        newLog.setuId(uID);
        newLog.setmId(mID);

        //Current time to store Start time
        date.getTime();
        newLog.setStartTime(dateFormat.format(date));

        //Stores the new row
        LogEntity logEntity = logDao.create(newLog);
        return Response.ok(logEntity.getlId()).build();
    }

    @POST
    @UnitOfWork
    @Path("/endLog/{lID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response endService(@PathParam("lID") int lID) {
        //Find the log row matching to the log ID
        LogEntity newLog = logDao.findById(lID);

        //Current time to store the End time
        date.getTime();
        newLog.setEndTime(dateFormat.format(date));

        //Calling the Persist method to update the record
        LogEntity logEntity = logDao.create(newLog);

        //Returns the log row on successfull update
        return Response.ok(logEntity).build();
    }
}