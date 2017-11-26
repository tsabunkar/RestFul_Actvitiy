package org.ActivityProj.client;

import java.util.ArrayList;
import java.util.List;

import org.ActivityProj.model.Activity;

public class MyClient2 {

	public static void main(String[] args) {
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

	}

}
