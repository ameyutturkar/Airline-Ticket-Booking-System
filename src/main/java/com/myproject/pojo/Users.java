package com.myproject.pojo;

import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
public class Users
{
	@Id
	@GeneratedValue
	@Column(name="userID", unique=true, nullable=false)
	private int userID;
	
	@Column(name="user_name", unique=true, nullable=false)
	private String userName;
	
	@Column(name="user_password")
	private String userPassword;
	
	@Column(name="role_type")
	private String roleType;
	
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
}
