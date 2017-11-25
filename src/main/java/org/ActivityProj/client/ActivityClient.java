package org.ActivityProj.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.ActivityProj.model.Activity;


public class ActivityClient {

	private Client client;//create an instance of client (it comes from jersy->javax.rs)
	
	public ActivityClient() {
		client = ClientBuilder.newClient();
	}
	
	
/*	public Activity getParticularActivity(String id) {
		WebTarget mytarget = client.target("http://localhost:8080/ActivityProj/webapi/");
		Activity responseActivity = mytarget.path("activities/" + id).request().get(Activity.class);
		return responseActivity;
	}*/
	
	
	public Activity getParticularActivity(String id) {
		WebTarget mytarget = client.target("http://localhost:8080/ActivityProj/webapi/");
		Response responseActivity = mytarget.path("activities/" + id).request().get(Response.class);
	
		if(responseActivity.getStatus() != 200)
		throw new RuntimeException(responseActivity.getStatus() + " there is an error in server side please dont worry");
			
		return responseActivity.readEntity(Activity.class);
	}
	
	
	
	public String getParticularActivityInString(String id) {
		WebTarget mytarget = client.target("http://localhost:8080/ActivityProj/webapi/");
		String responseActivity = mytarget.path("activities/" + id).request(MediaType.APPLICATION_JSON).get(String.class);
		return responseActivity;
	}
	
	public List<Activity> getAllList(){
		WebTarget mytarget = client.target("http://localhost:8080/ActivityProj/webapi/");
		List<Activity> ListOfActivities = mytarget.path("activities/").request().get( ( new GenericType<List<Activity>>() {}) );
		return ListOfActivities;
	}
	
	public Activity createActivity(Activity myNewActivity) {
		WebTarget mytarget = client.target("http://localhost:8080/ActivityProj/webapi/");
		Response response = mytarget.path("activities/activity")
									.request(MediaType.APPLICATION_JSON)
									.post(Entity.entity(myNewActivity, MediaType.APPLICATION_JSON));
		return response.readEntity(Activity.class);
	}


	public Activity updateActivity(int givenId,Activity activity) {
		WebTarget mytarget = client.target("http://localhost:8080/ActivityProj/webapi/");
		Response response = mytarget.path("activities/" + givenId)
									.request(MediaType.APPLICATION_JSON)
									.put(Entity.entity(activity, MediaType.APPLICATION_JSON));
	
		return response.readEntity(Activity.class);
	}


	public void deleteActivity(String deleteId) {
	
		WebTarget mytarget = client.target("http://localhost:8080/ActivityProj/webapi/");
		Response response = mytarget.path("activities/" + deleteId)
							.request(MediaType.APPLICATION_JSON)
							.delete();
	}
	
}
