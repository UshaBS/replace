package com.cap.dev.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@Column(name="login_id")
	private String userName;
	@Column(name="password")
	private String password;
	@Column(name="role")
	private String role;
}

