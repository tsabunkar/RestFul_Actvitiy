package org.ActivityProj;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.ActivityProj.dao.ActivityRepoistry;
import org.ActivityProj.dao.ActivityRepoistryImple;
import org.ActivityProj.model.Activity;
import org.ActivityProj.model.ActivitySearch;

@Path("search/activities")
public class ActivitySearchResource {

	private ActivityRepoistry activityRepo = new ActivityRepoistryImple();
	
	// to hit this method URI is 
	// http://localhost:8080/ActivityProj/webapi/search/activities?description=gym&description=running
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchForActivities(@QueryParam(value="description") List<String> ListOfdescription) throws SQLException {
		System.out.println(" list of description are : "+ListOfdescription);
		List<Activity> listOfActvitiy = activityRepo.findByDescription(ListOfdescription);
		
		/*if( listOfActvitiy == null || listOfActvitiy.size() <=0 )
			return Response.status(Status.NOT_FOUND).build();*/
		
		return Response.ok().entity( new GenericEntity<List<Activity>> (listOfActvitiy) {} ).build();
		
	}
	
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response searchForActivities(ActivitySearch activitySearch) throws SQLException {
		System.out.println(" list of activitySearch's are : " + activitySearch);
		List<Activity> listOfActvitiy = activityRepo.findByDescription2(activitySearch);
	
	return Response.ok().entity( new GenericEntity<List<Activity>> (listOfActvitiy) {} ).build();
	}
	
	
	
}
