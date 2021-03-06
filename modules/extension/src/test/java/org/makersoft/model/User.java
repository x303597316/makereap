/*
 * @(#)User.java 2013-1-31 下午23:33:33
 *
 * Copyright (c) 2011-2013 Makersoft.org all rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 */
package org.makersoft.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.makersoft.web.mvc.json.annotations.JSON;

/**
 * entity for test
 */
public class User implements Serializable {

	private static final long serialVersionUID = -3139777944766406599L;
	
	private Long id;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private Date createdDate;
	
	private Boolean enable;
	
	private Dept dept;
	
	private List<Role> roles = Collections.emptyList();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@JSON(format = "yyyy-MM-dd")
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@JSON(serialize = false)
	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

}
