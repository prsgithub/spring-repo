/**
 * Copyright © NIC. All rights reserved.

 *
 * This software is the confidential and proprietary information 
 * of NIC.You shall not disclose such Confidential Information and 
 * shall use it only in accordance with the terms and conditions 
 * entered into with NIC.
 *
 * Id: LoginUserDetailsEntity.java,v 1.1
 *
 * Date Author Changes
 * Jul 29, 2017, 11:25:26 PM  prakash Created
 */
package com.sdrc.model;

import java.io.Serializable;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


public class LoginUserModel 
{
	private String userId;
	
	private String password;
	
	private String userName;
	
	private String roleId;

	private Boolean isLocked=false;
	
	private Boolean isActive=true;

	public Boolean getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(Boolean isLocked) {
		this.isLocked = isLocked;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public Boolean isLocked() {
		return isLocked;
	}

	public void setLocked(Boolean isLocked) {
		this.isLocked = isLocked;
	}

	public Boolean isActive() {
		return isActive;
	}

	public void setActive(Boolean isActive) {
		this.isActive = isActive;
	}


	@Override
	public String toString() {
		return "LoginUserDomain [userId=" + userId + ", password=" + password
				+ ", userName=" + userName + ", roleId=" + roleId
				+ ", isLocked=" + isLocked + ", isActive=" + isActive + "]";
	}
	
	

}