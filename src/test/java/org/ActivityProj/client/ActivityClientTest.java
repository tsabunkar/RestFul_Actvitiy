package org.ActivityProj.client;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.ActivityProj.model.Activity;
import org.ActivityProj.model.ActivitySearch;
import org.ActivityProj.model.User;
import org.junit.Test;

public class ActivityClientTest {

	@Test
	public void testGetActivity() {
		ActivityClient client = new ActivityClient();
		Activity activityClient = client.getParticularActivity("320");
		System.out.println(activityClient);
		
		assertNotNull(activityClient);
	}
	

	@Test
	public void testGetActivity1() {
		ActivityClient client = new ActivityClient();
		String activityClient = client.getParticularActivityInString("320");
		System.out.println(activityClient);
		
		assertNotNull(activityClient);
	}
	
	@Test
	public void testGetAllActivities() {
		ActivityClient client = new ActivityClient();
		List<Activity> activityClient = client.getAllList();
		System.out.println(activityClient);
		
		assertNotNull(activityClient);
	}
	
	@Test
	public void testCreate() {
		ActivityClient myClient = new ActivityClient();
		
		Activity activity = new Activity();
		activity.setId(321);
		activity.setDescription("cycling");
		activity.setDuration(40);
		
				
			myClient.createActivity(activity);
		
	}
	
	@Test
	public void testPut() {
		Activity activity = new Activity();
		/*activity.setId(321);*/
		activity.setDescription("gym");
		activity.setDuration(20);
		
		ActivityClient myClient = new ActivityClient();
		
		Activity updatedActivity = myClient.updateActivity(320,activity);
		
		assertNotNull(updatedActivity);
	}
	
	@Test
	public void testdelete() {
	ActivityClient myClient = new ActivityClient();
	myClient.deleteActivity("321");
		
	}
	
	
	@Test
	public void testSearch() {
		ActivitySearchClient myClient  = new  ActivitySearchClient();
		String param = "description";
		List<String> searchValues = new ArrayList<String>();
		searchValues.add("gym");
		searchValues.add("running");
		
		List<Activity> ListOfActivity = myClient.search(param, searchValues);
		System.out.println("------------------");
		for (Activity activity : ListOfActivity) {
			System.out.println(activity);
		}
		assertNotNull(ListOfActivity);
	}
	
	@Test
	public void testSearch2() {
		ActivitySearchClient myClient  = new  ActivitySearchClient();
		
		List<String> searchValues = new ArrayList<String>();
		searchValues.add("gym");
		searchValues.add("running");
		
		ActivitySearch activitySearch = new ActivitySearch();
		activitySearch.setDescription(searchValues);
		
		List<Activity> ListOfActivity = myClient.search2(activitySearch);
		
		System.out.println(ListOfActivity);
		
		assertNotNull(ListOfActivity);
	}

}
