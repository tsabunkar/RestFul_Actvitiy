package org.ActivityProj.client;

import java.util.List;

import org.ActivityProj.model.Activity;
import org.ActivityProj.model.User;

//client created and tested with out using the concepts of Junit testing
public class MyClient {

	public static void main(String[] args) {
		ActivityClient client = new ActivityClient();
		Activity responseActivity = client.getParticularActivity("320");
		System.out.println(responseActivity);
		
		System.out.println("-------------");
		
	/*	String responseInString = client.getParticularActivityInString("321");
		System.out.println(responseInString);*/
		
		
		System.out.println("---------getting list of Activities-----------");
		List<Activity> listOfActivities = client.getAllList();
		System.out.println(listOfActivities);
		
		
		System.out.println("-------create a new activity------");
		ActivityClient myClient = new ActivityClient();
		Activity activity = new Activity();
		activity.setId(323);
		activity.setDescription("elpiticals");
		activity.setDuration(20);
		
		myClient.createActivity(activity);
	}
}
