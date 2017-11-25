package org.ActivityProj.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Activity {
	@XmlElement(name="activityId")
	private int id;
	@XmlElement(name="myDescription")
	private String description;
	@XmlElement(name="myDuration")
	private int duration;
	@XmlElement(name="userObject")
	private User user;
	
	public Activity() {}
	
	public Activity(int id, String description, int duration, User user) {
		super();
		this.id = id;
		this.description = description;
		this.duration = duration;
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Activity [id=" + id + ", description=" + description + ", duration=" + duration + ", user=" + user
				+ "]";
	}
	
	
	
}
