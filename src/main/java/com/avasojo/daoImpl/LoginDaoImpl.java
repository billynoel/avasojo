package com.avasojo.daoImpl;

import java.util.ArrayList;
import java.util.List;

import com.avasojo.entity.Login;

import com.avasojo.dao.LoginDao;

public class LoginDaoImpl implements LoginDao {

	//list is working as a database
	List<Login> Logins;

	public LoginDaoImpl(){
		Logins = new ArrayList<Login>();
		Login login1 = new Login("Robert");
		Login login2 = new Login("John");
		Logins.add(login1);
		Logins.add(login2);		
	}
	@Override
	public void deleteLogin(Login Login) {
		Logins.remove(Login.getRollNo());
		System.out.println("Login: Roll No " + Login.getRollNo() + ", deleted from database");
	}

	//retrive list of Logins from the database
	@Override
	public List<Login> getAllLogins() {
		return Logins;
	}

	@Override
	public void updateLogin(Login Login) {
		Logins.get(Login.getRollNo()).setLoginName(Login.getLoginName());
		System.out.println("Login: Roll No " + Login.getRollNo() + ", updated in the database");
	}
	@Override
	public Login getLogin(int rollNo) {
		// TODO Auto-generated method stub
		return null;
	}
}