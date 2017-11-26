package org.ActivityProj.model;

import java.util.List;

public class ActivitySearch {

	private List<String> description;

	public ActivitySearch() {
	}

	public ActivitySearch(List<String> description) {
		super();
		this.description = description;
	}

	public List<String> getDescription() {
		return description;
	}

	public void setDescription(List<String> description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ActivitySearch [description=" + description + "]";
	}

}
