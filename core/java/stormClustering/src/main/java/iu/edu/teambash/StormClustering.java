package iu.edu.teambash;

import java.text.ParseException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/StormClustering")
public class StormClustering 
{
	
	@GET
	@Produces("application/xml")
	public String generateKML() throws ParseException {
		
		String sampleOutput = "<kml><b1>Data Here</b1></kml>";
		return sampleOutput;
	}

}
