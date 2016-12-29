package com.avasojo.dao;

import java.util.List;

import com.avasojo.entity.Login;

public interface LoginDao {
   public List<Login> getAllLogins();
   public Login getLogin(int rollNo);
   public void updateLogin(Login Login);
   public void deleteLogin(Login Login);
}