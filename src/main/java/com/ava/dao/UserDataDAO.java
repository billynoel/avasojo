package com.ava.dao;

import com.ava.model.UserDataEntity;

public interface UserDataDAO {

	public void insert(UserDataEntity user);
	public UserDataEntity findByUserId(int custId);

}
