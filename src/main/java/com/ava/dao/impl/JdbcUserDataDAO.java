package com.ava.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.ava.dao.UserDataDAO;
import com.ava.model.UserDataEntity;

public class JdbcUserDataDAO implements UserDataDAO
{
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(UserDataEntity customer){

		String sql = "INSERT INTO USER_DATA " +
				"(CUST_ID, USERNAME, USERSTREET, USERCITY, USERSTATE, USERZIP) VALUES (?, ?, ?, ?, ?, ?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, customer.getUserid());
			ps.setString(2, customer.getUsername());
			ps.setString(3, customer.getUserstreet());
			ps.setString(4, customer.getUsercity());
			ps.setString(5, customer.getUserstate());
			ps.setString(6, customer.getUserzip());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	public UserDataEntity findByUserId(int custId){

		String sql = "SELECT * FROM USER_DATA WHERE CUST_ID = ?";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, custId);
			UserDataEntity customer = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				customer = new UserDataEntity(
						rs.getInt("CUST_ID"),
						rs.getString("USERNAME"), 
						rs.getString("USERNAME"), 
						rs.getString("USERNAME"), 
						rs.getString("USERNAME"), 
						rs.getString("USERNAME") 
						);
			}
			rs.close();
			ps.close();
			return customer;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
}

