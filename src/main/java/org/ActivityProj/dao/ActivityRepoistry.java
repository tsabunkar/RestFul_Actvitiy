package org.ActivityProj.dao;

import java.sql.SQLException;
import java.util.List;

import org.ActivityProj.model.Activity;

public interface ActivityRepoistry {

	List<Activity> getAllActivity() throws SQLException, ClassNotFoundException;

	Activity getActivity(int myId) throws SQLException, ClassNotFoundException;


	Activity  updateActivityRecord(int givenId,Activity activity) throws SQLException, ClassNotFoundException;

	void createActivity(Activity act) throws SQLException, ClassNotFoundException;

	void deleteActivityRecord(int deleteId) throws SQLException;
}