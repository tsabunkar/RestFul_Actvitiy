package org.ActivityProj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ActivityProj.model.Activity;
import org.ActivityProj.model.ActivitySearch;
import org.ActivityProj.model.User;

public class ActivityRepoistryImple implements ActivityRepoistry {
	DBConnection db = new DBConnection();

	@Override
	public List<Activity> getAllActivity() throws SQLException, ClassNotFoundException {
		Connection con = db.Connect();
		String sql = "select * from activity_table";
		
		
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		List<Activity> listActivity = new ArrayList<Activity>();
		
		while (rs.next()) {
			Activity activity = new Activity();
			activity.setId(rs.getInt("id"));
			activity.setDescription(rs.getString("description"));
			activity.setDuration(rs.getInt("duration"));
		
			int userid = rs.getInt("userobj_userid");
			activity.setUser( (new ActivityRepoistryImple()).getParticularUser(userid));
			
			listActivity.add(activity);
		}
		con.close();
		return listActivity;

	}
	
	public User getParticularUser(int uid) throws ClassNotFoundException, SQLException{
		
		Connection con = db.Connect();
		String sql = "select * from user_table where uid=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, uid);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		User user = new User();
		user.setUid(uid);
		user.setUname(rs.getString("uname"));
	
		con.close();
		return user;
	
}
	
	@Override
	public Activity getActivity(int myId) throws SQLException, ClassNotFoundException {
		Connection con = db.Connect();
		String sql = "select * from activity_table where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, myId);
		ResultSet rs = ps.executeQuery();
			rs.next();
			Activity activity = new Activity();
			activity.setId(rs.getInt("id"));
			activity.setDescription(rs.getString("description"));
			activity.setDuration(rs.getInt("duration"));
			
			int userid = rs.getInt("userobj_userid");
			activity.setUser( (new ActivityRepoistryImple()) .getParticularUser(userid));
			
			
		con.close();
		return activity;

	}
	
	@Override
	public void createActivity(Activity act) throws SQLException, ClassNotFoundException {
		Connection con = db.Connect();
		String sql = "insert into activity_table value (?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, act.getId());
		ps.setString(2, act.getDescription());
		ps.setInt(3, act.getDuration());
		
		ps.setObject(4, act.getUser());
		
		int i = ps.executeUpdate();
		System.out.println(i +" inserted sucessfully....");
	}
	
	@Override
	public Activity  updateActivityRecord(int givenId,Activity activity) throws SQLException, ClassNotFoundException {
		Connection con = db.Connect();
		String sql = "update activity_table set description=?,duration=? where id=?";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, activity.getDescription());
		ps.setInt(2, activity.getDuration());
		ps.setInt(3,givenId);
		int i = ps.executeUpdate();
		System.out.println(i+" record updated");
		con.close();
		
		activity.setId(givenId);
		return activity;
	}
	
	@Override
	public void deleteActivityRecord(int deleteId) throws SQLException {
		Connection con = db.Connect();
		String sql = "delete from activity_table where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, deleteId);
		int i = ps.executeUpdate();
		System.out.println(i+ " record deleted....");
		con.close();
		}
	
	@Override
	public List<Activity> findByDescription(List<String> ListOfdescription) throws SQLException {
		Connection con = db.Connect();
		List<Activity> listOfActvitiy = new ArrayList<Activity>();
		for (String description : ListOfdescription) {
			System.out.println(" fetched description : " + description);
			String sql = "select * from activity_table where description=? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, description);
			ResultSet rs = ps.executeQuery();

			int count =0;
			while(rs.next()) {
				System.out.println("Executed for : "+ ++count);
				Activity activity = new Activity();
				activity.setId(rs.getInt(1));
				activity.setDescription(rs.getString(2));
				activity.setDuration(rs.getInt(3));
				listOfActvitiy.add(activity);
			}

			
		}//end of forEach loop
		return listOfActvitiy;
	}
	
	
	@Override
	public List<Activity> findByDescription2(ActivitySearch activitySearch)  throws SQLException {
		Connection con = db.Connect();
		List<Activity> listOfActvitiy = new ArrayList<Activity>();
		
		List<String> ListOfdescription =  activitySearch.getDescription();
		
		for (String description : ListOfdescription) {
			System.out.println(" fetched description : " + description);
			String sql = "select * from activity_table where description=? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, description);
			ResultSet rs = ps.executeQuery();

			int count =0;
			while(rs.next()) {
				System.out.println("Executed for : "+ ++count);
				Activity activity = new Activity();
				activity.setId(rs.getInt(1));
				activity.setDescription(rs.getString(2));
				activity.setDuration(rs.getInt(3));
				listOfActvitiy.add(activity);
			}

			
		}//end of forEach loop
		return listOfActvitiy;
	}
	
	
	
	
	
	
}
