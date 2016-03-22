package com.ava.model;


public class UserDataEntity 
{
	int userid; 
	String username; 
	String userstreet; 
	String usercity; 
	String userstate; 
	String userzip;
	
	public UserDataEntity(int userid, String username, String userstreet,
			String usercity, String userstate, String userzip) {

		this.userid = userid; 
		this.username = username; 
		this.userstreet = userstreet; 
		this.usercity = usercity; 
		this.userstate = userstate; 
		this.userzip = userzip;
	
	}
	public int getUserid() {
		return userid;
	}
	public void setUser_id(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserstreet() {
		return userstreet;
	}
	public void setUserstreet(String userstreet) {
		this.userstreet = userstreet;
	}
	public String getUsercity() {
		return usercity;
	}
	public void setUsercity(String usercity) {
		this.usercity = usercity;
	} 
	public String getUserstate() {
		return userstate;
	}
	public void setUserstate(String userstate) {
		this.userstate = userstate;
	}
	public String getUserzip() {
		return userzip;
	}
	public void setUserzip(String userzip) {
		this.userzip = userzip;
	}
	
	public int compare(UserDataEntity inObj) {
		
		// We need to compare all the values for a complete comparison.
		//		
		if(!(this.userid == inObj.userid)) return -1; 
		if(this.username.compareTo(inObj.username) <= 0) return -1; 
		if(this.userstreet.compareTo(inObj.userstreet) <=0) return -1;
		if(this.usercity.compareTo(inObj.usercity) <=0) return -1; 
		if(this.userstate.compareTo(inObj.userstate) <=0) return -1; 
		if(this.userzip.compareTo(inObj.userstate) <=0) return -1;
		return 1;
	}	
}
