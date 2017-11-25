package org.ActivityProj;
import java.sql.SQLException;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.ActivityProj.dao.ActivityRepoistry;
import org.ActivityProj.dao.ActivityRepoistryImple;
import org.ActivityProj.model.Activity;
import org.ActivityProj.model.User;


@Path("activities")
public class ActivityResource {
	ActivityRepoistry activityRepo = new ActivityRepoistryImple();

	@GET
	@Produces(MediaType.APPLICATION_JSON)	//http://localhost:8080/ActivityProj/webapi/activities
	public List<Activity> mygetAllActivites() throws ClassNotFoundException, SQLException{
	
		
		List<Activity> listAct =  activityRepo.getAllActivity();
	/*	for (Activity activity : listAct) {
			System.out.println(activity.getDescription());
		}
		*/
		return listAct;
	}
	
	
	
	@GET
	@Produces(value= {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{activityId}")			//  http://localhost:8080/ActivityProj/webapi/activities/321
	public Response mygetActivity(@PathParam("activityId") String myId) throws ClassNotFoundException, SQLException{
		if(myId ==null || myId.length() > 4  ) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		Activity activity = activityRepo.getActivity(Integer.parseInt(myId));
		
		if(activity == null) {
		return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.ok().entity(activity).build();
	}
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{activityId}/user") 		//	http://localhost:8080/ActivityProj/webapi/activities/321/user
	public User getActivityUserObject(@PathParam("activityId") int myId) throws ClassNotFoundException, SQLException{
		
		/*Activity activityObj = activityRepo.getActivity(myId);
		User userObj = activityObj.getUser();  
		return userObj;*/
		return activityRepo.getActivity(myId).getUser();
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("activityurlencoded")
	public Activity createActivityParam(MultivaluedMap<String, String> formParam) throws ClassNotFoundException, SQLException{
		Activity activity = new Activity();
		activity.setId(Integer.parseInt(formParam.getFirst("activityId")));
		activity.setDescription(formParam.getFirst("descr"));
		activity.setDuration(Integer.parseInt(formParam.getFirst("duration")));
		activityRepo.createActivity(activity);
		return activity;
	}
	
	
	//or we can post using-> sending the raw data in the format of JSON,text,XML,etc
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("activity")
	public Activity createActivity(Activity activity) throws ClassNotFoundException, SQLException{
		
		activityRepo.createActivity(activity);
		return activity;
	}
	
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{activityId}")
	public Activity myUpdateActivity(@PathParam("activityId") int givenId, Activity activity) throws ClassNotFoundException, SQLException {
		System.out.println("given id value is "+ givenId);
		return activityRepo.updateActivityRecord(givenId,activity);
		
	}
	
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{activityId}")
	public Response myDelete(@PathParam("activityId") int deleteId) throws SQLException {
		 activityRepo.deleteActivityRecord(deleteId);
		 
		 return Response.ok().build();
	}
	
	
	
	
	
	
	
	
}
