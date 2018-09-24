package restpro.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.http.MediaType;

import restpro.models.MasterProgramDescription;
import restpro.response.Response;

@Path("/language")
public interface ProgrammingI {
	
	@Path("/description")
	@GET
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public MasterProgramDescription getPoemByName();
	
	@Path("/information/{language}")
	@POST
	@Consumes(MediaType.APPLICATION_JSON_VALUE) 
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public Response proLangInfo(@PathParam("language") String lan);

}
