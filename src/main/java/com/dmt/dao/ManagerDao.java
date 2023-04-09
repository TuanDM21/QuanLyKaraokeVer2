package com.dmt.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dmt.model.Employee;
import com.dmt.model.Manager;

public class ManagerDao {
	public void addNewManager(String username, String password, String fullName, String email, String phoneNumber,
			String address) throws Exception {
		ConnectDB connect = new ConnectDB();
		connect.KetNoi();
		String sql = "INSERT INTO Manager (userName, password, fullName, email, phoneNumber, address) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement cmd = connect.cn.prepareStatement(sql);
		cmd.setString(1, username);
		cmd.setString(2, password);
		cmd.setString(3, fullName);
		cmd.setString(4, email);
		cmd.setString(5, phoneNumber);
		cmd.setString(6, address);
		cmd.executeUpdate();
		connect.cn.close();
	}

	public Manager login(String username, String password) throws Exception {
		ConnectDB connect = new ConnectDB();
		connect.KetNoi();
		String sql = "SELECT * FROM Manager WHERE userName=? AND password=?";
		PreparedStatement stmt = connect.cn.prepareStatement(sql);
		stmt.setString(1, username);
		stmt.setString(2, password);
		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			Manager manager = new Manager();
			manager.setId(rs.getInt("id"));
			manager.setUsername(rs.getString("username"));
			manager.setFullName(rs.getString("fullName"));
			manager.setEmail(rs.getString("email"));
			manager.setPhoneNumber(rs.getString("phoneNumber"));
			manager.setAddress(rs.getString("address"));
			return manager;
		} else {
			return null;
		}
	}
}
