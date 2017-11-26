package org.ActivityProj.client;

import java.net.URI;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.ActivityProj.model.Activity;
import org.ActivityProj.model.ActivitySearch;

public class ActivitySearchClient {

	private Client myclient;
	
	public ActivitySearchClient() {
		myclient = ClientBuilder.newClient();
	}
	
	public List<Activity> search (String param,List<String> searchValues){
		
		URI myuri = UriBuilder.fromUri("http://localhost:8080/ActivityProj/webapi/")
							.path("search/activities")
							.queryParam(param, searchValues)
							.build();
		
		System.out.println("my uri builder is correctly constructed "+ myuri);
		WebTarget mytarget = myclient.target(myuri);
		
		List<Activity> response = mytarget.request(MediaType.APPLICATION_JSON)
									.get(   new GenericType<List<Activity>> () {}   );
		
		System.out.println(response);
		
		return response;
	}
	
	 

	public List<Activity> search2(ActivitySearch activitySearch) {
		URI myuri = UriBuilder.fromUri("http://localhost:8080/ActivityProj/webapi/")
				.path("search/activities")
				.build();
		
		System.out.println("my uri builder is correctly constructed "+ myuri);
		
		WebTarget mytarget = myclient.target(myuri);
		
		Response response  = mytarget.request(MediaType.APPLICATION_JSON)
									.post(Entity.entity(activitySearch, MediaType.APPLICATION_JSON));
		
		return response.readEntity( new GenericType<List<Activity>> () {} );
	}
	
}
