package com.avasojo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.avasojo.controller.ChatRoomController;

@Entity
public class Login {
	

	@Id @GeneratedValue
	private Long id;
	private String loginName;
	public Login(String loginName) {
		super();
		this.loginName = loginName;
	}
	public Login() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	@Override
	public String toString() {
		return "Login [id=" + id + ", loginName=" + loginName + "]";
	}

	public void sendMessage(String message){
	      ChatRoomController.showMessage(this,message);
	   }

	@SuppressWarnings("null")
	public int getRollNo() {
		// TODO Auto-generated method stub
		return (Integer) null;
	}
}