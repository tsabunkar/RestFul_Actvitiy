package org.ActivityProj.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

	@XmlElement(name="user_id")
	private int uid;
	
	@XmlElement(name="user_name")
	private String uname;
	
	public User() {}
	
	public User(int uid, String uname) {
		super();
		this.uid = uid;
		this.uname = uname;
	}
	

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + "]";
	}

	
	
}
